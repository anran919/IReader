package com.anakin.ireader;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.anakin.ireader.adapter.ContentPagerAdapter;
import com.anakin.ireader.constants.PagerConfig;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import static com.anakin.ireader.R.id.toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Toolbar.OnMenuItemClickListener {
    private TabLayout mTab;
    private ViewPager mViewPager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 设置一个exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            window.setEnterTransition(new Explode());
            window.setExitTransition(new Explode());
        }
        super.onCreate(savedInstanceState);
        initView();
        initToolbar();
        initViewPager();
        initFloatingActionButton();
    }

    private void initToolbar() {
        // toolbar
        mToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(this);   // toolbar 监听
        mTab = (TabLayout) findViewById(R.id.tabs);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);  //DrawerLayout
        // 左侧菜单的开关监听
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initFloatingActionButton() {
        final View actionB = findViewById(R.id.action_b);
        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("Hide/Show Action above");
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });
        final FloatingActionsMenu fab = (FloatingActionsMenu) findViewById(R.id.fab);
        fab.addButton(actionC);
        final FloatingActionButton actionEnable = (FloatingActionButton) findViewById(R.id.action_enable);
        actionEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setEnabled(!fab.isEnabled());
            }
        });

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_activity_main);
        // 左侧菜单导航的头
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void initViewPager() {
        ContentPagerAdapter pagerAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTab.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(PagerConfig.titles.length); //超出屏幕的限制
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 左侧菜单的点击事件
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String msg = "点击了左侧菜单的";
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            msg += "Click nav_camera";
        } else if (id == R.id.nav_gallery) {
            msg += "Click nav_gallery";
        } else if (id == R.id.nav_slideshow) {
            msg += "Click nav_slideshow";
        } else if (id == R.id.nav_manage) {
            msg += "Click nav_manage";
        } else if (id == R.id.nav_share) {
            msg += "Click nav_share";
        } else if (id == R.id.nav_send) {
            msg += "Click nav_send";
        }

        if (!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 更多菜单的展开menu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 右侧更多选项的点击事件
     *
     * @param menuItem
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        String msg = "右侧更多选项点击了";
        switch (menuItem.getItemId()) {
            case R.id.action_edit:
                msg += " edit";
                break;
            case R.id.action_share:
                msg += " share";
                break;
            case R.id.action_settings:
                msg += " setting";
                break;
        }

        if (!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}

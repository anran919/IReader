package com.anakin.ireader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.anakin.ireader.adapter.ContentPagerAdapter;
import com.anakin.ireader.helper.constants.PagerConfig;
import com.anakin.ireader.ui.activity.BaseActivity;
import com.anakin.ireader.helper.utils.ShareUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import butterknife.Bind;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, Toolbar.OnMenuItemClickListener, View.OnClickListener {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final String TAG = "MainActivity";
    @Bind(R.id.viewpager_activity_main)
    ViewPager mViewPager;
    @Bind(R.id.tabs)
    TabLayout mTab;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.fab_action_share)
    FloatingActionButton mShare;
    @Bind(R.id.fab_action_camera)
    FloatingActionButton mCamera;
    @Bind(R.id.fab)
    FloatingActionsMenu mFatMenu;
    private Bitmap mImageBitmap;


    @Override
    public void initView() {
        // 左侧菜单导航的头
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initToolbar();
        initViewPager();
        initFloatingActionButton();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    private void initToolbar() {
        // toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(this);   // toolbar 监听
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
        mShare.setOnClickListener(this);
        mCamera.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_action_share:
                ShareUtils.getInstance(this).showShare();
                break;
            case R.id.fab_action_camera:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d(TAG," request code "+ requestCode);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            mImageBitmap = (Bitmap) extras.get("data");
            Log.d(TAG," mImageBitmap"+ mImageBitmap.toString());
//            mThumbView.setImageBitmap(mImageBitmap);
        }
    }

}

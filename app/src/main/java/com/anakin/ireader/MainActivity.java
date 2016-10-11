package com.anakin.ireader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Toolbar.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEvent();
    }

    private void initEvent() {


    }

    private void initView() {
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);  //悬浮按钮

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);    // toolbar
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "我是SnackBar ^_^", Snackbar.LENGTH_LONG)
                        .setAction("设置Action", null).show();
            }
        });

        toolbar.setOnMenuItemClickListener(this);   // toolbar 监听

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);  //DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

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


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {    //设置按钮
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String msg="";
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

        if(!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     *
     */
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        String msg = "";
        switch (menuItem.getItemId()) {
            case R.id.action_edit:
                msg += "Click edit";
                break;
            case R.id.action_share:
                msg += "Click share";
                break;
            case R.id.action_settings:
                msg += "Click setting";
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}

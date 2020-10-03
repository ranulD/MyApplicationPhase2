package com.example.ranul.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ranul.myapplication.Fragments.AddsFragment;
import com.example.ranul.myapplication.Fragments.FavouritesFragment;
import com.example.ranul.myapplication.Fragments.HistoryFragment;
import com.example.ranul.myapplication.Fragments.SettingsFragment;
import com.example.ranul.myapplication.Fragments.YourAccountFragment;

public class Welcome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //nav bar
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /*
        //GridView
        GridView gridView = (GridView)findViewById(R.id.gridView);

        gridView.setAdapter(new ImageAdapter(this));

        */

        mToolBar = (Toolbar)findViewById(R.id.nav_action);
        setSupportActionBar(mToolBar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        //fragments
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.nav_open, R.string.nav_close);

        //navPanel
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();


        //navPanel
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //fragments
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_favourites:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FavouritesFragment()).commit();
                break;

            case R.id.nav_History:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HistoryFragment()).commit();
                break;

            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;

            case R.id.nav_RemoveAdds:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AddsFragment()).commit();
                break;

            case R.id.nav_yourAcc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new YourAccountFragment()).commit();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}

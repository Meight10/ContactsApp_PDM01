package com.meight.contactsapp2;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<Personajes> charactersListModels0;
    public static ArrayList<Personajes> charactersListModels1;

    public static PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            charactersListModels0 = new ArrayList<>();
            charactersListModels1 = new ArrayList<>();

            createCharactersListModes0();
        }


        initComponents();

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initComponents(){

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        //tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_1));
        //tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_2));

        List_Fragment fragment1 = List_Fragment.newInstance("s0", charactersListModels0);
        List_Fragment fragment2 = List_Fragment.newInstance("s1", charactersListModels1);
        System.out.println(charactersListModels1.toString() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        adapter = new PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(fragment1, getString(R.string.tab_text_1));
        adapter.addFragment(fragment2, getString(R.string.tab_text_2));
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }


}

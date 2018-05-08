package com.meight.contactsapp2;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.meight.contactsapp2.adapters.PagerAdapter;
import com.meight.contactsapp2.fragments.FragmentContacts;
import com.meight.contactsapp2.models.ContactModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<ContactModel> contacts;
    public static ArrayList<ContactModel> contactsFav;

    public static PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            contacts = new ArrayList<>();
            contactsFav = new ArrayList<>();

            fillContacts();
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

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        //tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_1));
        //tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_2));

        FragmentContacts fragment1 = FragmentContacts.newInstance("0", contacts);
        FragmentContacts fragment2 = FragmentContacts.newInstance("1", contactsFav);
        System.out.println(contactsFav.toString() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        adapter = new PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(fragment1, getString(R.string.tab_text_1));
        adapter.addFragment(fragment2, getString(R.string.tab_text_2));
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }


}

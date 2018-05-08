package com.meight.contactsapp2;

import android.database.Cursor;
import android.provider.ContactsContract;
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

public class MainActivity extends AppCompatActivity implements FragmentContacts.OnListFragmentInteractionListener, FragmentContacts.OnListFragmentInteractionIcon{


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

    @Override
    public void onListFragmentInteraction(ContactModel item) {

    }

    @Override
    public void onListFragmentInteractionIcon(ContactModel contact, int position) {
        int index = contacts.indexOf(contact);
        if(contact.getFavorite()){
            contactsFav.remove(contacts.get(index));
            contacts.get(index).setFavorite(false);
            System.out.println("CHANGEED TO FALSE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            adapter.notifyDataSetChanged();
        }else{
            contactsFav.add(contacts.get(index));
            contacts.get(index).setFavorite(true);
            System.out.println("CHANGEED TO TRUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            adapter.notifyDataSetChanged();
        }
    }

    private void fillContacts(){

        Cursor cursor = this.getContentResolver().query(ContactsContract.
                        CommonDataKinds.Phone.CONTENT_URI, null,
                null, null, ContactsContract.Contacts.DISPLAY_NAME
                        + " ASC");


        cursor.moveToFirst();
        while(cursor.moveToNext()){

            contacts.add(new ContactModel(cursor.getString(cursor.getColumnIndex(ContactsContract.
                    CommonDataKinds.Phone.DISPLAY_NAME)), cursor.getString(cursor.getColumnIndex(ContactsContract.
                    CommonDataKinds.Phone.NUMBER)), false));

        }

    }
}

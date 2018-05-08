package com.meight.contactsapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.meight.contactsapp2.fragments.FragmentContacts;
import com.meight.contactsapp2.models.ContactModel;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    TextView nameTxtView;
    TextView numberTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_show);

        nameTxtView = findViewById(R.id.name_txt_view);
        numberTxtView = findViewById(R.id.number_txtView);

        Intent intent = getIntent();
        ContactModel contact = (ContactModel) intent.getParcelableExtra("extra");

        nameTxtView.setText(contact.getName());
        numberTxtView.setText(contact.getNumber());


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }



}

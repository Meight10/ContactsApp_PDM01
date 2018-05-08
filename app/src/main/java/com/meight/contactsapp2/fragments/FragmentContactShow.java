package com.meight.contactsapp2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.meight.contactsapp2.models.ContactModel;

import java.util.ArrayList;

public class FragmentContactShow extends Fragment {

    private ContactModel contact;

    public FragmentContactShow(){}

    public static FragmentContactShow newInstance(ContactModel contact) {
        FragmentContactShow fragment = new FragmentContactShow();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
}

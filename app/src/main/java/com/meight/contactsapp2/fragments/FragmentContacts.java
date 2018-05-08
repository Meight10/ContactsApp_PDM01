package com.meight.contactsapp2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meight.contactsapp2.R;
import com.meight.contactsapp2.adapters.ContactsRvAdapter;
import com.meight.contactsapp2.models.ContactModel;

import java.util.ArrayList;

public class FragmentContacts extends Fragment{

    private OnListFragmentInteractionListener interactionListener;
    private OnListFragmentInteractionIcon interactionIcon;

    private ContactsRvAdapter contactsAdapter;
    private ViewPager vp;

    private String type;
    private ArrayList<ContactModel> contacts;
    private ArrayList<ContactModel> contactsFav;

    public FragmentContacts(){}

    public static FragmentContacts newInstance(String type, ArrayList<ContactModel> contactsModel) {
        FragmentContacts fragment = new FragmentContacts();
        Bundle args = new Bundle();
        args.putString("type", type);
        args.putParcelableArrayList(type, contactsModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if (getArguments() == null) {
            throw new RuntimeException("You must to send a dummyModels ");
        }
        contacts = getArguments().getParcelableArrayList("0");
        contactsFav = getArguments().getParcelableArrayList("1");
        type = (String) getArguments().getString("type");


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.from(container.getContext()).inflate(R.layout.fragment_contacts, container, false);
        Bundle args = new Bundle();
        Context ctx = rootView.getContext();
        RecyclerView recyclerView = (RecyclerView)rootView;
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        vp = (ViewPager)getActivity().findViewById(R.id.viewPager);
        contactsAdapter = new ContactsRvAdapter(getList(), interactionListener, interactionIcon);
        recyclerView.setAdapter(contactsAdapter);

        return rootView;
    }

    private ArrayList<ContactModel> getList(){
        if(type == "0"){
            return contacts;
        }else
            return contactsFav;

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //la actividad debe implementart OnListFragmentInteractionListener
        if(context instanceof OnListFragmentInteractionListener){
            interactionListener =  (OnListFragmentInteractionListener) context;
            interactionIcon = (OnListFragmentInteractionIcon)context;
        }else{
            throw new RuntimeException(context.toString() + "debe implementar OnlistFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach(){
        super.onDetach();
        interactionListener = null;
        interactionIcon = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(ContactModel item);
    }

    public interface OnListFragmentInteractionIcon{
        void onListFragmentInteractionIcon(ContactModel item, int position);
    }


}

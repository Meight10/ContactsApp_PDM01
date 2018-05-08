package com.meight.contactsapp2.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meight.contactsapp2.R;
import com.meight.contactsapp2.models.ContactModel;

import java.util.ArrayList;

public class ContactsRvAdapter extends RecyclerView.Adapter<ContactsRvAdapter.ViewHolderContacts> {


    private ViewPager viewPager;

    private ArrayList<ContactModel> listContacts;

    public ContactsRvAdapter(ArrayList<ContactModel> listContacts){
        this.listContacts= listContacts;
    }

    @NonNull
    @Override
    public ViewHolderContacts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts, parent, false);

        return new ViewHolderContacts(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContacts holder, int position) {

        holder.name.setText(listContacts.get(position).getName());
        holder.number.setText(listContacts.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }

    public class ViewHolderContacts extends RecyclerView.ViewHolder {

        public final TextView name, number;

        public ViewHolderContacts(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_txtV);
            number = itemView.findViewById(R.id.number_txtV);
        }
    }
}

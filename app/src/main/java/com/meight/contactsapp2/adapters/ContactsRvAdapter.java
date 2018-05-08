package com.meight.contactsapp2.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meight.contactsapp2.R;
import com.meight.contactsapp2.fragments.FragmentContacts;
import com.meight.contactsapp2.models.ContactModel;

import java.util.ArrayList;

public class ContactsRvAdapter extends RecyclerView.Adapter<ContactsRvAdapter.ViewHolderContacts> {


    private final FragmentContacts.OnListFragmentInteractionListener interactionListener;
    private final FragmentContacts.OnListFragmentInteractionIcon interactionIcon;

    private ViewPager viewPager;

    private ArrayList<ContactModel> listContacts;

    public ContactsRvAdapter(ArrayList<ContactModel> listContacts, FragmentContacts.OnListFragmentInteractionListener interactionListener,
    FragmentContacts.OnListFragmentInteractionIcon interactionIcon){
        this.listContacts= listContacts;
        this.interactionListener = interactionListener;
        this.interactionIcon = interactionIcon;
    }

    @NonNull
    @Override
    public ViewHolderContacts onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts, parent, false);

        return new ViewHolderContacts(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderContacts holder, final int position) {

        holder.name.setText(listContacts.get(position).getName());
        holder.number.setText(listContacts.get(position).getNumber());

        if (listContacts.get(position).getFavorite()) {
            holder.favoriteIcon.setImageResource(R.drawable.ic_star_selected);
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.ic_star_unselected);
        }


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != interactionListener) {
                    interactionListener.onListFragmentInteraction(listContacts.get(position));
                }
            }
        });

        holder.favoriteIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("InteractionIconEvent" + position + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                interactionIcon.onListFragmentInteractionIcon(listContacts.get(position), position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }

    public class ViewHolderContacts extends RecyclerView.ViewHolder {

        public final TextView name, number;
        public final ImageView favoriteIcon;
        public final View view;

        public ViewHolderContacts(View itemView) {
            super(itemView);

            view = itemView;
            name = (TextView)itemView.findViewById(R.id.name_txtV);
            number = (TextView)itemView.findViewById(R.id.number_txtV);

            favoriteIcon = (ImageView)itemView.findViewById(R.id.ic_favorites);
        }
    }
}

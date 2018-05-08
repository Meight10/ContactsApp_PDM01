package com.meight.contactsapp2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactModel implements Parcelable {

    private String name, number;

    private boolean favorite;

    public ContactModel(String name, String number, boolean favorite) {
        this.name = name;
        this.number = number;
        this.favorite = favorite;
    }

    public ContactModel(){}




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}

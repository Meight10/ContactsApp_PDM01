package com.meight.contactsapp2.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactModel implements Parcelable {

    private String name, number;

    public ContactModel(String name, String number) {
        this.name = name;
        this.number = number;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}

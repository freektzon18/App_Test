package com.example.app_test.data.response;

import android.os.Parcel;
import android.os.Parcelable;

public class Categories implements Parcelable {

    private String alias;
    private String title;

    protected Categories(Parcel in) {
        alias = in.readString();
        title = in.readString();
    }

    public static final Creator<Categories> CREATOR = new Creator<Categories>() {
        @Override
        public Categories createFromParcel(Parcel in) {
            return new Categories(in);
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "alias='" + alias + '\'' +
                "el ='" + "fuaaaaaaaaaa" + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(alias);
        parcel.writeString(title);
    }
}

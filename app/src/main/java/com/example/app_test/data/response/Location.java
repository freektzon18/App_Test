package com.example.app_test.data.response;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String country;
    private String[] display_address;
    private String state;
    private String zip_code;

    protected Location(Parcel in) {
        address1 = in.readString();
        address2 = in.readString();
        address3 = in.readString();
        city = in.readString();
        country = in.readString();
        display_address = in.createStringArray();
        state = in.readString();
        zip_code = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getDisplay_address() {
        return display_address;
    }

    public void setDisplay_address(String[] display_address) {
        this.display_address = display_address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @Override
    public String toString() {
        return "Location{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", display_address='" + display_address + '\'' +
                ", state='" + state + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(address1);
        parcel.writeString(address2);
        parcel.writeString(address3);
        parcel.writeString(city);
        parcel.writeString(country);
        parcel.writeStringArray(display_address);
        parcel.writeString(state);
        parcel.writeString(zip_code);
    }
}

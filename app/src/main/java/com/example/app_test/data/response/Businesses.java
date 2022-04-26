package com.example.app_test.data.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;


public class Businesses implements Parcelable {
    private Categories[] categories;
    private Coordinates coordinates;
    private String display_phone;
    private double distance;
    private String id;
    private String alias;
    private String image_url;
    private boolean is_closed;
    private Location location;
    private String name;
    private String phone;
    private String price;
    private double rating;
    private int review_count;
    private String url;
    private String[] transactions;

    private double latitud;
    private double longitud;

    protected Businesses(Parcel in) {
        display_phone = in.readString();
        distance = in.readDouble();
        latitud = in.readDouble();
        longitud = in.readDouble();
        id = in.readString();
        alias = in.readString();
        image_url = in.readString();
        is_closed = in.readByte() != 0;
        name = in.readString();
        phone = in.readString();
        price = in.readString();
        rating = in.readDouble();
        review_count = in.readInt();
        url = in.readString();
        transactions = in.createStringArray();
    }

    public static final Creator<Businesses> CREATOR = new Creator<Businesses>() {
        @Override
        public Businesses createFromParcel(Parcel in) {
            return new Businesses(in);
        }

        @Override
        public Businesses[] newArray(int size) {
            return new Businesses[size];
        }
    };

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getDisplay_phone() {
        return display_phone;
    }

    public void setDisplay_phone(String display_phone) {
        this.display_phone = display_phone;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public Categories[] getCategories() {
        return categories;
    }

    public void setCategories(Categories[] categories) {
        this.categories = categories;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


    public String getCategorias(){
        StringBuilder appendCategorie = new StringBuilder();
        if(this.categories!=null){
            for(Categories categorie : this.categories){
                appendCategorie.append(categorie.getAlias());
                appendCategorie.append(" ");
                appendCategorie.append(",");
                appendCategorie.append(categorie.getTitle());
            }
        }
        return appendCategorie.toString();
    }

    @Override
    public String toString() {
        return "Businesses{" +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", categories='" + Arrays.toString(categories )+ '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", price='" + price + '\'' +
                ", rating='" + rating + '\'' +

                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(display_phone);
        parcel.writeDouble(distance);
        parcel.writeDouble(latitud);
        parcel.writeDouble(longitud);
        parcel.writeString(id);
        parcel.writeString(alias);
        parcel.writeString(image_url);
        parcel.writeByte((byte) (is_closed ? 1 : 0));
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeString(price);
        parcel.writeDouble(rating);
        parcel.writeInt(review_count);
        parcel.writeString(url);
        parcel.writeStringArray(transactions);
    }
}

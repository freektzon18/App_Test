package com.example.app_test.data.request;

public class RequestSearch {

    private String term;
    private String location;
    private String categories;
    private String locale;
    private String sort_by;
    private String price;
    private String attributes;
    private double latitude;
    private double longitude;
    private int radius;
    private int offset;
    private int limit;
    private int open_at;
    private boolean open_now;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getSort_by() {
        return sort_by;
    }

    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOpen_at() {
        return open_at;
    }

    public void setOpen_at(int open_at) {
        this.open_at = open_at;
    }

    public boolean isOpen_now() {
        return open_now;
    }

    public void setOpen_now(boolean open_now) {
        this.open_now = open_now;
    }

    @Override
    public String toString() {
        return "RequestSearch{" +
                "term='" + term + '\'' +
                ", location='" + location + '\'' +
                ", categories='" + categories + '\'' +
                ", locale='" + locale + '\'' +
                ", sort_by='" + sort_by + '\'' +
                ", price='" + price + '\'' +
                ", attributes='" + attributes + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", radius=" + radius +
                ", offset=" + offset +
                ", limit=" + limit +
                ", open_at=" + open_at +
                ", open_now=" + open_now +
                '}';
    }
}

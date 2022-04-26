package com.example.app_test.data.response;

public class Region {

    private Center center;

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "Region{" +
                "center=" + center +
                '}';
    }
}

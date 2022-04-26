package com.example.app_test.data.response;

import java.util.Arrays;
import java.util.List;

public class ResponseSearch {

    private int total;
    private List<Businesses> businesses;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Businesses> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Businesses> businesses) {
        this.businesses = businesses;
    }

    @Override
    public String toString() {
        return "ResponseSearch{" +
                "total=" + total +
                '}';
    }
}

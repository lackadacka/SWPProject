package com.rentalsystem.swp.POSTResponds;

import lombok.Data;

@Data
public class SearchData {
    private String text;
    private String category;
    private String timeSlots;
    private String sort;
    //private int price;
    //private String owner;
}

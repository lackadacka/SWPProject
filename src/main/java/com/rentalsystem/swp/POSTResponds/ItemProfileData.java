package com.rentalsystem.swp.POSTResponds;

import lombok.Data;

@Data
public class ItemProfileData {
    private long id;
    private String name;
    private String description;
    private String timeSlots;
    private String category;
    private String owner;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTimeSlots() {
        return timeSlots;
    }

    public String getCategory() {
        return category;
    }

    public String getOwner() {
        return owner;
    }
}

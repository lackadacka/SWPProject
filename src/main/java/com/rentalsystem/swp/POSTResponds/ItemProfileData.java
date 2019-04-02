package com.rentalsystem.swp.POSTResponds;

import lombok.Data;

@Data
public class ItemProfileData {
    private long id;
    private String name;
    private String description;
    private String timeSlots;
    private String category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(String timeSlots) {
        this.timeSlots = timeSlots;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }
}

package com.rentalsystem.swp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ItemProfile {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String timeSlots;
    private Integer price;
    private String category;
    private String owner;

    public ItemProfile(String name, String description, String timeSlots, Integer price, String category, String owner) {
        this.name = name;
        this.description = description;
        this.timeSlots = timeSlots;
        this.price = price;
        this.category = category;
        this.owner = owner;
    }
}

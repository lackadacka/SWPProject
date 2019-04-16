package com.rentalsystem.swp.POSTResponds;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ItemProfileData {
    private Integer id;
    private String name;
    private String description;
    private String timeSlots;
    private int price;
    private String category;
    private String owner;
    private MultipartFile file;
}

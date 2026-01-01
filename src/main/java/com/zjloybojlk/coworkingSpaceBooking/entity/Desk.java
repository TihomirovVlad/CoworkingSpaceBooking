package com.zjloybojlk.coworkingSpaceBooking.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Desk {

    private Integer id;
    private String deskNumber; // example: "C123" "X012"
    private String description;
    private String type;
    private BigDecimal pricePerHour;
    private Boolean isOccupied;
    private LocalDateTime createdAt;

    public Desk() {
        this.type = "STANDARD";
        this.isOccupied = true;
        this.createdAt = LocalDateTime.now();
    }

    public Desk(String deskNumber, String description, BigDecimal pricePerHour) {
        this();
        this.deskNumber = deskNumber;
        this.description = description;
        this.pricePerHour = pricePerHour;
    }

    //add String getOccupiedStatus,String getFormattedPrice, getters/setters, toString

}

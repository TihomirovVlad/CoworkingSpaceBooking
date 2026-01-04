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

    public String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getOccupiedStatus() {
        return isOccupied ? "Occupied" : "Free";
    }
    public String getFormattedPrice(){

        return pricePerHour + "rub/hour";
    }

    @Override
    public String toString() {
        return "Desk #" + deskNumber + " - " + description +
                " (" + getFormattedPrice() + ", " + getOccupiedStatus() + ")";
    }

}

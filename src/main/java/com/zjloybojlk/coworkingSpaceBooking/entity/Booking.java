package com.zjloybojlk.coworkingSpaceBooking.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class Booking {

    private Integer id;
    private int userId;
    private int deskId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal totalPrice;
    private String status;
    private LocalDateTime createdAt;


    private User user;
    private Desk desk;

    public Booking() {
        this.status = "ACTIVE";
        this.createdAt = LocalDateTime.now();
    }

    public Booking(Integer userId, Integer deskId,
                   LocalDateTime startTime, LocalDateTime endTime) {
        this();
        this.userId = userId;
        this.deskId = deskId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public long getDurationInHours() {
        if (startTime == null || endTime == null) return 0;
        return Duration.between(startTime, endTime).toHours();
    }

    public boolean isActive() {
        return status.equals("ACTIVE");
    }

    public boolean isCompleted() {
        return status.equals("COMPLETED");
    }

    public boolean isCancelled() {
        return status.equals("CANCELLED");
    }

    public String getFormattedDuration() {

        long duration = getDurationInHours();
        return duration + "hour" + (duration > 1 ? "s" : "");
    }
}

package domain;

import java.util.Date;

// 租车订单
public class RentalOrder {
    // 租车订单id
    private String orderId;

    // 租车id
    private Integer carId;

    // 用户id
    private Integer userId;

    // 租车的开始时间
    private String rentalBeginTime;

    // 租车的结束时间
    private String rentalEndTime;

    // 租车订单状态 预定中 已提车 使用中 已归还
    private Integer orderState;

    // 订单时间
    private Date orderTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getRentalBeginTime() {
        return rentalBeginTime;
    }

    public void setRentalBeginTime(String rentalBeginTime) {
        this.rentalBeginTime = rentalBeginTime;
    }

    public String getRentalEndTime() {
        return rentalEndTime;
    }

    public void setRentalEndTime(String rentalEndTime) {
        this.rentalEndTime = rentalEndTime;
    }
}

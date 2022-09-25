package service.request;

import java.util.Date;

public class RentalCarRequest {
    // 用户id
    private Integer userId;

    // 车的型号
    private String carModel;

    // 租车的开始时间
    private Date rentalBeginTime;

    // 租车的结束时间
    private Date rentalEndTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getRentalBeginTime() {
        return rentalBeginTime;
    }

    public void setRentalBeginTime(Date rentalBeginTime) {
        this.rentalBeginTime = rentalBeginTime;
    }

    public Date getRentalEndTime() {
        return rentalEndTime;
    }

    public void setRentalEndTime(Date rentalEndTime) {
        this.rentalEndTime = rentalEndTime;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "RentalCarRequest{" +
                "userId=" + userId +
                ", carModel='" + carModel + '\'' +
                ", rentalBeginTime=" + rentalBeginTime +
                ", rentalEndTime=" + rentalEndTime +
                '}';
    }
}

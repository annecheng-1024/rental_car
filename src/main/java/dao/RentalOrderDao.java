package dao;

import domain.RentalOrder;
import utils.JDBCUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RentalOrderDao {

    public int insertRentalOrder(RentalOrder rentalOrder) {

        String sql = "insert into rental_order values ('#order_id',#car_id,#user_id,'#rental_begin_time','#rental_end_time',1,sysdate())"
                .replace("#order_id", buildOrderId(rentalOrder.getUserId()))
                .replace("#car_id", rentalOrder.getCarId().toString())
                .replace("#user_id",rentalOrder.getUserId().toString())
                .replace("#rental_begin_time", rentalOrder.getRentalEndTime())
                .replace("#rental_end_time", rentalOrder.getRentalEndTime());

        JDBCUtils jdbcUtils = new JDBCUtils();
        try {
             return jdbcUtils.statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close();
        }
        return 0;
    }

    // O + 时间 + userId + 随机数
    private String buildOrderId(Integer userId) {
        Random random = new Random();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return  "O" + simpleDateFormat.format(new Date()) + userId + random.nextInt(1000);
    }

}

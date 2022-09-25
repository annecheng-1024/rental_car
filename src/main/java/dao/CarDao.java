package dao;

import domain.Car;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarDao {

    public Car selectFreeCarByCarModel(String carModel) {
        String sql = "select * from car where car_model = '#carModel' and car_stock > 0".replace("#carModel", carModel);
        List<Car> carList = new ArrayList<Car>();
        JDBCUtils jdbcUtils = new JDBCUtils();
        try {
            ResultSet resultSet = jdbcUtils.statement.executeQuery(sql);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setCarModel(resultSet.getString("car_model"));
                car.setCarStock(resultSet.getInt("car_stock"));
                car.setVersion(resultSet.getInt("version"));
                carList.add(car);
            }
            if (CollectionUtils.isEmpty(carList)) {
                return null;
            }
            return carList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.close();
        }
        return null;
    }

    public int updateCarByCarModel(Integer id, Integer version) {
        String sql = "update car set car_stock = car_stock - 1, version = version + 1 where id = #id and version = #version"
                .replace("#id",id.toString()).replace("#version",version.toString());

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

}

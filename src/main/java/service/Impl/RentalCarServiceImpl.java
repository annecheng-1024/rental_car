package service.Impl;

import dao.CarDao;
import dao.RentalOrderDao;
import domain.Car;
import domain.RentalOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import service.RentalCarService;
import service.request.RentalCarRequest;
import service.result.RentalCarResult;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("rentalCarService")
public class RentalCarServiceImpl implements RentalCarService {

    // 参数校验
    private boolean checkRentalCarRequest(RentalCarRequest request) {
        if (request == null
                || request.getUserId() == null || StringUtils.isEmpty(request.getCarModel())
                || request.getRentalBeginTime() == null
                || request.getRentalEndTime() == null) {
            return false;
        }

        Date now = new Date();
        if(request.getRentalEndTime().before(request.getRentalBeginTime())
                || request.getRentalBeginTime().before(now)
                || request.getRentalEndTime().before(now)) {
            System.out.println("rental time is error.");
            return false;
        }
        return true;
    }

    public RentalCarResult rentalCar(RentalCarRequest request) {
        CarDao carDao = new CarDao();
        RentalOrderDao rentalOrderDao = new RentalOrderDao();
        System.out.println("RentalCarServiceImpl rentalCar #request:" + request.toString());

        RentalCarResult result = new RentalCarResult();
        // check request
        if(!this.checkRentalCarRequest(request)) {
            System.out.println("RentalCarServiceImpl rentalCar error(request is error),please check." + request.toString());
            result.setRental(false);
            result.setFailureReason("request is error.");
            return result;
        }
        // check ca
        // rStock
        Car car = carDao.selectFreeCarByCarModel(request.getCarModel());

        if (car == null) {
            System.out.println("There are no more cars to rent.");
            result.setRental(false);
            result.setFailureReason("no more cars to rent.");
            return result;
        }

        // reduce carStock
        int carReduceStock = carDao.updateCarByCarModel(car.getId(), car.getVersion());
        if (carReduceStock != 1) {
            System.out.println("There are no more cars to rent.");
            result.setRental(false);
            result.setFailureReason("no more cars to rent.");
            return result;
        }

        // add rental order
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        RentalOrder insert = new RentalOrder();
        insert.setUserId(request.getUserId());
        insert.setCarId(car.getId());
        insert.setRentalBeginTime(simpleDateFormat.format(request.getRentalBeginTime()));
        insert.setRentalEndTime(simpleDateFormat.format(request.getRentalEndTime()));
        insert.setOrderTime(new Date());
        int rentalOrderResult = rentalOrderDao.insertRentalOrder(insert);

        if (rentalOrderResult > 0) {
            result.setRental(true);
            return result;
        }
        result.setRental(false);
        result.setFailureReason("rental order error.");
        return result;
    }



}

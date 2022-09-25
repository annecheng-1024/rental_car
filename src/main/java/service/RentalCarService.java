package service;

import service.request.RentalCarRequest;
import service.result.RentalCarResult;

/*
租车服务接口
 */
public interface RentalCarService {

    /**
     * @param request 接口请求
     * @return 返回是否租车成功或租车失败原因
     */
    RentalCarResult rentalCar(RentalCarRequest request);
}

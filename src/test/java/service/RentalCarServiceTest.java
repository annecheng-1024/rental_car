package service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.request.RentalCarRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ContextConfiguration("classpath:ApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RentalCarServiceTest {

    @Autowired
    private RentalCarService rentalCarService;

    // 测试参数缺失
    @Test
    public void testLoseRequest() {
        RentalCarRequest request = new RentalCarRequest();
        request.setUserId(1234);
        System.out.println(rentalCarService.rentalCar(request).toString());
    }

    // 开始时间晚于结束时间
    @Test
    public void testRentalTimeError() throws ParseException {
        RentalCarRequest request = new RentalCarRequest();
        request.setUserId(1234);
        request.setCarModel("Toyota Camry");
        request.setRentalBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-09-25 00:00:00"));
        request.setRentalEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-09-24 00:00:00"));
        System.out.println(rentalCarService.rentalCar(request));
    }

    // 正常预定流程
    @Test
    public void testRentalCar() throws ParseException {
        RentalCarRequest request = new RentalCarRequest();
        request.setUserId(1234);
        request.setCarModel("Toyota Camry");
        request.setRentalBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-09-26 00:00:00"));
        request.setRentalEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-10-04 00:00:00"));
        System.out.println(rentalCarService.rentalCar(request));
    }

    @Test
    public void testRentalCarMore() throws ParseException {
        ExecutorService pool = Executors.newCachedThreadPool();
        final int count = 50;
        CountDownLatch countDownLatch = new CountDownLatch(count);//与countDownLatch.await();实现运行完所有线程之后才执行后面的操作
        for(int i = 0; i < count; i++){
            RentalCarRequest request = new RentalCarRequest();
            request.setUserId(10001);
            request.setCarModel("Toyota Camry");
            request.setRentalBeginTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-09-26 00:00:00"));
            request.setRentalEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-10-09 00:00:00"));
            pool.execute(new MyThread(request));
        }
        pool.shutdown();
        try {
            countDownLatch.await();  //这一步是为了将全部线程任务执行完以后，开始执行后面的任务（计算时间，数量）
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class MyThread implements Runnable {
        private final RentalCarRequest para;
        public MyThread(RentalCarRequest para) {
            this.para = para;
        }
        public void run() {
            try{
                rentalCarService.rentalCar(para);
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }

}

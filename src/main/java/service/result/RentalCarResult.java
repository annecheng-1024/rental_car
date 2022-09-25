package service.result;

public class RentalCarResult {
    // 租车是否成功
    private boolean rental;

    // 失败原因
    private String failureReason;


    public boolean isRental() {
        return rental;
    }

    public void setRental(boolean rental) {
        this.rental = rental;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    @Override
    public String toString() {
        return "RentalCarResult{" +
                "rental=" + rental +
                ", failureReason='" + failureReason + '\'' +
                '}';
    }
}

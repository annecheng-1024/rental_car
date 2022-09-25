package domain;

import java.util.Date;

public class Car {
    // 车的编码
    private Integer id;

    // 车型
    private String carModel;

    // 当前可用库存
    private Integer carStock;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date modifyTime;

    // 当前版本号
    private Integer version;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarStock() {
        return carStock;
    }

    public void setCarStock(Integer carStock) {
        this.carStock = carStock;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", carStock=" + carStock +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", version=" + version +
                '}';
    }
}

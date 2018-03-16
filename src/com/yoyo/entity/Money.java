package com.yoyo.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/1 0001.
 */




public class Money {
    /**
     * 单证号
     */
    private String documentNumber;
    /**
     * 承运人
     */
    private String carrier;
    /**
     * 车辆牌照号
     */
    private String vehicleNumber;
    /**
     * 牌照类型代码
     */
    private String licensePlateTypeCode;
    /**
     * 运单列表
     */
    private List<ShippingNote> shippingNoteList;
    /**
     * 财务列表
     */
    private List<Financial> financiallist;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getLicensePlateTypeCode() {
        return licensePlateTypeCode;
    }

    public void setLicensePlateTypeCode(String licensePlateTypeCode) {
        this.licensePlateTypeCode = licensePlateTypeCode;
    }

    public List<ShippingNote> getShippingNoteList() {
        return shippingNoteList;
    }

    public void setShippingNoteList(List<ShippingNote> shippingNoteList) {
        this.shippingNoteList = shippingNoteList;
    }

    public List<Financial> getFinanciallist() {
        return financiallist;
    }

    public void setFinanciallist(List<Financial> financiallist) {
        this.financiallist = financiallist;
    }


}

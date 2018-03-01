package com.yoyo.entity;

import java.util.List;

/**
 * 发送报文的内容
 * Created by Administrator on 2018/1/10 0010.
 */
public class Message {
    private String originalDocumentNumber;          //原始单号
    private String shippingNoteNumber;              //托运单号
    private String carrier;                         //承运人
    private String unifiedSocialCreditIdentifier;   //统一社会信用代码  选填
    private String permitNumber;                    //许可证编号 选填
    private String businessTypeCode;                //业务类型
    private String despatchActualDateTime;          //发运实际日期时间
    private String goodsReceiptDateTime;            //收货日期时间
    private String consignor;                       //发货人   选填
    private String personalIdentityDocument;        //个人证件
    private String placeOfLoading;                  //装货详细地点 选填
    private String countrySubdivisionCode;          //装货地区
    private String consignee;                       //收货人   选填
    private String goodsReceiptPlace;               //收货详细地点    选填
    private String countrySubdivisionCode1;         //收货地区
    private String totalMonetaryAmount;             //货币总金额
    private String licensePlateTypeCode;            //牌照类型
    private String vehicleNumber;                   //车辆牌照号
    private String vehicleClassificationCode;       //车辆分类
    private String vehicleTonnage;                  //车辆载质量
    private String roadTransportCertificateNumber;  //道路运输证号
    private String trailerVehiclePlateNumber;       //挂车牌照号      选填
    private String owner;                           //车辆所有人      选填
    private String permitNumber1;                   //许可证编号      选填
    private List<Driver> drivers;                    //驾驶员          选填
    private String descriptionOfGoods;              //货物名称
    private String cargoTypeClassificationCode;     //货物类型
    private String goodsItemGrossWeight;            //货物项毛重
    private String cube;                            //体积            选填
    private String totalNumberOfPackages;           //总件数          选填


    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public String getUnifiedSocialCreditIdentifier() {
        return unifiedSocialCreditIdentifier;
    }

    public void setUnifiedSocialCreditIdentifier(String unifiedSocialCreditIdentifier) {
        this.unifiedSocialCreditIdentifier = unifiedSocialCreditIdentifier;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public String getPersonalIdentityDocument() {
        return personalIdentityDocument;
    }

    public void setPersonalIdentityDocument(String personalIdentityDocument) {
        this.personalIdentityDocument = personalIdentityDocument;
    }

    public String getPlaceOfLoading() {
        return placeOfLoading;
    }

    public void setPlaceOfLoading(String placeOfLoading) {
        this.placeOfLoading = placeOfLoading;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getGoodsReceiptPlace() {
        return goodsReceiptPlace;
    }

    public void setGoodsReceiptPlace(String goodsReceiptPlace) {
        this.goodsReceiptPlace = goodsReceiptPlace;
    }

    public String getTrailerVehiclePlateNumber() {
        return trailerVehiclePlateNumber;
    }

    public void setTrailerVehiclePlateNumber(String trailerVehiclePlateNumber) {
        this.trailerVehiclePlateNumber = trailerVehiclePlateNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPermitNumber1() {
        return permitNumber1;
    }

    public void setPermitNumber1(String permitNumber1) {
        this.permitNumber1 = permitNumber1;
    }

    public String getCube() {
        return cube;

    }

    public void setCube(String cube) {
        this.cube = cube;
    }

    public String getTotalNumberOfPackages() {
        return totalNumberOfPackages;
    }

    public void setTotalNumberOfPackages(String totalNumberOfPackages) {
        this.totalNumberOfPackages = totalNumberOfPackages;
    }

    public String getOriginalDocumentNumber() {

        return originalDocumentNumber;
    }

    public void setOriginalDocumentNumber(String originalDocumentNumber) {
        this.originalDocumentNumber = originalDocumentNumber;
    }

    public String getShippingNoteNumber() {
        return shippingNoteNumber;
    }

    public void setShippingNoteNumber(String shippingNoteNumber) {
        this.shippingNoteNumber = shippingNoteNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getBusinessTypeCode() {
        return businessTypeCode;
    }

    public void setBusinessTypeCode(String businessTypeCode) {
        this.businessTypeCode = businessTypeCode;
    }

    public String getDespatchActualDateTime() {
        return despatchActualDateTime;
    }

    public void setDespatchActualDateTime(String despatchActualDateTime) {
        this.despatchActualDateTime = despatchActualDateTime;
    }

    public String getGoodsReceiptDateTime() {
        return goodsReceiptDateTime;
    }

    public void setGoodsReceiptDateTime(String goodsReceiptDateTime) {
        this.goodsReceiptDateTime = goodsReceiptDateTime;
    }

    public String getCountrySubdivisionCode() {
        return countrySubdivisionCode;
    }

    public void setCountrySubdivisionCode(String countrySubdivisionCode) {
        this.countrySubdivisionCode = countrySubdivisionCode;
    }

    public String getCountrySubdivisionCode1() {
        return countrySubdivisionCode1;
    }

    public void setCountrySubdivisionCode1(String countrySubdivisionCode1) {
        this.countrySubdivisionCode1 = countrySubdivisionCode1;
    }

    public String getTotalMonetaryAmount() {
        return totalMonetaryAmount;
    }

    public void setTotalMonetaryAmount(String totalMonetaryAmount) {
        this.totalMonetaryAmount = totalMonetaryAmount;
    }

    public String getLicensePlateTypeCode() {
        return licensePlateTypeCode;
    }

    public void setLicensePlateTypeCode(String licensePlateTypeCode) {
        this.licensePlateTypeCode = licensePlateTypeCode;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleClassificationCode() {
        return vehicleClassificationCode;
    }

    public void setVehicleClassificationCode(String vehicleClassificationCode) {
        this.vehicleClassificationCode = vehicleClassificationCode;
    }

    public String getVehicleTonnage() {
        return vehicleTonnage;
    }

    public void setVehicleTonnage(String vehicleTonnage) {
        this.vehicleTonnage = vehicleTonnage;
    }

    public String getRoadTransportCertificateNumber() {
        return roadTransportCertificateNumber;
    }

    public void setRoadTransportCertificateNumber(String roadTransportCertificateNumber) {
        this.roadTransportCertificateNumber = roadTransportCertificateNumber;
    }

    public String getDescriptionOfGoods() {
        return descriptionOfGoods;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        this.descriptionOfGoods = descriptionOfGoods;
    }

    public String getCargoTypeClassificationCode() {
        return cargoTypeClassificationCode;
    }

    public void setCargoTypeClassificationCode(String cargoTypeClassificationCode) {
        this.cargoTypeClassificationCode = cargoTypeClassificationCode;
    }

    public String getGoodsItemGrossWeight() {
        return goodsItemGrossWeight;
    }

    public void setGoodsItemGrossWeight(String goodsItemGrossWeight) {
        this.goodsItemGrossWeight = goodsItemGrossWeight;
    }
}

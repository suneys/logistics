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


    public class ShippingNote{
        /**
         * 托运单号
         */
        private String shippingNoteNumber;
        /**
         * 备注
         */
        private String remark;

        public String getShippingNoteNumber() {
            return shippingNoteNumber;
        }

        public void setShippingNoteNumber(String shippingNoteNumber) {
            this.shippingNoteNumber = shippingNoteNumber;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public class Financial{
        /**
         * 付款方式代码
         */
        private String paymentMeansCode;
        /**
         * 银行代码
         */
        private String bankCode;
        /**
         * 流水号/序列号
         */
        private String sequenceCode;
        /**
         * 货币金额
         */
        private String monetaryAmount;
        /**
         * 日期时间
         */
        private String dateTime;

        public String getPaymentMeansCode() {
            return paymentMeansCode;
        }

        public void setPaymentMeansCode(String paymentMeansCode) {
            this.paymentMeansCode = paymentMeansCode;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getSequenceCode() {
            return sequenceCode;
        }

        public void setSequenceCode(String sequenceCode) {
            this.sequenceCode = sequenceCode;
        }

        public String getMonetaryAmount() {
            return monetaryAmount;
        }

        public void setMonetaryAmount(String monetaryAmount) {
            this.monetaryAmount = monetaryAmount;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }
    }
}

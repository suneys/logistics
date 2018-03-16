package com.yoyo.entity;

/**
 * Created by Administrator on 2018/3/15 0015.
 */
public class Financial {
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

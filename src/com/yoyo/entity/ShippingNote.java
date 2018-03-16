package com.yoyo.entity;

/**
 * Created by Administrator on 2018/3/15 0015.
 */
public class ShippingNote {
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

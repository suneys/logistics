package com.yoyo.entity;

/**
 * 驾驶员实体类
 * Created by Administrator on 2018/1/11 0011.
 */
public class Driver {
    private String nameOfPerson;                   //驾驶员姓名      选填
    private String qualificationCertificateNumber; //从业资格证号    选填
    private String telephoneNumber;                //电话号码        选填

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    public String getQualificationCertificateNumber() {
        return qualificationCertificateNumber;
    }

    public void setQualificationCertificateNumber(String qualificationCertificateNumber) {
        this.qualificationCertificateNumber = qualificationCertificateNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}

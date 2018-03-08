package com.yoyo.util;

import com.wondersgroup.cuteinfo.client.exchangeserver.exchangetransport.dao.IMessageTransporterDAO;
import com.wondersgroup.cuteinfo.client.exchangeserver.exchangetransport.factory.ITransportClientFactory;
import com.wondersgroup.cuteinfo.client.exchangeserver.exchangetransport.impl.USendRequset;
import com.wondersgroup.cuteinfo.client.exchangeserver.exchangetransport.impl.USendResponse;
import com.wondersgroup.cuteinfo.client.exchangeserver.usersecurty.UserToken;
import com.wondersgroup.cuteinfo.client.util.GUIDUtil;
import com.wondersgroup.cuteinfo.client.util.UserTokenUtils;
import com.yoyo.entity.Driver;
import com.yoyo.entity.Message;
import com.yoyo.entity.Money;
import com.yoyo.entity.Result;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 2018/1/10 0010.
 */
public class MessageUtil {
    private static Logger logger = Logger.getLogger(MessageUtil.class);
    static public Result sendMessage(Message message){
            return sendDataToServer(getMessageToXML(message));
    }

    static public Result sendDataToServer(String xml){
        Properties properties = PropertiesUtils.PROPERTIES.getProperties("../../client_demo.properties");

        String targetURL = properties.getProperty("targetURL");

        IMessageTransporterDAO transporter=null;
        try {
            UserToken token = UserTokenUtils.getTicket(properties.getProperty("username"),properties.getProperty("password"),properties.getProperty("resourceId"),properties.getProperty("authURL"));

            USendRequset sendReq = new USendRequset();
            sendReq.setToaddress(properties.getProperty("toaddress").split(","));
            sendReq.setSendRequestTypeXML("LOGINK_CN_FREIGHTBROKER_WAYBILL",xml);

            transporter = ITransportClientFactory.createMessageTransporter(token,targetURL);
            long start = System.currentTimeMillis();
            USendResponse response = transporter.send(sendReq);
            long end = System.currentTimeMillis();
            //System.out.println("time:"+(end - start)+"ms"+xml.getBytes().length);
            if (response.isSendResult()) {
                //System.out.println("send success");
                return Result.SUCCESS;
            }else {
                //错误的情况下，会返回异常代码以及异常信息。异常代码请参照《3.2 共建指导性文件：交换接入》中的异常代码信息
                System.out.println("send error");
                logger.info(response.getGenericFault().getCode());
                logger.info(response.getGenericFault().getMessage());
                return Result.ERROR;
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.ERROR;
        }
    }

    static public  String getMessageToXML(Message message) {
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
        String xml = "";
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xml = xml + "<Root>";
        xml = xml + "<Header>";
        xml = xml + "<MessageReferenceNumber>"+ GUIDUtil.generateID()+"</MessageReferenceNumber>";
        xml = xml + "<DocumentName>无车承运人电子路单</DocumentName>";
        xml = xml + "<DocumentVersionNumber>2015WCCYR</DocumentVersionNumber>";
        xml = xml + "<SenderCode>19458</SenderCode>";
        xml = xml + "<RecipientCode>wcjc0001</RecipientCode>";
        xml = xml + "<MessageSendingDateTime>"+sf.format(new Date())+"</MessageSendingDateTime>";
        xml = xml + "<MessageFunctionCode>9</MessageFunctionCode> ";
        xml = xml + "</Header>";
        xml = xml + "<Body>";
        xml = xml + "<OriginalDocumentNumber>"+message.getOriginalDocumentNumber()+"</OriginalDocumentNumber>";
        xml = xml + "<ShippingNoteNumber>"+message.getShippingNoteNumber()+"</ShippingNoteNumber>";
        xml = xml + "<Carrier>"+message.getCarrier()+"</Carrier>";
        if(message.getUnifiedSocialCreditIdentifier() != null) {
            xml = xml + "<UnifiedSocialCreditIdentifier>" + message.getUnifiedSocialCreditIdentifier() + "</UnifiedSocialCreditIdentifier>";
        }
        if(message.getPermitNumber() != null) {
            xml = xml + " <PermitNumber>" + message.getPermitNumber() + "</PermitNumber>";
        }
        xml = xml + "<ConsignmentDateTime>"+sf.format(new Date())+"</ConsignmentDateTime>";
        xml = xml + "<BusinessTypeCode>"+message.getBusinessTypeCode()+"</BusinessTypeCode>";
        xml = xml + "<DespatchActualDateTime>"+message.getDespatchActualDateTime()+"</DespatchActualDateTime>";
        xml = xml + "<GoodsReceiptDateTime>"+message.getGoodsReceiptDateTime()+"</GoodsReceiptDateTime>";
        xml = xml + "<ConsignorInfo>";
        if (message.getConsignor() != null) {
            xml = xml + "<Consignor>" + message.getConsignor() + "</Consignor>";
        }
        if(message.getPersonalIdentityDocument() != null) {
            xml = xml + " <PersonalIdentityDocument>" + message.getPersonalIdentityDocument() + "</PersonalIdentityDocument>";
        }
        if (message.getPlaceOfLoading() != null) {
            xml = xml + "<PlaceOfLoading>" + message.getPlaceOfLoading() + "</PlaceOfLoading>";
        }
        xml = xml + "<CountrySubdivisionCode>"+message.getCountrySubdivisionCode()+"</CountrySubdivisionCode>";
        xml = xml + "</ConsignorInfo>";
        xml = xml + "<ConsigneeInfo>";
        if (message.getConsignee() != null) {
            xml = xml + "<Consignee>" + message.getConsignee() + "</Consignee>";
        }
        if (message.getGoodsReceiptPlace() != null) {
            xml = xml + "<GoodsReceiptPlace>" + message.getGoodsReceiptPlace() + "</GoodsReceiptPlace>";
        }
        xml = xml + "<CountrySubdivisionCode>"+message.getCountrySubdivisionCode1()+"</CountrySubdivisionCode>";
        xml = xml + "</ConsigneeInfo>";
        xml = xml + "<PriceInfo>";
        xml = xml + "<TotalMonetaryAmount>"+message.getTotalMonetaryAmount()+"</TotalMonetaryAmount>";
//        if (!request.getParameter("remark").trim().isEmpty()) {
//            xml = xml + "<Remark>" + request.getParameter("remark") + "</Remark>";
//        }
        xml = xml + "</PriceInfo>";
        xml = xml + "<VehicleInfo>";
        xml = xml + "<LicensePlateTypeCode>" + message.getLicensePlateTypeCode() + "</LicensePlateTypeCode>";
        xml = xml + "<VehicleNumber>" + message.getVehicleNumber() + "</VehicleNumber>";
        xml = xml + "<VehicleClassificationCode>" + message.getVehicleClassificationCode() + "</VehicleClassificationCode>";
        xml = xml + "<VehicleTonnage>" + message.getVehicleTonnage() + "</VehicleTonnage>";
        xml = xml + "<RoadTransportCertificateNumber>" + message.getRoadTransportCertificateNumber() + "</RoadTransportCertificateNumber>";
        if (message.getTrailerVehiclePlateNumber() != null) {
            xml = xml + "<TrailerVehiclePlateNumber>" + message.getTrailerVehiclePlateNumber() + "</TrailerVehiclePlateNumber>";
        }
        if (message.getOwner() != null) {
            xml = xml + "<Owner>" + message.getOwner() + "</Owner>";
        }
        if (message.getPermitNumber() != null) {
            xml = xml + "<PermitNumber>" + message.getPermitNumber() + "</PermitNumber>";
        }
        if(message.getDrivers() != null) {
            StringBuilder sb = new StringBuilder();
            for (Driver driver : message.getDrivers()) {
                sb.append("<Driver>");
                if (driver.getNameOfPerson() != null) {
                    sb.append("<NameOfPerson>" + driver.getNameOfPerson() + "</NameOfPerson>");
                }
                if (driver.getQualificationCertificateNumber() != null) {
                    sb.append("<QualificationCertificateNumber>" + driver.getQualificationCertificateNumber() + "</QualificationCertificateNumber>");
                }
                if (driver.getTelephoneNumber() != null) {
                    sb.append("<TelephoneNumber>" + driver.getTelephoneNumber() + "</TelephoneNumber>");
                }
                sb.append("</Driver>");
            }
            xml = xml + sb.toString();
        }
        xml = xml + "<GoodsInfo>";
        xml = xml + "<DescriptionOfGoods>"+message.getDescriptionOfGoods()+"</DescriptionOfGoods>";
        xml = xml + " <CargoTypeClassificationCode>"+message.getCargoTypeClassificationCode()+"</CargoTypeClassificationCode>";
        xml = xml + " <GoodsItemGrossWeight>"+message.getGoodsItemGrossWeight()+"</GoodsItemGrossWeight>";
        if (message.getCube() != null) {
            xml = xml + "<Cube>" + message.getCube() + "</Cube>";
        }
        if (message.getTotalNumberOfPackages() != null) {
            xml = xml + "<TotalNumberOfPackages>" + message.getTotalNumberOfPackages() + "</TotalNumberOfPackages>";
        }
        xml = xml + "</GoodsInfo>";
        xml = xml + "</VehicleInfo>";
        xml = xml + "<FreeText>文本</FreeText>";
        xml = xml + "</Body>";
        xml = xml + "</Root>";
        return xml;
    }



    static public  String getMoneyToXML(Money money) {
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
        String xml = "";
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xml = xml + "<Root>";
        xml = xml + "<Header>";
        xml = xml + "<MessageReferenceNumber>"+ GUIDUtil.generateID()+"</MessageReferenceNumber>";
        xml = xml + "<DocumentName>资金流水单</DocumentName>";
        xml = xml + "<DocumentVersionNumber>2015WCCYR</DocumentVersionNumber>";
        xml = xml + "<SenderCode>19458</SenderCode>";
        xml = xml + "<RecipientCode>wcjc0001</RecipientCode>";
        xml = xml + "<MessageSendingDateTime>"+sf.format(new Date())+"</MessageSendingDateTime>";
        xml = xml + "<MessageFunctionCode>9</MessageFunctionCode> ";
        xml = xml + "</Header>";
        xml = xml + "<Body>";
        xml = xml + "<DocumentNumber>"+money.getDocumentNumber()+"</DocumentNumber>";
        xml = xml + "<Carrier>"+money.getCarrier()+"</Carrier>";
        xml = xml + "<VehicleNumber>"+money.getVehicleNumber()+"</VehicleNumber>";
        xml = xml + "<LicensePlateTypeCode>"+money.getVehicleNumber()+"</LicensePlateTypeCode>";
        if (money.getShippingNoteList() != null) {
            for (Money.ShippingNote shippingNote: money.getShippingNoteList()
                 ) {
                xml = xml + "<ShippingNoteNumber>"+shippingNote.getShippingNoteNumber()+"</ShippingNoteNumber>";
                if (shippingNote.getRemark() != null){
                    xml = xml + "<Remark>"+shippingNote.getRemark()+"</Remark>";
                }
            }
        }
        if (money.getFinanciallist() != null){
            for (Money.Financial financial: money.getFinanciallist()
                 ) {
                xml = xml + "<PaymentMeansCode>"+financial.getPaymentMeansCode()+"</PaymentMeansCode>";
                if (financial.getBankCode() != null){
                    xml = xml + "<BankCode>"+financial.getBankCode()+"</BankCode>";
                }
                xml = xml + "<SequenceCode>"+financial.getSequenceCode()+"</SequenceCode>";
                xml = xml + "<MonetaryAmount>"+financial.getMonetaryAmount()+"</MonetaryAmount>";
                xml = xml + "<DateTime>"+financial.getDateTime()+"</DateTime>";
            }
        }
        xml = xml + "</Body>";
        xml = xml + "</Root>";
        return xml;
    }
}

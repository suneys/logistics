package com.yoyo.servlet;

import com.yoyo.entity.Financial;
import com.yoyo.entity.Money;
import com.yoyo.entity.Result;
import com.yoyo.entity.ShippingNote;
import com.yoyo.util.MessageUtil;
import com.yoyo.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018/3/15 0015.
 */
@WebServlet(name = "MoneyServlet", urlPatterns = "/moneyServlet")
public class MoneyServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        List<ShippingNote>shippingNotes = new ArrayList<>();
        String[] shippingNoteNumbers = request.getParameterValues("shippingNoteNumber");
        String[] remarks = request.getParameterValues("remark");
        for (int i =0; i < shippingNoteNumbers.length; i++){
            ShippingNote shippingNote = new ShippingNote();
            shippingNote.setShippingNoteNumber(shippingNoteNumbers[i]);
            if (remarks != null && i < remarks.length){
                shippingNote.setRemark(remarks[i]);
            }
            shippingNotes.add(shippingNote);
        }
        List<Financial> financials = new ArrayList<>();
        String[] paymentMeansCodes = request.getParameterValues("paymentMeansCode");
        String[] bankCodes = request.getParameterValues("bankCode");
        String[] sequenceCodes = request.getParameterValues("sequenceCode");
        String[] monetaryAmounts = request.getParameterValues("monetaryAmount");
        String[] dateTimes = request.getParameterValues("dateTime");
        int bankCodeNum = 0;
        for (int i = 0; i < paymentMeansCodes.length; i++){
            Financial financial = new Financial();
            financial.setPaymentMeansCode(paymentMeansCodes[i]);
            if (paymentMeansCodes[i].equals("39") ){
                financial.setBankCode(bankCodes[bankCodeNum]);
                bankCodeNum++;
            }
            financial.setSequenceCode(sequenceCodes[i]);
            financial.setMonetaryAmount(monetaryAmounts[i]);
            financial.setDateTime(dateTimeformat(dateTimes[i]));
            financials.add(financial);
        }
        Money money = new Money();
        money.setShippingNoteList(shippingNotes);
        money.setFinanciallist(financials);
        money.setCarrier(request.getParameter("carrier"));
        money.setDocumentNumber(request.getParameter("documentNumber"));
        money.setVehicleNumber(request.getParameter("vehicleNumber"));
        System.out.println(request.getParameter("licensePlateTypeCode"));
        money.setLicensePlateTypeCode(request.getParameter("licensePlateTypeCode"));

        Map jsonMap = new HashMap();
        Result result = MessageUtil.sendMoney(money);
        if (result == Result.SUCCESS){
            jsonMap.put("IsOk",true);
        }else{
            jsonMap.put("IsOk",false);
        }
        ResponseUtil.response(response,jsonMap);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private String dateTimeformat(String old){
        String newDateTime = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(old);
            sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            newDateTime = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDateTime;
    }
}

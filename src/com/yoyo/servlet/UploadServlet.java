package com.yoyo.servlet;

import com.yoyo.entity.Message;
import com.yoyo.entity.Result;
import com.yoyo.util.ExcelUtil;
import com.yoyo.util.MessageUtil;
import com.yoyo.util.ResponseUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 文件上传servlet
 * @author Administrator
 * @date 2018/1/9 0009
 */
@WebServlet(name = "UploadServlet", urlPatterns = "/uploadServlet")
public class UploadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        upload(request,response);
    }

    private void upload(HttpServletRequest request, HttpServletResponse response) {
        File file = null;
        try {
            // 1. 创建工厂对象
            FileItemFactory factory = new DiskFileItemFactory();
            // 2. 文件上传核心工具类
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置大小限制参数
           // upload.setFileSizeMax(10*1024*1024);	// 单个文件大小限制
            upload.setSizeMax(50*1024*1024);		// 总文件大小限制
            upload.setHeaderEncoding("UTF-8");		// 对中文文件编码处理

            // 判断
            if (FileUploadBase.isMultipartContent(request)) {
                // 3. 把请求数据转换为list集合
                List<FileItem> list = upload.parseRequest(request);
                // 遍历
                for (FileItem item : list){
                    // 判断：普通文本数据
                    if (item.isFormField()){
                        // 获取名称
                        String name = item.getFieldName();
                        // 获取值
                        String value = item.getString();
                        System.out.println(value);
                    }
                    // 文件表单项
                    else {
                        /******** 文件上传 ***********/
                        // a. 获取文件名称
                        String name = item.getName();
                        // ----处理上传文件名重名问题----
                        // a1. 先得到唯一标记
                        String id = UUID.randomUUID().toString();
                        // a2. 拼接文件名
                        name = id + "#" + name;

                        // b. 得到上传目录
                        String basePath = getServletContext().getRealPath("/upload");
                        // c. 创建要上传的文件对象
                        if (!new File(basePath).exists()){
                            new File(basePath).mkdir();
                        }
                        file = new File(basePath,name);
                        // d. 上传
                        item.write(file);
                        item.delete();  // 删除组件运行时产生的临时文件
                        handleFile(file.getAbsolutePath(),response); //处理上传上来的Excel文件

                    }
                }
                System.out.println("上传完成");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Map jsonMap = new HashMap();
            jsonMap.put("result","服务器正忙，请稍后再试！");
            ResponseUtil.response(response,jsonMap);
        }finally {
            if (file != null){
                file.delete();
            }
        }
    }

    private void handleFile(String filePath,HttpServletResponse response) throws Exception {
        List<Map<String, String>> dataList = ExcelUtil.readExcel(filePath);
        List<Message> messages = null;
        int index = 0;
        if (dataList != null) {
             messages = new ArrayList<>();
            for (Map<String,String> data : dataList){
                Message message = new Message();
                message.setOriginalDocumentNumber(data.get("原始单号"));
                message.setShippingNoteNumber(data.get("托运单号"));
                message.setCarrier(data.get("承运人"));
                message.setBusinessTypeCode(data.get("业务类型"));
                message.setDespatchActualDateTime(data.get("发运实际日期时间"));
                message.setGoodsReceiptDateTime(data.get("收货时间"));
                message.setCountrySubdivisionCode(data.get("装货地区"));
                message.setCountrySubdivisionCode1(data.get("收货地区"));
                message.setTotalMonetaryAmount(data.get("货币总金额"));
                message.setLicensePlateTypeCode(data.get("牌照类型"));
                message.setVehicleNumber(data.get("车量牌照号"));
                message.setVehicleClassificationCode(data.get("车辆分类"));
                message.setVehicleTonnage(data.get("车辆载质量"));
                message.setRoadTransportCertificateNumber(data.get("道路运输证号"));
                message.setDescriptionOfGoods(data.get("货物名称"));
                message.setCargoTypeClassificationCode(data.get("货物类型"));
                message.setGoodsItemGrossWeight(data.get("货物项毛重"));
                messages.add(message);
            }
        }
        if (messages != null) {
            for (Message message : messages) {
                index++;
                if(MessageUtil.sendMessage(message) == Result.ERROR){
                  break;
                }
            }
        }
        Map jsonMap = new HashMap();
        if (index == (messages.size())){
            jsonMap.put("result","上传成功");
        }else {
            jsonMap.put("result","上传失败，从第"+index+"条开始重新上传");
        }
        ResponseUtil.response(response,jsonMap);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

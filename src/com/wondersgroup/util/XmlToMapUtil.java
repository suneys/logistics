package com.wondersgroup.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlToMapUtil {
    public static boolean isDebug = false; //调试开关
    public static boolean isReadAttr = false;//是否需要读取本节点属性

    /**
     * @Description: 解析xml工具类
     * @param xmlStr
     * @author zjw
     * @return Map    返回类型
     */
    public static Map<Object, Object> xmlStrToMap(String xmlStr) {
        try {
            Map<Object, Object> map = new HashMap<Object, Object>(); //定义map
            Map<Object, Object> rootMap = new HashMap<Object, Object>(); //定义map
            Map<Object, Object> nodeMap = new HashMap<Object, Object>(); //定义map
            Document document = DocumentHelper.parseText(xmlStr); //将字符串转换成xml对象
            Element root = document.getRootElement(); //读取根节点
            //遍历根节点属性
            getNodeAndAttribute2Map(root, rootMap);
            map.put(root.getName(), rootMap);

            //遍历所有子节点及其属性
            getElementList(root, map);

            return map; //返回值
        }
        catch (Exception e) {
            e.printStackTrace();
            return new HashMap<Object, Object>();
        }
    }

    /**
     * @Description: 获取xml指定名称的节点值
     * @param map
     * @param nodeName
     * @author zjw
     * @return void    返回类型
     */
    public static String getNodeValue(Map<Object, Object> map,String nodeName) {
        Map<Object, Object> nodeMap = (Map<Object, Object>)map.get(nodeName);
        String nodeValue = nodeMap.get(nodeName).toString();
        return nodeValue;
    }

    /**
     * @Description: 获取xml指定名称的节点属性值
     * @param map
     * @param nodeName
     * @author zjw
     * @return void    返回类型
     */
    public static String getNodeAttributeValue(Map<Object, Object> map,String nodeName,String attributeName) {
        Map<Object, Object> nodeMap = (Map<Object, Object>)map.get(nodeName);
        Map<Object, Object> attributeMap = (Map<Object, Object>)nodeMap.get(nodeName+"$Attribute");
        String attributeValue = attributeMap.get(attributeName).toString();
        return attributeValue;
    }

    /**
     * @Title: getNodeAndAttribute2Map
     * @Description: 遍历子节点及其属性
     * @param @param element
     * @param @param map 参数名称类型列表
     * @author zjw
     * @return void    返回类型
     */
    private static void getNodeAndAttribute2Map(Element element, Map<Object, Object> nodeMap) {
        String eleName = element.getName();
        String eleValue = element.getText();
        nodeMap.put(eleName, eleValue);
        if (isDebug)
            System.out.println("节点值：" + eleName + "  =  " + eleValue);

        Map<Object, Object> mapAttribute = new HashMap<Object, Object>();
        for (int i = 0; i < element.attributeCount(); i++) {
            Attribute attribute = element.attribute(i);
            String name = attribute.getName(); //属性名称
            String value = attribute.getValue(); //属性值
            if (name != null && !"".equals(name)) {
                mapAttribute.put(name, value);//将值添加到map
                if (isDebug)
                    System.out.println("节点属性：" + name + "  =  " + value);
            }
        }
        if(mapAttribute.size()>0)
            nodeMap.put(element.getName()+"$Attribute", mapAttribute);
    }

    /**
     * @Description: 遍历子节点及其属性
     * @param element
     * @param map
     * @author zjw
     * @return void    返回类型
     */
    private static void getElementList(Element element,Map<Object, Object> map) {
        for (Iterator<Element> it = element.elementIterator();it.hasNext();) {
            Map<Object, Object> nodeMap = new HashMap<Object, Object>(); //定义map
            Element el = (Element)it.next();
            getNodeAndAttribute2Map(el, nodeMap);
            if(nodeMap.size()>0){
                map.put(el.getName(),nodeMap);
                if (isDebug)
                    System.out.println("节点对象：" + el.getName() + "  =  " + nodeMap);
            }
            List elements = el.elements();
            if (isDebug)
                System.out.println("elements.isEmpty() = "+elements.isEmpty());

            if (!elements.isEmpty()){
                // 递归遍历
                getElementList(el, map);
            }
        }
    }


    public static void main(String[] args) {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ns3:ReceiveResponse xmlns=\"http://schema.egs.org.cn/exchange/edf\" xmlns:ns2=\"http://schemas.egs.org.cn/businessdata\" xmlns:ns3=\"http://schema.egs.org.cn/exchange/exchangetransport\" xmlns:ns4=\"http://schema.egs.org.cn/exchange/cdt\" TotalEventCount=\"1\"><ns3:ReceiveExchangeEvent ReceivedTime=\"2016-01-04T15:44:27.992+08:00\" EventSender=\"12677\" EventReceiver=\"12677\"><ns3:ReceivedEvent EventID=\"40288341520b97e701520b97e7f10003\" ActionType=\"ZJWL_LOGINK_HWGZ_YSLJobNote\"><ExchangeDataPackage packageID=\"40288341520b97e701520b97e7f10006\" transactionID=\"40288341520b97e701520b97e7f10007\" createTime=\"2016-01-04T15:44:14.474+08:00\" expireTime=\"2016-01-04T15:44:14.474+08:00\" title=\"title\"><ExchangeDataPackageUnit groupID=\"40288341520b97e701520b97e7f1000b\" groupSize=\"1\" sequenceInGroup=\"1\" unitID=\"40288341520b97e701520b97e7f10009\" source=\"source\" entityIDName=\"//www.wondersgroup.com\" entityDispName=\"entitydispname\" createDate=\"2016-01-04T07:44:10.747Z\" expireDate=\"2016-01-04T07:44:10.745Z\"><DataFile dataFileID=\"www.wondersgroup.com\" fileName=\"xml\" dataFileFormat=\"xml\"><Base64EncodedData>Zw0KSUNBZ1BDOVNiMjkwUGc9PQ==</Base64EncodedData><AttachmentData>ICAgPC9Sb290Pg==</AttachmentData></DataFile></ExchangeDataPackageUnit></ExchangeDataPackage></ns3:ReceivedEvent></ns3:ReceiveExchangeEvent></ns3:ReceiveResponse>";
        Map<Object, Object> map = xmlStrToMap(xmlStr);
        System.out.println(map.size());
        String nodeName = "ReceivedEvent";//节点名称
        String attributeName = "EventID";//节点属性名称
        String node = getNodeValue(map, nodeName);
        System.out.println(node);
        String attr = getNodeAttributeValue(map, nodeName, attributeName);
        System.out.println(attr);
        String nodeName1 = "AttachmentData";//节点名称
        String node1 = getNodeValue(map, nodeName1);
        System.out.println(node1);
    }

}

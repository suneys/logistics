package com.wondersgroup.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author lbz
 * @date 2010-6-29
 */
public class DateUtil {
    private static Log log = LogFactory.getLog(DateUtil.class);
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

    public static final SimpleDateFormat DATE_FORMAT_FULL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final SimpleDateFormat DATE_FORMAT_MEDIUM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static final SimpleDateFormat DATE_FORMAT_SHORT = new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat DATE_FORMAT_SHORTA = new SimpleDateFormat("yyyyMMddHH");

    public static final SimpleDateFormat DATE_FORMAT_MEDIUM_BBS = new SimpleDateFormat("MM-dd HH:mm");

    public static final SimpleDateFormat DATE_FORMAT_SHORT_BBS = new SimpleDateFormat("MM-dd");

    public static final SimpleDateFormat DATE_FORMAT_SHORT_BBSFEN = new SimpleDateFormat("HH:mm");

    public static final SimpleDateFormat DATE_FORMAT_SHORT_DAY = new SimpleDateFormat("dd");

    public static final SimpleDateFormat DATE_FORMAT_SHORT_MONTH = new SimpleDateFormat("MM");

    public static final SimpleDateFormat DATE_FORMAT_SHORT_YEAR = new SimpleDateFormat("yyyy");

    public static final SimpleDateFormat DATE_FORMAT_FULL_ZH = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

    public static final SimpleDateFormat DATE_FORMAT_MEDIUM_ZH = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");

    public static final SimpleDateFormat DATE_FORMAT_SHORT_ZH = new SimpleDateFormat("yyyy年MM月dd日");

    public static final SimpleDateFormat DATE_FORMAT_DAY_ZH = new SimpleDateFormat("dd日");

    public static final String TYPE_DATE = "D"; // 日期

    public static final String TYPE_TIME = "T"; // 时间

    public static final String TYPE_DATETIME = "DT"; // 日期时间
    public static final String STYLE_AD = "AD"; // 日期时间格式：CCYYMMDDhhmmss
    public static final String STYLE_ROC = "R"; // 日期时间格式：YYYMMDDhhmmss
    public static final String STYLE_FORMAT = "F"; // 日期时间格式：CCYY-MM-DD
    public static final String STYLE_XML = "X"; // XML日期时间格式
    public static final String STYLE_FORMAT_FOR_USER = "FU"; // 日期时间格式:CCYY/MM/DD
    /**
     * 按格式取得当前时间
     *
     * @return
     */
    public static String getCurrentDateTime(int formatType) {
        Calendar cal = Calendar.getInstance();
        String rtn = null;
        switch (formatType) {
            case 0://yyyy-MM-dd HH:mm:ss SSS
                rtn = DATE_FORMAT.format(cal.getTime());
                break;
            case 1://yyyy-MM-dd HH:mm:ss
                rtn = DATE_FORMAT_FULL.format(cal.getTime());
                break;
            case 2://yyyy-MM-dd HH:mm
                rtn = DATE_FORMAT_MEDIUM.format(cal.getTime());
                break;
            case 3://yyyy-MM-dd
                rtn = DATE_FORMAT_SHORT.format(cal.getTime());
                break;
            case 4://MM-dd HH:mm
                rtn = DATE_FORMAT_MEDIUM_BBS.format(cal.getTime());
                break;
            case 5://MM-dd
                rtn = DATE_FORMAT_SHORT_BBS.format(cal.getTime());
                break;
            case 6://HH:mm
                rtn = DATE_FORMAT_SHORT_BBSFEN.format(cal.getTime());
                break;
            case 7://yyyy年MM月dd日 HH时mm分ss秒
                rtn = DATE_FORMAT_FULL_ZH.format(cal.getTime());
                break;
            case 8://yyyy年MM月dd日 HH时mm分
                rtn = DATE_FORMAT_MEDIUM_ZH.format(cal.getTime());
                break;
            case 9://yyyy年MM月dd日
                rtn = DATE_FORMAT_SHORT_ZH.format(cal.getTime());
                break;
            case 10://dd
                rtn = DATE_FORMAT_SHORT_DAY.format(cal.getTime());
                break;
            case 11://mm
                rtn = DATE_FORMAT_SHORT_MONTH.format(cal.getTime());
                break;
            case 12://yyyy
                rtn = DATE_FORMAT_SHORT_YEAR.format(cal.getTime());
                break;
            default://yyyy-MM-dd HH:mm:ss
                rtn = DATE_FORMAT_FULL.format(cal.getTime());
        }

        return rtn;
    }
    /**
     * 获取昨日日期
     * @return
     */
    public static String getYesterday(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) - 1);
        return DATE_FORMAT_SHORT.format(cal.getTime());
    }
    /**
     * 获取明日日期
     *
     * @return
     */
    public static String getTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + 1);
        return DATE_FORMAT_SHORT.format(cal.getTime());
    }
    /**
     * 获取后一月日期
     *
     * @return
     */
    public static String getNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        return DATE_FORMAT_SHORT.format(cal.getTime());
    }

    // 將傳入之字串日期格式轉為calendar,若不合法則throw APException
    public synchronized static Calendar string2Calendar(String dateString) {
        int year = 0, month = 0, date = 0, hour = 0, min = 0, sec = 0, myLen = 0;
        if (dateString == null || dateString.equals("")) {
            log.debug("string2Calendar():传入时间为空!");
            return null;
        }
        myLen = dateString.length();
        if (myLen == 8 || myLen == 14) {
            year = Integer.parseInt(dateString.substring(0, 4));
            month = Integer.parseInt(dateString.substring(4, 6)) - 1;
            date = Integer.parseInt(dateString.substring(6, 8));
            if (myLen == 14) {
                dateString = dateString.substring(8);
            }
        }

        if (dateString.length() == 6) {
            hour = Integer.parseInt(dateString.substring(0, 2));
            min = Integer.parseInt(dateString.substring(2, 4));
            sec = Integer.parseInt(dateString.substring(4, 6));
        } else if (dateString.length() == 4) {
            hour = Integer.parseInt(dateString.substring(0, 2));
            min = Integer.parseInt(dateString.substring(2, 4));
        }

        Calendar calendarObj = Calendar.getInstance();
        if (myLen == 8) {
            calendarObj.set(year, month, date);
            if (year != calendarObj.get(Calendar.YEAR)
                    || month != (calendarObj.get(Calendar.MONTH))
                    || date != calendarObj.get(Calendar.DATE)) {
                log.debug("日期格式错误!");
                return null;
            }
        } else if (myLen == 4) {
            calendarObj.set(Calendar.HOUR_OF_DAY, hour);
            calendarObj.set(Calendar.MINUTE, min);
            if (hour < 0 || hour >= 24 || min < 0 || min >= 60 || sec < 0
                    || sec >= 60) {
                log.debug("时间格式错误!");
                return null;
            }
        } else if (myLen == 6) {
            calendarObj.set(Calendar.HOUR_OF_DAY, hour);
            calendarObj.set(Calendar.MINUTE, min);
            calendarObj.set(Calendar.SECOND, sec);
            if (hour < 0 || hour >= 24 || min < 0 || min >= 60 || sec < 0
                    || sec >= 60) {
                log.debug("时间格式错误!");
                return null;
            }
        } else if (myLen == 14) {
            calendarObj.set(year, month, date, hour, min, sec);
            if (year != calendarObj.get(Calendar.YEAR)
                    || month != (calendarObj.get(Calendar.MONTH))
                    || date != calendarObj.get(Calendar.DATE)
                    || hour != calendarObj.get(Calendar.HOUR_OF_DAY)
                    || min != calendarObj.get(Calendar.MINUTE)
                    || sec != calendarObj.get(Calendar.SECOND)) {
                log.debug("日期或时间格式错误!");
                return null;
            }
        } else {
            log.debug("传入长度错误!");
            return null;
        }
        return calendarObj;
    }
    /**
     * 得到当前时间
     *
     * @param type
     * @param style
     * @return
     */
    public synchronized static String getCurrentTime(String type, String style) {
        Calendar calendar = Calendar.getInstance();
        return getDateTime(calendar, type, style);
    }
    /**
     * 得到间隔时间
     *
     * @param type
     * @param style
     * @return
     */
    public synchronized static String getCurrentTime(String type, String style,int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1 * min);
        return getDateTime(calendar, type, style);
    }

    public synchronized static String getDateTime(Calendar calendar,
                                                  String type, String style) {
        String myDateTime = "";
        if (type == null || type.equals("")) {
            type = TYPE_DATETIME;
        }
        if (style == null || style.equals("")) {
            style = STYLE_AD;
        }
        String year, month, day, hour, min, sec;
        if (style.equals(STYLE_ROC)) {
            year = padding(calendar.get(Calendar.YEAR) - 1911, 2);
        } else {
            year = padding(calendar.get(Calendar.YEAR), 4);
        }
        month = padding(calendar.get(Calendar.MONTH) + 1, 2);
        day = padding(calendar.get(Calendar.DATE), 2);
        hour = padding(calendar.get(Calendar.HOUR_OF_DAY), 2);
        min = padding(calendar.get(Calendar.MINUTE), 2);
        sec = padding(calendar.get(Calendar.SECOND), 2);

        if (type.equals(TYPE_DATE) || type.equals(TYPE_DATETIME)) {
            myDateTime = year + month + day;
        }
        if (type.equals(TYPE_TIME) || type.equals(TYPE_DATETIME)) {
            myDateTime = myDateTime + hour + min + sec;
        }
        if (style.equals(STYLE_FORMAT)) {
            myDateTime = formateDateTime(myDateTime);
        } else if (style.equals(STYLE_XML)) {
            myDateTime = strTime2XMLTime(myDateTime);
        } else if (style.equals(STYLE_FORMAT_FOR_USER)) {
            myDateTime = formateDateTimeForUser(myDateTime);
        }

        return myDateTime;
    }
    /**
     * 格式化日期时间
     *
     * @param myDateTime
     * @return
     */
    public synchronized static String formateDateTime(String myDateTime) {
        String rtnDateTime = "";
        if (myDateTime.length() == 8 || myDateTime.length() == 14) {
            rtnDateTime = myDateTime.substring(0, 4) + "-"
                    + myDateTime.substring(4, 6) + "-"
                    + myDateTime.substring(6, 8);
            if (myDateTime.length() == 14) {
                rtnDateTime = rtnDateTime + " ";
                myDateTime = myDateTime.substring(8);
            }
        }
        if (myDateTime.length() == 6) {
            rtnDateTime = rtnDateTime + myDateTime.substring(0, 2) + ":"
                    + myDateTime.substring(2, 4) + ":"
                    + myDateTime.substring(4, 6);
        }
        return rtnDateTime;
    }
    /**
     * 把字符串时间转换成xml时间
     *
     * @param xmlTime
     * @return
     */
    public synchronized static String strTime2XMLTime(String xmlTime) {
        String rtnDateTime = "";
        String timezone = "+08:00";
        if (xmlTime == null
                || (xmlTime.length() != 14 && xmlTime.length() != 6 && xmlTime
                .length() != 8)) {
            return rtnDateTime;
        }
        if (xmlTime.length() == 6 || xmlTime.length() == 8) {
            rtnDateTime = formateDateTime(xmlTime);
        } else if (xmlTime.length() == 14) {
            rtnDateTime = formateDateTime(xmlTime.substring(0, 8)) + "T"
                    + formateDateTime(xmlTime.substring(8, 14)) + timezone;
        }
        return rtnDateTime;
    }

    public synchronized static String formateDateTimeForUser(String myDateTime) {
        String rtnDateTime = "";
        if (myDateTime != null)
            myDateTime = myDateTime.trim();
        if (myDateTime.length() == 8 || myDateTime.length() == 14) {
            rtnDateTime = myDateTime.substring(0, 4) + "/"
                    + myDateTime.substring(4, 6) + "/"
                    + myDateTime.substring(6, 8);
            if (myDateTime.length() == 14) {
                rtnDateTime = rtnDateTime + " ";
                myDateTime = myDateTime.substring(8);
            }
        }
        if (myDateTime.length() == 7) {
            rtnDateTime = myDateTime.substring(0, 3) + "/"
                    + myDateTime.substring(3, 5) + "/"
                    + myDateTime.substring(5, 7);
        }
        if (myDateTime.length() == 6) {
            rtnDateTime = rtnDateTime + myDateTime.substring(0, 2) + ":"
                    + myDateTime.substring(2, 4) + ":"
                    + myDateTime.substring(4, 6);
        }
        return rtnDateTime;
    }
    /**
     * 根据所需长度补0
     *
     * @param srcLong
     *            源数
     * @param len
     *            所需长度
     * @return 所长度的字符串
     */
    public synchronized static String padding(long srcLong, int len) {
        String desString = null;
        String srcString = String.valueOf(srcLong);
        srcString = cropping(srcString, len);
        int srcLen = srcString.length();
        desString = srcString;
        for (int i = 0; i < (len - srcLen); i++) {
            desString = "0" + desString;
        }
        return desString;
    }
    /**
     * 剪裁字符串
     *
     * @param srcString
     * @param maxLen
     * @return
     */
    public synchronized static String cropping(String srcString, int maxLen) {
        String desString = null;
        byte[] desBytes = srcString.getBytes();
        if (desBytes.length > maxLen) {
            byte[] tmpBytes = cropping(desBytes, maxLen);
            desBytes = tmpBytes;
        }
        desString = new String(desBytes);
        return desString;
    }
    /**
     * 剪裁字符串成字节
     *
     * @param srcBytes
     * @param maxLen
     * @return
     */
    public synchronized static byte[] cropping(byte[] srcBytes, int maxLen) {
        byte[] desBytes = srcBytes;
        if (srcBytes.length > maxLen) {
            for (int i = 0; i < maxLen; i++) {
                if (srcBytes[i] < 0) {
                    i++;
                }
                if (i == maxLen) {
                    maxLen = maxLen - 1;
                }
            }
            byte[] tmpBytes = new byte[maxLen];
            System.arraycopy(srcBytes, 0, tmpBytes, 0, maxLen);
            desBytes = tmpBytes;
        }
        return desBytes;
    }
    /**
     * 判断当前时间是否在时间date1之前
     * @param date1
     * @return
     */
    public static boolean isDateBefore(String date1) {
        boolean flag = false;
        try {
            Date date_tmp = new Date();
            String str = DATE_FORMAT_SHORT.format(date_tmp);
            date1 = str + " " + date1;
            flag = date_tmp.before(DATE_FORMAT_FULL.parse(date1));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * 判断当前时间是否在时间date2之后
     * @param date2
     * @return
     */
    public static boolean isDateAfter(String date2) {
        boolean flag = false;
        try {
            Date date_tmp = new Date();
            String str = DATE_FORMAT_SHORT.format(date_tmp);
            date2 = str + " " + date2;
            flag = date_tmp.after(DATE_FORMAT_FULL.parse(date2));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static int getCalendar(String type){
        Calendar cal = Calendar.getInstance();
        int cnt = 0;
        if("DAY_OF_WEEK_IN_MONTH".equals(type)) {
            cnt = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        } else if("DAY_OF_WEEK".equals(type)) {
            cnt = cal.get(Calendar.DAY_OF_WEEK);
        } else if("MONTH".equals(type)) {
            cnt = cal.get(Calendar.MONTH) + 1;
        }
        return cnt;
    }
    /**
     * 获取某日期之前N天
     * @param day
     * @param diff
     * @return
     */
    public static String getDayBefore(String day, int diff) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DATE_FORMAT_SHORT.parse(day));
            calendar.add(Calendar.DATE, - diff);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return DATE_FORMAT_SHORT.format(calendar.getTime());
    }
    /**
     * 根据传进来的format格式 以及 需要格式化的String类型的字符串 转化为日期型值
     * String ---- Date
     * @param aMask
     *            format对象
     * @param strDate
     *            需要格式化的string类型字符串
     * @return 日期型
     */
    public static final Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);
        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }
        return (date);
    }

    /**
     * 判断字符串是否符合格式
     * @param date
     * @param df
     * @return
     */
    public static boolean judgeDate(String date,SimpleDateFormat df){
        boolean flag = true;
        Date d = null;
        try {
            df.setLenient(false);
            d = df.parse(date);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}


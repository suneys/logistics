package com.yoyo.listener;

import com.yoyo.util.FileUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
public class Log4jListener implements ServletContextListener {

    public static final String log4jdirkey = "log4jdir";
    private static Logger log = Logger.getLogger(Log4jListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //获取log4j配置文件的地址
        String log4jPath = servletContextEvent.getServletContext().getRealPath("/") + "config/logs";
        List<File> files = FileUtil.listFile(new File(log4jPath), "properties", false);

        if ((files == null) || (files.size() == 0)) {
            log.info("没有发现Log4j配置文件.");
            return;
        }
        for (File file : files) {
            //加载配置文件
            PropertyConfigurator.configure(file.getPath());
        }
        log.info("加载Log4j配置文件完成.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.getProperties().remove(log4jdirkey);
    }
}

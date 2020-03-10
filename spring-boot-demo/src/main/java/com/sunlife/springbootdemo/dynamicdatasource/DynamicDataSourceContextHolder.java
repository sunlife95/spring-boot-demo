package com.sunlife.springbootdemo.dynamicdatasource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunlife
 * @date 2020/2/20 15:55
 */
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static ThreadLocal<String> getContextHolder() {
        return contextHolder;
    }

    public static List<String> dataSourceIds = new ArrayList<String>();

    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static boolean containsDataSource(String dataSourceId) {
        return dataSourceIds.contains(dataSourceId);
    }

}

package com.sunlife.springbootdemo.dynamicdatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author sunlife
 * @date 2020/2/20 15:51
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        Field targetF = null;
        try {
            targetF = this.getClass().getSuperclass().getDeclaredField("targetDataSources");
            targetF.setAccessible(true);
            Map<Object, Object> targetV = (Map<Object, Object>)targetF.get(this);

            String ds = DynamicDataSourceContextHolder.getDataSourceType();

            if (ds != null) {
                System.out.println("操作的数据源是： "
                        + ds + "->url:" + ((DruidDataSource) targetV.get(ds)).getUrl());
            }
            return DynamicDataSourceContextHolder.getDataSourceType();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return "ds1";
    }
}

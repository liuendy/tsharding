package com.mogujie.tsharding.trade.db;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @author by jiuru on 16/7/14.
 */
public class DruidDataSourceFactory implements DataSourceFactory<DruidDataSource> {

    private List<Filter> filters = Collections.emptyList();

    @Override
    public DruidDataSource getDataSource(DataSourceConfig config) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
        // pool config
        dataSource.setInitialSize(config.getInitialPoolSize());
        dataSource.setMinIdle(config.getMinPoolSize());
        dataSource.setMaxActive(config.getMaxPoolSize());

        // common config
        dataSource.setFilters("stat");
        dataSource.setMaxWait(1000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(120000);
        dataSource.setTimeBetweenLogStatsMillis(0);

        dataSource.setProxyFilters(filters);

        /*过时间限制是否回收*/
//        dataSource.setRemoveAbandoned(true);
        /* 超时时间；单位为秒*/
//        dataSource.setRemoveAbandonedTimeout(120);
        /*关闭abanded连接时输出错误日志*/
//        dataSource.setLogAbandoned(true);


        dataSource.init();
        return dataSource;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

}

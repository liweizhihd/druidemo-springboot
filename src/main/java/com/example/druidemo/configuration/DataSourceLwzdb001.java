package com.example.druidemo.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.druidemo.util.DataSourceUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/28 11:04
 * @Description:
 */
@Configuration
@MapperScan(basePackages = {"com.example.druidemo.dao.lwzdb001"}, sqlSessionTemplateRef = "lwzdb001SqlSessionTemplate")
public class DataSourceLwzdb001 {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.lwzdb001")
    public DataSource lwzdb001DataSource() {
        //return DataSourceBuilder.create().build();
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactory lwzdb001SqlSessionFactory(@Qualifier("lwzdb001DataSource") DataSource dataSource)
            throws Exception {
        return DataSourceUtil.getSqlSessionFactory(dataSource, "classpath:mybatis/lwzdb001/*.xml");
    }

    /*@Bean
    public DataSourceTransactionManager lwzdb001TransactionManager(@Qualifier("lwzdb001DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    @Bean
    public SqlSessionTemplate lwzdb001SqlSessionTemplate(@Qualifier("lwzdb001SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}

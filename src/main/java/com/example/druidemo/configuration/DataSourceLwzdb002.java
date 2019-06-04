package com.example.druidemo.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.druidemo.util.DataSourceUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/28 11:04
 * @Description:
 */
@Configuration
@MapperScan(basePackages = {"com.example.druidemo.dao.lwzdb002"}, sqlSessionTemplateRef = "lwzdb002SqlSessionTemplate")
public class DataSourceLwzdb002 {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.lwzdb002")
    public DataSource lwzdb002DataSource() {
        //return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory lwzdb002SqlSessionFactory(@Qualifier("lwzdb002DataSource") DataSource dataSource)
            throws Exception {
        return DataSourceUtil.getSqlSessionFactory(dataSource, "classpath:mybatis/lwzdb002/*.xml");
    }

    /*@Bean
    public DataSourceTransactionManager lwzdb002TransactionManager(@Qualifier("lwzdb002DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    @Bean
    public SqlSessionTemplate lwzdb002SqlSessionTemplate(@Qualifier("lwzdb002SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}

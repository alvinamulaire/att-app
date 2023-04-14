package com.att.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Profile({ "local", "dev", "qas", "prd" })
@Configuration
@MapperScan(basePackages = { "com.att.mssql.repository.mapper" }, sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSourceConfig {

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory( @Qualifier("secondDataSource") DataSource dataSource ) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mssql/mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate( @Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory ) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

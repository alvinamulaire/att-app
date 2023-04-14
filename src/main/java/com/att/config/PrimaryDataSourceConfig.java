package com.att.config;

import com.sap.me.frame.JNDIUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Profile({ "dev", "qas", "prd" })
@Configuration
@MapperScan(basePackages = { "com.att.repository.mapper", "com.fw.mes.me.mapper" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class PrimaryDataSourceConfig {

    @Bean(name = "devDataSource")
    @Primary
    public DataSource devDataSource() {
        DataSource dataSource = null;
        try {
            dataSource = (DataSource) JNDIUtils.getInitialContext().lookup("jdbc/wipPool");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory( @Qualifier("devDataSource") DataSource dataSource ) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate( @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory ) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

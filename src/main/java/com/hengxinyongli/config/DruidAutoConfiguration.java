package com.hengxinyongli.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/17 10:46
 * @since <版本号>
 */
@Configuration
@ConditionalOnMissingBean({DataSource.class})
@ConditionalOnClass({DruidDataSource.class})
@EnableConfigurationProperties({DruidProperties.class})
@AutoConfigureBefore({DataSourceAutoConfiguration.class})
public class DruidAutoConfiguration {
    private static final String DATASOURCE_NAME = "datasource";

    public DruidAutoConfiguration() {
    }

    @Bean(
            name = {"datasource"}
    )
    @ConditionalOnMissingBean(
            name = {"datasource"}
    )
    @Primary
    public DataSource dataSource(DruidProperties configDruidProperties) {
        Map<String, Object> druidProperties = new HashMap(configDruidProperties.getDruid());
        this.populateDefaultProperties(druidProperties);

        try {
            DruidDataSource dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(druidProperties);
            return dataSource;
        } catch (Exception var5) {
            throw new RuntimeException("load datasource error, dbProperties is :" + druidProperties, var5);
        }
    }

    private void populateDefaultProperties(Map<String, Object> druidProperties) {
        if (druidProperties != null) {
            druidProperties.putIfAbsent("filters", "stat");
            druidProperties.putIfAbsent("initialSize", "20");
            druidProperties.putIfAbsent("maxActive", "50");
            druidProperties.putIfAbsent("minIdle", "20");
            druidProperties.putIfAbsent("testWhileIdle", "true");
            druidProperties.putIfAbsent("connectionProperties", "druid.stat.slowSqlMillis=5000");
        }
    }

}

package com.hengxinyongli.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
@ConfigurationProperties
public class DruidProperties {
    private Map<String, Object> druid;

    public DruidProperties() {
    }

    public Map<String, Object> getDruid() {
        return this.druid;
    }

    public void setDruid(Map<String, Object> druid) {
        this.druid = druid;
    }
}

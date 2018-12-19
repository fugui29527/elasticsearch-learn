package com.hengxinyongli.config;

import com.hengxinyongli.service.CompanyService;
import com.hengxinyongli.service.PersionService;
import com.hengxinyongli.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/10/10 09:31
 * @since <版本号>
 */
@Configuration
public class BeanConfig {
    @Bean
    public CompanyService getCompanyService(){
        return new CompanyService(getUserService());
    }
    @Bean
    public PersionService getPersionService(){
        return new PersionService(getUserService());
    }
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
}

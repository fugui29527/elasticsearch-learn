package com.hengxinyongli.service;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/10/10 09:35
 * @since <版本号>
 */
public class CompanyService {

    private UserService userService;

    public CompanyService(UserService userService){
        this.userService=userService;
        System.out.println("CompanyService ====:"+userService.toString());
    }

    public void sayCompanyService(){
        System.out.println("==sayCompanyService===");
    }
}

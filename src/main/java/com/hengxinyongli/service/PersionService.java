package com.hengxinyongli.service;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/10/10 09:33
 * @since <版本号>
 */
public class PersionService {

    private UserService userService;

    public PersionService(UserService userService){
        this.userService=userService;
        System.out.println("PersionService ====:"+userService.toString());
    }

    public void sayPersionService(){
        System.out.println("==sayCompanyService===");
    }
}

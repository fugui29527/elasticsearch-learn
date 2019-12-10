package com.hengxinyongli.model.es;

import lombok.Data;

import java.util.Date;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/17 10:56
 * @since <版本号>
 */
@Data
public class UserContacts {
    private long id;
    private Integer user_id;
    private String contact_phone;
    private String user_name;
    private String contact_name;
    private Date create_time;
}

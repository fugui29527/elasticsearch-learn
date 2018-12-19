package com.hengxinyongli.model.dao;

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
public class UserContacts {
    private long id;
    private long user_id;
    private long contact_phone;
    private String user_name;
    private Date create_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(long contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}

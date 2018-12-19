package com.hengxinyongli.model.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "contacts", type = "contact", indexStoreType = "fs", shards = 2, replicas = 0, refreshInterval = "-1")
public class UserContacts {
    @Id
    private long id;
    @Field(type = FieldType.Long)
    private Integer user_id;
    @Field(type = FieldType.Keyword)
    private String contact_phone;
    @Field(type = FieldType.Keyword)
    private String user_name;
    @Field(type = FieldType.Keyword)
    private String contact_name;
    @Field(type = FieldType.Date)
    private Date create_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}

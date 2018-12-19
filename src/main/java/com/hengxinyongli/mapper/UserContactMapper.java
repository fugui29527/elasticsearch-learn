package com.hengxinyongli.mapper;


import com.hengxinyongli.model.es.UserContacts;

import java.util.List;
import java.util.Map;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/17 11:14
 * @since <版本号>
 */
public interface UserContactMapper {

    public List<UserContacts> findList(Map<String,Object> prames);

}

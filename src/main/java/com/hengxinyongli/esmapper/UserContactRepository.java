package com.hengxinyongli.esmapper;

import com.hengxinyongli.model.es.UserContacts;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/17 10:55
 * @since <版本号>
 */
public interface UserContactRepository extends ElasticsearchRepository<UserContacts, Long> {
}

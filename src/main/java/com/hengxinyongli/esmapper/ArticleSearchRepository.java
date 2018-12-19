package com.hengxinyongli.esmapper;

import com.hengxinyongli.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/9/27 11:02
 * @since <版本号>
 */
public interface ArticleSearchRepository extends  ElasticsearchRepository<Article, Long> {

}

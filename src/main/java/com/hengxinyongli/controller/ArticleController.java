package com.hengxinyongli.controller;

import com.hengxinyongli.model.Article;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/9/27 11:06
 * @since <版本号>
 */
@RestController
public class ArticleController {


    @RequestMapping("/add")
    public void testSaveArticleIndex() {


        Article article = new Article();
        article.setId(1L);
        article.setTitle("html权威指南");
        article.setAbstracts("是网页设计的权威参考图书");
        article.setContent("《HTML5权威指南》面向初学者和中等水平Web开发人员，是牢固掌握");
        article.setPostTime(new Date());
        article.setClickCount(1L);

        //articleSearchRepository.save(article);
    }

    @RequestMapping("/query")
    public String testSearch() {
     /*   String queryString = "参考";//搜索关键字
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
      return "aaa";
    }
}

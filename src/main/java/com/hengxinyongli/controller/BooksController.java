package com.hengxinyongli.controller;

import com.hengxinyongli.model.Books;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/9/29 09:07
 * @since <版本号>
 */
@RestController
public class BooksController {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @RequestMapping("/addbook")
    public void testSaveBookIndex() {
        Books book =new Books();
        book.setId(10l);
        book.setBookname("java权威指南");
        book.setDesc("本书即是其中之一。通过使用JVM和Java平台，以及Java语言和应用程序接口，本书详尽讲解了Java性能调优的相关知识");
        book.setClickCount(30l);
        Books book1 =new Books();
        book1.setId(11l);
        book1.setBookname("java基础指南");
        book1.setDesc("本书即是其中之一。中影响性能的因素展开了全面深入的介绍,讲解传统上影响应用性能的JVM特征,包括即时编译器、垃圾收集、语言特征");
        book1.setClickCount(31l);
        Books book2 =new Books();
        book2.setId(12l);
        book2.setBookname("java艺术数据结构指南");
        book2.setDesc("大家一起成长市面上介绍Java的书有很多,但专注于Java性能的并不多");
        book2.setClickCount(32l);
    }

    @GetMapping("/bookquery")
    public void testSearch() {
       String queryString = "a";//搜索关键字
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
       /* QueryBuilder queryBuilder =QueryBuilders.F

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery();
        elasticsearchTemplate.queryForList(searchQuery,Books.class);*/
    }
}

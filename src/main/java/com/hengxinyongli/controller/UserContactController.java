package com.hengxinyongli.controller;

import com.hengxinyongli.service.GameRecordService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/17 14:11
 * @since <版本号>
 */
@RestController
public class UserContactController {
    private Logger logger=LoggerFactory.getLogger(getClass());
    @Autowired
    private RestHighLevelClient highLevelClient;
    @Autowired
    private GameRecordService gameRecordService;

    @GetMapping("/toes")
    public String toes(){
        gameRecordService.insert();
        return "ok";
    }

    @GetMapping("/create")
    public String create(){
        try
        {
            Map<String, Object> mappings = new HashMap<String, Object>();
            Map<String, Object> propertie = new HashMap<String, Object>();
            propertie.put("id", "long"); // id
            propertie.put("bill_no", "keyword");
            propertie.put("player_id", "keyword");
            propertie.put("platform", "keyword");
            propertie.put("game_type", "int");
            propertie.put("game_name", "keyword");
            propertie.put("bet_number", "double");
            propertie.put("valid_bet_number", "double");
            propertie.put("net_number", "double");
            propertie.put("dml", "double");
            propertie.put("flag", "int");
            propertie.put("expand_str", "keyword");

            // propertie.put("index",true);
            mappings.put("title", propertie);
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject()
                    .startObject("mappings")
                    .field("properties", propertie)
                    .endObject()
                    .startObject("settings")
                    .field("number_of_shards", 1)
                    .field("number_of_replicas", 0)
                    .endObject()
                    .endObject();

            CreateIndexRequest request = new CreateIndexRequest("demo").source(builder);
            highLevelClient.indices().create(request, RequestOptions.DEFAULT);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "create";
    }

    @GetMapping("/insert")
    public String insert(){
        try
        {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            builder.field("title", "我是一条测试文档数据");
            builder.endObject();

            IndexRequest request = new IndexRequest("demo").source(builder);
            IndexResponse resp = highLevelClient.index(request, RequestOptions.DEFAULT);
            System.out.println(resp.status().getStatus());
            System.out.println(resp.toString());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "insert";
    }
}

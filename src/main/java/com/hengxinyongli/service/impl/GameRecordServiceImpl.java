package com.hengxinyongli.service.impl;

import com.alibaba.fastjson.JSON;
import com.hengxinyongli.mapper.GameRecordMapper;
import com.hengxinyongli.model.dao.GameRecord;
import com.hengxinyongli.service.GameRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author admin
 * @title <一句话说明功能>
 * @date 2019/12/4 16:42
 * @since <版本号>
 */
@Service
@Slf4j
public class GameRecordServiceImpl implements GameRecordService {
    private static  String GAME_INDEX= "ims_game_record_2011";
    @Autowired
    private GameRecordMapper gameRecordMapper;
    @Autowired
    private RestHighLevelClient highLevelClient;

    @Override
    public void insert() {
        Map<String, Integer> prames = new HashMap<>();
        int start = 0;

        try {
            while (true) {

                List<GameRecord> list = gameRecordMapper.findList(start);
//                XContentBuilder builder = XContentFactory.jsonBuilder();
//                builder.startObject();
//                builder.field("id", list.get(0).getId());
//                builder.field("bill_no", list.get(0).getBillNo());
//                builder.field("player_id", list.get(0).getPlayerId());
//                builder.field("platform", list.get(0).getPlatform());
//                builder.field("game_type", list.get(0).getGameType());
//                builder.field("game_name", list.get(0).getGameName());
//                builder.field("bet_number", list.get(0).getBetNumber());
//                builder.field("valid_bet_number", list.get(0).getValidBetNumber());
//                builder.field("net_number", list.get(0).getNetNumber());
//                builder.field("dml", list.get(0).getDml());
//                builder.field("flag", list.get(0).getFlag());
//                builder.field("expand_str", list.get(0).getExpandStr());
//                builder.field("bet_time", list.get(0).getBetTime());
//                builder.field("beijing_time", list.get(0).getBeijingTime());
//                builder.field("create_time", list.get(0).getCreateTime());
//                builder.field("update_time", list.get(0).getUpdateTime());
//                builder.field("tax", list.get(0).getTax());
//                builder.endObject();
               // String source = JSON.toJSONString(list.get(0));
                 // log.info("====保存到es source=:{}", source);
              //  IndexRequest request = new IndexRequest("ims_game_record_2019").source(source,XContentType.JSON);
                log.info("====保存到es startpage=:{}", start);
                //IndexResponse resp = highLevelClient.index(request, RequestOptions.DEFAULT);
                BulkRequest bulkRequest = getBulkRequest(list);
                BulkResponse bulk = highLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
                log.info("====保存到es结果 status=:{} ===resp=:{}", bulk.status().getStatus(), bulk.toString());
                start += 20000;
                if(list.size()<20000){
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void search() {
//        Request request = new Request("GET", "/posts/_search");
//        request.setEntity(new NStringEntity(
//                "{\"json\":\"text\"}",
//                ContentType.APPLICATION_JSON));
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.rangeQuery("beijingTime").gte("2019-11-22T00:00:00").lt("2019-11-23T00:00:00"));
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices(GAME_INDEX);
            searchRequest.source(sourceBuilder);
            SearchResponse search = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println(search.status());
            SearchHits hits = search.getHits();
            SearchHit[] searchHit = hits.getHits();
            System.out.println(searchHit.length);
            for (SearchHit documentFields : searchHit) {
                System.out.println(documentFields.getSourceAsString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    /**
     * 查询平台
     */
    private void searchPlamt(){
        try {
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.termQuery("platform", "FG"));
            sourceBuilder.from(0);
            sourceBuilder.size(20);
            sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices(GAME_INDEX);
            searchRequest.source(sourceBuilder);
            SearchResponse search = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            System.out.println(search.status());
            SearchHits hits = search.getHits();
            TotalHits totalHits = hits.getTotalHits();
            long numHits = totalHits.value;
            System.out.println(numHits);
            log.info("===总命中数:total={}",numHits);
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit : searchHits) {
                System.out.println( hit.getSourceAsString());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private BulkRequest getBulkRequest(List<GameRecord> list){
        BulkRequest bulkRequest =new BulkRequest();
        IndexRequest indexRequest  =null;
        for (GameRecord gameRecord : list) {
            indexRequest = new IndexRequest(GAME_INDEX);
            //String source = JsonUtil.toString(gameRecord);
            String source = JSON.toJSONString(gameRecord);
            indexRequest.source(source, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        return bulkRequest;
    }

}

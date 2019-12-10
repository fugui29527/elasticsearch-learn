package com.hengxinyongli.service.impl;

import com.hengxinyongli.model.es.UserContacts;
import com.hengxinyongli.service.UserContactService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author HX
 * @title <一句话说明功能>
 * @date 2018/12/17 14:26
 * @since <版本号>
 */
@Service
public class UserContactServiceImpl implements UserContactService {

    @Autowired
    private RestHighLevelClient highLevelClient;
    @Override
    public void toes(int startPage) {
//        Map<String,Object> prames=new HashMap<>();
//        int start =startPage;
//        List<IndexQuery> indexQueries=null;
//        while (true){
//            System.out.println("==========startPage================:"+start);
//            prames.put("startPage",start);
//            List<UserContacts> list = userContactMapper.findListQuick(prames);
//            indexQueries = new ArrayList<IndexQuery>();
//            long startTime =System.currentTimeMillis();
//            System.out.println("==========start================");
//            IndexQuery indexQuery1=null;
//            for (UserContacts userContacts : list) {
//                 //userContactRepository.save(userContacts);
//                indexQuery1 = new IndexQueryBuilder().withId(String.valueOf(userContacts.getId())).withObject(userContacts).build();
//                indexQueries.add(indexQuery1);
//            }
//            elasticsearchTemplate.bulkIndex(indexQueries);
//            long endTime=System.currentTimeMillis()-startTime;
//            System.out.println("==========end ================:"+endTime);
//            if(start==0){
//                start+=50001;
//            }else{
//                start+=50000;
//            }
//            if(start>102000000){
//                break;
//            }

        UserContacts contacts =new UserContacts();
        contacts.setId(1234568L);
        contacts.setUser_id(123456799);
        contacts.setContact_phone("15181545472");
        contacts.setUser_name("李梅");
        contacts.setContact_name("胡哈");
        contacts.setCreate_time(new Date());
        try {

            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            builder.field("id", 1234568L);
            builder.field("user_id",123456800);
            builder.field("contact_phone","15181545473");
            builder.field("user_name","飞哈哈")
                    .field("contact_name","思嘿嘿")
                    .field("create_time",new Date());
            builder.endObject();
            IndexRequest request = new IndexRequest("contact_2019").source(builder);
            IndexResponse resp = highLevelClient.index(request, RequestOptions.DEFAULT);
            System.out.println(resp.status().getStatus());
            System.out.println(resp.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        //highLevelClient.
    }

}

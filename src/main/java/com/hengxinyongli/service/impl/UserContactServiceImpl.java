package com.hengxinyongli.service.impl;

import com.hengxinyongli.esmapper.UserContactRepository;
import com.hengxinyongli.mapper.UserContactMapper;
import com.hengxinyongli.model.es.UserContacts;
import com.hengxinyongli.service.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserContactMapper userContactMapper;
    @Autowired
    private UserContactRepository userContactRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Override
    public void toes(int startPage) {
        Map<String,Object> prames=new HashMap<>();
        int start =startPage;
        List<IndexQuery> indexQueries=null;
        while (true){
            System.out.println("==========startPage================:"+start);
            prames.put("startPage",start);
            List<UserContacts> list = userContactMapper.findListQuick(prames);
            indexQueries = new ArrayList<IndexQuery>();
            long startTime =System.currentTimeMillis();
            System.out.println("==========start================");
            IndexQuery indexQuery1=null;
            for (UserContacts userContacts : list) {
                // userContactRepository.save(userContacts);
                indexQuery1 = new IndexQueryBuilder().withId(String.valueOf(userContacts.getId())).withObject(userContacts).build();
                indexQueries.add(indexQuery1);
            }
            elasticsearchTemplate.bulkIndex(indexQueries);
            long endTime=System.currentTimeMillis()-startTime;
            System.out.println("==========end ================:"+endTime);
            if(start==0){
                start+=50001;
            }else{
                start+=50000;
            }
            if(start>102000000){
                break;
            }
        }
    }



}

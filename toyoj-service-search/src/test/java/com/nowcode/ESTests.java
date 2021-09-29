package com.nowcode;

import com.nowcode.search.SearchApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Title: ESTests
 * @Package: com.nowcode
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/21 17:27
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class ESTests {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;


}

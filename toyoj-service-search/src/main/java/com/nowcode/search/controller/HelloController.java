package com.nowcode.search.controller;

import com.nowcode.search.entity.Stu;
import com.nowcode.utils.JSONResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @RequestMapping("hello")
    public Object hello() {
        return JSONResponse.ok();
    }

    @GetMapping("createIndex")
    public Object createIndex() {
        esTemplate.createIndex(Stu.class);
        return JSONResponse.ok();
    }

    @GetMapping("deleteIndex")
    public Object deleteIndex() {
        esTemplate.deleteIndex(Stu.class);
        return JSONResponse.ok();
    }

    @GetMapping("addDoc")
    public Object addDoc() {
        Stu stu = new Stu();
        stu.setStuId(1002L);
        stu.setAge(18);
        stu.setName("imooc");
        stu.setMoney(100.2f);
        stu.setDescription("慕课网学习的学生");

        IndexQuery query = new IndexQueryBuilder()
                .withObject(stu)
                .build();

        esTemplate.index(query);
        return JSONResponse.ok();
    }

    @GetMapping("updateDoc")
    public Object updateDoc() {

        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put("desc", "hello world");
        updateMap.put("age", 22);

        IndexRequest ir = new IndexRequest();
        ir.source(updateMap);

        UpdateQuery uq = new UpdateQueryBuilder()
                .withClass(Stu.class)
                .withId("1001")
                .withIndexRequest(ir)
                .build();

        esTemplate.update(uq);
        return JSONResponse.ok();
    }

    @GetMapping("getDoc")
    public Object getDoc(String id) {

        GetQuery getQuery = new GetQuery();
        getQuery.setId(id);
        Stu stu = esTemplate.queryForObject(getQuery, Stu.class);
        return JSONResponse.ok(stu);
    }

    @GetMapping("deleteDoc")
    public Object deleteDoc(String id) {
        esTemplate.delete(Stu.class, id);
        return JSONResponse.ok();
    }
}

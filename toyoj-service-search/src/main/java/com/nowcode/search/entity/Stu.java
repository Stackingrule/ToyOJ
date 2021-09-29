package com.nowcode.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @Title: Stu
 * @Package: com.nowcode.search.entity
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/22 22:01
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
@Document(indexName = "stu", type = "_doc", shards = 5, replicas = 1)
public class Stu {

    @Id
    private Long stuId;
    @Field
    private String name;
    @Field
    private Integer age;
    @Field
    private float money;
    @Field
    private String description;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

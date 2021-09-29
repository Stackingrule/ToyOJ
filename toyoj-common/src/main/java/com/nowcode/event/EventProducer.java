package com.nowcode.event;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Title: EventProducer
 * @Package: com.nowcode.event
 * @description: 事件生产者
 * @author: Stackingrule
 * @created: 2021/08/26 22:45
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */
//
//@Component
//public class EventProducer {
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//
//    /**
//     * 处理事件
//     * @param event {@link Event}
//     */
//    public void fireEvent(Event event) {
//        // 将事件发布的指定Topic
//
//        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
//    }
//}
//
//

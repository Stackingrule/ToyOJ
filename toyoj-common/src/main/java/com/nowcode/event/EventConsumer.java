package com.nowcode.event;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Title: EventConsumer
 * @Package: com.nowcode.event
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/27 16:04
 * @Copyright: Copyright (c) 2021
 * @version: v1.0
 */

/**
@Component
public class EventConsumer {


    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @KafkaListener(topics = {"comment_topic"})
    public void handleEvent(ConsumerRecord record) {
        if (record == null || record.value() == null) {
            logger.error("消息内容为空");
            return;
        }

        Event event = JSONObject.parseObject(record.value().toString(), Event.class);
        if (event == null) {
            logger.error("消息格式错误!");
            return;
        }

        // TODO: 将消息插入表
    }
}

 **/

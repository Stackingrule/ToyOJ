//package com.nowcode.kafka;
//
//import com.nowcode.user.ToyojUserApplication;
//import com.nowcode.user.controller.PassportController;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @Title: KafkaTests
// * @Package: com.nowcode
// * @description:
// * @author: Stackingrule
// * @created: 2021/08/26 22:15
// * @Copyright: Copyright (c) 2021
// * @version: v1.0
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ToyojUserApplication.class)
//public class KafkaTests {
//
//
//    @Autowired
//    private KafkaProducer kafkaProducer;
//
//    @Autowired
//    private KafkaConsumer kafkaConsumer;
//
//    @Test
//    public void testKafka() {
//        kafkaProducer.sendMessage("TestTopic", "Hello!");
//        kafkaProducer.sendMessage("TestTopic", "Welcome to kafka!");
//
//        try {
//            Thread.sleep(1000 * 10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //kafkaConsumer.handleMsg();
//    }
//
//}
//
//@Component
//class KafkaProducer {
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    public void sendMessage(String topic, String context) {
//        kafkaTemplate.send(topic, context);
//    }
//}
//
//@Component
//class KafkaConsumer {
//
//    private static final Logger LOG = LoggerFactory.getLogger(KafkaListener.class);
//
//    @KafkaListener(topics = {"TestTopic"})
//    public void handleMsg(ConsumerRecord record) {
//        System.out.println("读取到" + record.topic() + "的消息: " + record.value());
//    }
//}
//

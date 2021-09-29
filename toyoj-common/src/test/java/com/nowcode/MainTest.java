package com.nowcode;

/**
 * @Title: MainTest
 * @Package: com.nowcode
 * @description:
 * @author: Stackingrule
 * @created: 2021/08/26 21:42
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
public class MainTest {



    public static void main(String[] args) {
        final User user = new User();
        user.setName("Allen");
        user.setName("Tim");
    }
    
    static class User {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        int age;
        
        
    }
}

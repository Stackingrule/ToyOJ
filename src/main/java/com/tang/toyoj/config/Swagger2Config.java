package com.tang.toyoj.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title: Swagger2Config
 * @Package: com.tang.toyoj.config
 * @description: Swagger2配置
 * @author: Stackingrule
 * @created: 2020/10/06 22:50
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * @Description: 构建 api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("使用swagger2构建ToyOJ后端api接口文档")
                // 设置联系人
                .contact(new Contact("Stackingrule", "http://www.toyoj.com", "towfubing@gmail.com"))
                // 描述
                .description("欢迎访问ToyOJ接口文档，这里是描述信息")
                // 定义版本号
                .version("1.0").build();
    }
}

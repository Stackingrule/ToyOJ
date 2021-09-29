--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `uid` bigint(20) NOT NULL,
                        `username` varchar(50) DEFAULT NULL,
                        `password` varchar(50) DEFAULT NULL,
                        `salt` varchar(50) DEFAULT NULL,
                        `email` varchar(100) DEFAULT NULL,
                        `type` int(11) DEFAULT NULL COMMENT '0-普通用户; 1-超级管理员; 2-群组管理员;',
                        `status` int(11) DEFAULT NULL COMMENT '0-未激活; 1-已激活;',
                        `activation_code` varchar(100) DEFAULT NULL,
                        `header_url` varchar(200) DEFAULT NULL,
                        `create_time` timestamp NULL DEFAULT NULL,
                        `score` int(10) default 0,
                        PRIMARY KEY (`id`),
                        KEY `index_username` (`username`(20)),
                        KEY `index_email` (`email`(20))
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

--
-- Table structure for table `user_info`
--
DROP TABLE IF EXISTS `user_info`;
SET character_set_client = utf8mb4 ;
CREATE TABLE `user_info` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `uid` bigint(20) NOT NULL AUTO_INCREMENT,
                        `username` varchar(50) DEFAULT NULL,
                        `password` varchar(50) DEFAULT NULL,
                        `salt` varchar(50) DEFAULT NULL,
                        `email` varchar(100) DEFAULT NULL,
                        `type` int(11) DEFAULT NULL COMMENT '0-普通用户; 1-超级管理员; 2-群组管理员;',
                        `status` int(11) DEFAULT NULL COMMENT '0-未激活; 1-已激活;',
                        `activation_code` varchar(100) DEFAULT NULL,
                        `header_url` varchar(200) DEFAULT NULL,
                        `create_time` timestamp NULL DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `index_username` (`username`(20)),
                        KEY `index_email` (`email`(20))
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
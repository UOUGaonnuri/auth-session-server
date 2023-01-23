CREATE TABLE `test_user` (
    `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `reg_time` datetime(6) DEFAULT NULL,
    `update_time` datetime(6) DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `modified_by` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `role` varchar(15) DEFAULT 'ROLE_USER',
    `user_email` varchar(255) DEFAULT NULL,
    `user_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `UK_q9ly291hh6rqc9103st8ry04b` (`user_email`),
    UNIQUE KEY `UK_949ggusr2b026n7txuhpmmgaa` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `todo` (
    `todo_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `reg_time` datetime(6) DEFAULT NULL,
    `update_time` datetime(6) DEFAULT NULL,
    `created_by` varchar(255) DEFAULT NULL,
    `modified_by` varchar(255) DEFAULT NULL,
    `todo_content` varchar(255) DEFAULT NULL,
    `todo_status` varchar(255) DEFAULT NULL,
    `user_id` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`todo_id`),
    KEY `FKbpfrbms901yjo6ex388cddmo1` (`user_id`),
    CONSTRAINT `FKbpfrbms901yjo6ex388cddmo1` FOREIGN KEY (`user_id`) REFERENCES `test_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
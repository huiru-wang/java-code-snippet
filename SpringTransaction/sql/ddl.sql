CREATE TABLE IF NOT EXIST `t_user` (
    `id` bigint NOT NULL COMMENT 'id',
    `username` varchar(32) DEFAULT NULL COMMENT 'name',
    `password` varchar(255) NOT NULL,
    `phone` varchar(32) DEFAULT NULL,
    `email` varchar(100) DEFAULT NULL,
    `created_at` datetime DEFAULT NULL,
    `type` int DEFAULT NULL,
    `status` int DEFAULT NULL,
    `gender` varchar(10) DEFAULT NULL,
    `gend` varchar(10) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_usernmae` (`username`),
    KEY `idx_type_status_created_at` (`type`,`status`,`created_at`),
    KEY `idx_phone_status_created_at` (`phone`,`status`,`created_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `t_order` (
    `id` bigint NOT NULL,
    `user_id` bigint NOT NULL,
    `created_at` datetime NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
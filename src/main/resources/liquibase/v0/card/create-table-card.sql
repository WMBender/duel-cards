CREATE TABLE `card`(
    id BIGINT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(200) UNIQUE NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    card_type VARCHAR(100) NOT NULL,
    card_rarity VARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

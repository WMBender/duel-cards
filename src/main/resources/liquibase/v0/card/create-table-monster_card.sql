CREATE TABLE monster_card(
    id BIGINT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(200) UNIQUE NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    card_rarity VARCHAR(100) NOT NULL,
    monster_attribute VARCHAR(50) NOT NULL,
    monster_type VARCHAR(100) NOT NULL,
    has_effect TINYINT(1) NOT NULL,
    `level` TINYINT,
    attack_points INT UNSIGNED NOT NULL,
    defense_points INT UNSIGNED NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
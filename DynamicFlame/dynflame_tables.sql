use dynamicflame;

CREATE TABLE IF NOT EXISTS `Image` (
  `image_id` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `meta_type` ENUM('JPEG', 'GIF', 'PNG') NOT NULL,
  `location` VARCHAR(255) NOT NULL,
  `upload_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`image_id`),
  CONSTRAINT `image_id`
    FOREIGN KEY (`image_id`)
    REFERENCES `Image_Album` (`image_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Image_Album` (
  `image_id` SMALLINT UNSIGNED NOT NULL,
  `album_id` SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (`image_id`, `album_id`),
  INDEX `idx_fk_image_id` (`image_id` ASC),
  INDEX `idx_fk_album_id` (`album_id` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Album` (
  `album_id` SMALLINT UNSIGNED NOT NULL DEFAULT NULL AUTO_INCREMENT,
  `album_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`album_id`),
  INDEX `idx_fk_album_id` (`album_id` ASC),
  CONSTRAINT `album_id`
    FOREIGN KEY (`album_id`)
    REFERENCES `Image_Album` (`album_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `dynamicflame`.`users` (
  `username` VARCHAR(25) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `permissions` TINYINT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `dynamicflame`.`news` (
  `story_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `subtitle` VARCHAR(45) NULL,
  `content` TEXT NOT NULL,
  `author` VARCHAR(25) NULL,
  `posted_time` TIMESTAMP NOT NULL,
  `image_id` SMALLINT(5) UNSIGNED NULL,
  `likes` TINYINT UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`story_id`),
  INDEX `idx_author` (`author` ASC),
  INDEX `image_id_idx` (`image_id` ASC),
  CONSTRAINT `news_image_id`
    FOREIGN KEY (`image_id`)
    REFERENCES `dynamicflame`.`image` (`image_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `author`
    FOREIGN KEY (`author`)
    REFERENCES `dynamicflame`.`users` (`username`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `dynamicflame`.`comments` (
  `comment_id` INT UNSIGNED NOT NULL,
  `comment` TEXT NULL,
  `author` VARCHAR(25) NOT NULL,
  `story_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `story_id_idx` (`story_id` ASC),
  INDEX `author_idx` (`author` ASC),
  CONSTRAINT `story_id`
    FOREIGN KEY (`story_id`)
    REFERENCES `dynamicflame`.`news` (`story_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `comment_author`
    FOREIGN KEY (`author`)
    REFERENCES `dynamicflame`.`users` (`username`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE user_auth ( 
 username VARCHAR(10) NOT NULL, 
 authority VARCHAR(10) NOT NULL, 
 FOREIGN KEY (username) REFERENCES users(username) 
);
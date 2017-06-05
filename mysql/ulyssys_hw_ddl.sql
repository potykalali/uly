CREATE SCHEMA `ulyssyshw` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `ulyssyshw`.`user_type` (
  `user_type_code` VARCHAR(20) NOT NULL,
  `Description` VARCHAR(45) NULL,
  PRIMARY KEY (`user_type_code`))
COMMENT = 'Constraint for user type. (Enum in java)';

CREATE TABLE `ulyssyshw`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
COMMENT = 'Application users.';

ALTER TABLE `ulyssyshw`.`user` 
ADD INDEX `fk_user_type_idx` (`type` ASC);
ALTER TABLE `ulyssyshw`.`user` 
ADD CONSTRAINT `fk_user_type`
  FOREIGN KEY (`type`)
  REFERENCES `ulyssyshw`.`user_type` (`user_type_code`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `ulyssyshw`.`application` (
  `application_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `approved` TIMESTAMP(3) NULL,
  PRIMARY KEY (`application_id`),
  INDEX `fk_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ulyssyshw`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'Applications from the users.';

CREATE TABLE `ulyssyshw`.`event` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `tstamp` TIMESTAMP(3) NOT NULL,
  `user_id` INT(11) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `successful` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`event_id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ulyssyshw`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'User events.';

ALTER TABLE `ulyssyshw`.`application` 
ADD INDEX `idx_app_user_id` (`user_id` ASC);

ALTER TABLE `ulyssyshw`.`application` 
ADD INDEX `idx_app_approved` (`approved` ASC);


CREATE OR REPLACE VIEW ulyssyshw.v_app_user AS 
SELECT u.login, u.name, a.* FROM user u, application a WHERE a.user_id = u.user_id;

CREATE OR REPLACE VIEW ulyssyshw.v_event_user AS 
SELECT u.login, u.name, e.* FROM user u, event e WHERE e.user_id = u.user_id;

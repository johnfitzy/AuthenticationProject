CREATE TABLE `database`.`client_config` (
  `client_id` VARCHAR(32) NOT NULL,
  `client_cn` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE INDEX `client_id_UNIQUE` (`client_id` ASC),
  UNIQUE INDEX `client_cn_UNIQUE` (`client_cn` ASC),
  CONSTRAINT `client_ref`
    FOREIGN KEY (`client_id`)
    REFERENCES `database`.`clientApp` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

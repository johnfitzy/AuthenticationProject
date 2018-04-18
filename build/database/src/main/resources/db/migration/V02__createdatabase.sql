CREATE TABLE `database`.`clientApp` (
  `client_id` VARCHAR(32) NOT NULL,
  `app_name` VARCHAR(45) NULL,
  `client_secret` CHAR(60) NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE INDEX `client_id_UNIQUE` (`client_id` ASC));


INSERT INTO `database`.`clientApp` (`client_id`, `app_name`, `client_secret`)
VALUES('4yh4nd6qnpjku0vw5wuevwvuwfp6uj3k','Test Application','$2a$10$cgApHE1XoRkEbgkxGrdxmePh5CRDw5hsM1F4psQAbDU0qexwua2DC');

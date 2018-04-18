
CREATE TABLE `database`.`users` (
  `username` VARCHAR(62) NOT NULL,
  `fname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `password` CHAR(60) NULL,
  PRIMARY KEY (`username`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));


INSERT INTO `database`.`users`(`username`,`fname`,`lname`,`password`)
VALUES('ray@gmail.com','Ray','Jones','$2a$10$zo8ziav/LLmibB7gPLsVA.aid/hPjFn9FUK3Bovr61Zwy6KheERCG');


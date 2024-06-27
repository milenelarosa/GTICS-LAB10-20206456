-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab10
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab10
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab10` DEFAULT CHARACTER SET utf8 ;
USE `lab10` ;

-- -----------------------------------------------------
-- Table `lab10`.`stf_puzzle_sv`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab10`.`stf_puzzle_sv` (
  `idstf_puzzle_sv` INT NOT NULL AUTO_INCREMENT,
  `n` INT NOT NULL,
  `stf_game_board_structure` VARCHAR(60) NULL,
  `image` LONGBLOB NOT NULL,
  PRIMARY KEY (`idstf_puzzle_sv`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

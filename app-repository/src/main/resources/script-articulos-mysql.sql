CREATE TABLE `articulo` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`editorial_id` INT(10) NOT NULL DEFAULT '0',
	`isbn` INT(10) NOT NULL,
	`nro_paginas` INT(10) NOT NULL,
	`idioma` VARCHAR(50) NOT NULL COLLATE 'latin1_spanish_ci',
	`fecha_publicacion` DATETIME NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_articulo_editorial` (`editorial_id`) USING BTREE,
	CONSTRAINT `FK_articulo_editorial` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='latin1_spanish_ci'
ENGINE=InnoDB
;
CREATE TABLE `editorial` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`editorial` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_spanish_ci',
	`web` VARCHAR(256) NOT NULL DEFAULT '' COLLATE 'latin1_spanish_ci',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `web` (`web`) USING BTREE
)
COLLATE='latin1_spanish_ci'
ENGINE=InnoDB
;
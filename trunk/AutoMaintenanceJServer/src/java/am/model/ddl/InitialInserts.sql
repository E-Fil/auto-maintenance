INSERT INTO `automaintenance`.`invoiceable_types` (`name`, `description`) VALUES ('Fuel', 'Fuel');
INSERT INTO `automaintenance`.`invoiceable_types` (`name`, `description`) VALUES ('Oil', 'Engine, transmission, etc.');
INSERT INTO `automaintenance`.`invoiceable_types` (`name`, `description`) VALUES ('Filter', 'Fuel, air, etc.');

INSERT INTO `automaintenance`.`invoiceables` (`name`, `description`, `cost`, `type`) VALUES ('Gasoline', 'Gasoline', 1.59, 1);
INSERT INTO `automaintenance`.`invoiceables` (`name`, `description`, `cost`, `type`) VALUES ('Gasoil', 'Gasoil', 1.39, 1);
INSERT INTO `automaintenance`.`invoiceables` (`name`, `description`, `cost`, `type`) VALUES ('Standard Oil', 'Standard engine oil', 2, 2);
INSERT INTO `automaintenance`.`invoiceables` (`name`, `description`, `cost`, `type`) VALUES ('T Oil', 'Standard transmission oil', 2.5, 2);
INSERT INTO `automaintenance`.`invoiceables` (`name`, `description`, `cost`, `type`) VALUES ('Fuel filter', 'ff', 1, 3);
INSERT INTO `automaintenance`.`invoiceables` (`name`, `description`, `cost`, `type`) VALUES ('AirFilter', 'af', 1, 3);

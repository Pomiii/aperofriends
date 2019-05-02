INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('1', 'alcool');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('2', 'soft');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('3', 'charcuterie');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('4', 'apéritif');

INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('1', 'Vin', 'assets/images/vin.jpg','3', '1');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('2', 'Bière', 'assets/images/biere.jpg','6', '1');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('3', 'Chips', 'assets/images/chips.jpg','2', '4');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('4', 'Olive', 'assets/images/olive.jpg','2', '4');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('5', 'Coca', 'assets/images/coca.jpg','2', '2');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('6', 'Ice Tea', 'assets/images/icetea.jpg','2', '2');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('7', 'Saucisson', 'assets/images/saucisson.jpg','3', '3');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('8', 'Salami', 'assets/images/salami.jpg','2', '3');

INSERT INTO `aperofriends`.`friend` (`id_friend`, `firstname_friend`, `lastname_friend`, `mail_friend`, `pass_friend`, `phonefriend`) VALUES ('1', 'Pom', 'Frais', 'pom@gmail.com', 'azerty', '06 00 00 00 00');
INSERT INTO `aperofriends`.`friend` (`id_friend`, `firstname_friend`, `lastname_friend`, `mail_friend`, `pass_friend`, `phonefriend`) VALUES ('2', 'Poire', 'Ronde', 'poire@gmail.com', 'xxxxxx', '07 00 00 00 00');
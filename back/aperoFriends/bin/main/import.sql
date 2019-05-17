INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('1', 'alcool');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('2', 'soft');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('3', 'charcuterie');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('4', 'apéritif');

INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('1', 'Vin', 'vin.jpg','3','1');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('2', 'Bière', 'biere.jpg','6', '1');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('3', 'Chips', 'chips.jpg','2', '4');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('4', 'Olive', 'olive.jpg','2', '4');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('5', 'Coca-Cola', 'coca.jpg','2', '2');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('6', 'Ice Tea', 'icetea.jpg','2', '2');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('7', 'Saucisson', 'saucisson.jpg','3', '3');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('8', 'Salami', 'salami.jpg','2', '3');

INSERT INTO `aperofriends`.`friend` (`id_friend`, `firstname_friend`, `lastname_friend`, `mail_friend`, `pass_friend`) VALUES ('1', 'KHAM', 'Pom', 'pom@test.fr', '123456');
INSERT INTO `aperofriends`.`friend` (`id_friend`, `firstname_friend`, `lastname_friend`, `mail_friend`, `pass_friend`) VALUES ('2', 'FRAP', 'Mel', 'lmf@test.com', 'azerty');
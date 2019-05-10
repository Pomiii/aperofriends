INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('1', 'alcool');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('2', 'soft');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('3', 'charcuterie');
INSERT INTO `aperofriends`.`type_item` (`id_type_item`, `name_type_item`) VALUES ('4', 'apéritif');

INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('1', 'Vin', 'assets/images/vin.jpg','3', '1');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('2', 'Bière', 'assets/images/biere.jpg','6', '1');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('3', 'Chips', 'assets/images/chips.jpg','2', '4');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('4', 'Olive', 'assets/images/olive.jpg','2', '4');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('5', 'Coca-Cola', 'assets/images/coca.jpg','2', '2');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('6', 'Ice Tea', 'assets/images/icetea.jpg','2', '2');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('7', 'Saucisson', 'assets/images/saucisson.jpg','3', '3');
INSERT INTO `aperofriends`.`item` (`id_item`, `name_item`, `pic_item`,`price_item`, `id_type_item`) VALUES ('8', 'Salami', 'assets/images/salami.jpg','2', '3');

INSERT INTO `aperofriends`.`friend` (`id_friend`, `firstname_friend`, `lastname_friend`, `mail_friend`, `pass_friend`) VALUES ('1', 'KHAM', 'Pom', 'pom@test.fr', '123456');
INSERT INTO `aperofriends`.`friend` (`id_friend`, `firstname_friend`, `lastname_friend`, `mail_friend`, `pass_friend`) VALUES ('2', 'FRAP', 'Mel', 'lmf@test.com', 'azerty');

INSERT INTO `aperofriends`.`account_friends` (`idaf`, `address_account`, `name_account`, `phone_account`) VALUES ('1', '102 rue du Casse Couille 93100 MONTREUIL', 'ANKULAR', '06 10 10 10 10 ');

INSERT INTO `ulyssyshw`.`user_type` (`user_type_code`, `Description`) VALUES ('applicant', 'Applicant requests applications.');
INSERT INTO `ulyssyshw`.`user_type` (`user_type_code`, `Description`) VALUES ('operator', 'Operator makes decisions about applications.'); 

INSERT INTO ulyssyshw.user (`user_id`,`name`,`login`,`password`,`type`) VALUES (1,'Test User 01','test01','f644a3bc48f18f88e1f94209c19cd9b1','applicant');
INSERT INTO ulyssyshw.user (`user_id`,`name`,`login`,`password`,`type`) VALUES (2,'Test User 02','test02','e65fc37bc062a190681bc4fe07cb5fe4','applicant');
INSERT INTO ulyssyshw.user (`user_id`,`name`,`login`,`password`,`type`) VALUES (3,'Test User 03','test03','b051796e4bc4e87b9eb81e24f4387e22','applicant');
INSERT INTO ulyssyshw.user (`user_id`,`name`,`login`,`password`,`type`) VALUES (4,'Operator User01','operator01','01c25bbea26630e68d33d6b2f82c6ade','operator');
INSERT INTO ulyssyshw.user (`user_id`,`name`,`login`,`password`,`type`) VALUES (5,'Operator User02','operator02','c0785660f4476aea3998588217c99e73','operator');
INSERT INTO ulyssyshw.user (`user_id`,`name`,`login`,`password`,`type`) VALUES (6,'Operator User03','operator03','43b4cd3f5cfe229be7fb300fc3a07b64','operator');
commit;

UPDATE ulyssyshw.user SET password = md5(login);
commit;

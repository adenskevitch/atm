use atm;
insert into Banks (name) values
("Alfa-bank"),
("Bank VTB"),
("Bank Dabrabyt"),
("Priorbank"),
("Belarusbank");

insert into Addresses (city, street, building) values
("Minsk","Denisovskaya","8/2"),
("Minsk","Kirova","3"),
("Minsk","Zhilunovicha", "4"),
("Minsk","Partizansky","23"),
("Minsk","Dzerzhinskogo","73a"),
("Minsk","Nezavisimosti","99/4"),
("Minsk","Mstislavca","11"),
("Minsk","Makaenka","9");

insert into ATMs (number,cash, bank_id, address_id) values
("ALFA001",345000, 1, 1),
("AKBB001",678900, 5, 6),
("BVTB001",548985, 2, 3),
("ALFA002",8364535, 1, 2),
("DABR001",34563480, 3, 7),
("BVTB002",3456875, 2, 4),
("PRIO001",64563896, 4, 5),
("AKBB002",6748634, 5, 8),
("ALFA003",3426352, 1, 4);

insert into Banknotes (denomination, number, currency_unit, atm_id) values
(5,17300, "Belarusian ruble", 1),
(10,8625, "Belarusian ruble", 1),
(20,3450, "Belarusian ruble", 1),
(50,1035, "Belarusian ruble", 1),
(100,345, "Belarusian ruble", 1),
(200,85, "Belarusian ruble", 1);

insert into Accounts (money, number, bank_id) values
(35375.30, "BY01ALFA3012678905745789",1),
(7659864.08, "BY26AKBB789564857645609",5),
(634563966.53, "BY98ALFA405564784576870",1),
(65467065487.78, "BY43OPRIO890764092578112",4),
(132787656.26, "BY51AKBB3012678905745789",5),
(45675604586.40, "BY78BVTB076235860941245",2),
(654879345.00, "BY79PRO932135683098100",4),
(8656566447.68, "BY32DABR870845465801247",3),
(9378968.22, "BY87BVTB213945205638612",2),
(5809849.15, "BY03DABR609045396714520",3),
(284867790.64, "BY65ALFA214457991760982",1),
(1939485.00, "BY06DABR123675981230784",3),
(8695.07, "BY73AKBB345943986471045",5),
(6754856.46, "BY57DABR768941674073491",3);

insert into Cards (number, pin, account_id) values 
("4578091276840365","4567",1),
("3456709774562548","9870",2),
("4657976503113769","1234",3),
("1863895250896367","6056",5),
("4763764767486012","9871",12),
("7563438059372468","0452",4),
("9534685632487634","1546",9),
("9657365642425476","4256",8),
("5635886857324243","3275",10),
("8354546509264896","2545",6),
("2656576758946103","8650",11),
("1656579375860748","7564",7),
("9466577584843559","8097",13),
("3465273538476456","0543",1),
("6457845626352357","3096",14),
("7687456837456246","7239",8),
("3468900456356576","5289",8),
("6748599966346625","3568",13);
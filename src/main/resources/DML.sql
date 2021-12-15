use atm;
insert into Banks (name) values
('Alfa-bank'),
('Bank VTB'),
('Bank Dabrabyt'),
('Priorbank'),
('Belarusbank');

insert into Addresses (city, street, building) values
('Minsk','Denisovskaya','8/2'),
('Minsk','Kirova','3'),
('Minsk','Zhilunovicha', '4'),
('Minsk','Partizansky','23'),
('Minsk','Dzerzhinskogo','73a'),
('Minsk','Nezavisimosti','99/4'),
('Minsk','Mstislavca','11'),
('Minsk','Makaenka','9');

insert into ATMs (number,cash, bank_id, address_id) values
('ALFA001',345000, 1, 1),
('AKBB001',678900, 5, 6),
('BVTB001',548985, 2, 3),
('ALFA002',8364535, 1, 2),
('DABR001',34563480, 3, 7),
('BVTB002',3456875, 2, 4),
('PRIO001',64563896, 4, 5),
('AKBB002',6748634, 5, 8),
('ALFA003',3426352, 1, 4);

insert into Banknotes (denomination, number, currency_unit, atm_id) values
(200,85, 'Belarusian ruble', 1),
(100,345, 'Belarusian ruble', 1),
(50,1035, 'Belarusian ruble', 1),
(20,3450, 'Belarusian ruble', 1),
(10,8625, 'Belarusian ruble', 1),
(5,17300, 'Belarusian ruble', 1);

insert into Accounts (money, number, bank_id) values
(35375.30, 'BY01ALFA3012678905745789',1),
(7659864.08, 'BY26AKBB789564857645609',5),
(63456396.53, 'BY98ALFA405564784576870',1),
(65467065.78, 'BY43OPRIO890764092578112',4),
(13278765.26, 'BY51AKBB3012678905745789',5),
(45675604.40, 'BY78BVTB076235860941245',2),
(65487934.00, 'BY79PRO932135683098100',4),
(86565664.68, 'BY32DABR870845465801247',3),
(9378968.22, 'BY87BVTB213945205638612',2),
(5809849.15, 'BY03DABR609045396714520',3),
(28486779.64, 'BY65ALFA214457991760982',1),
(1939485.00, 'BY06DABR123675981230784',3),
(8695.07, 'BY73AKBB345943986471045',5),
(675485.46, 'BY57DABR768941674073491',3);

insert into Cards (number, pin, account_id) values 
('78d3a9c46e2d551e459171ddedae8801da221b2401f9288745c510aa2521475a','db2e7f1bd5ab9968ae76199b7cc74795ca7404d5a08d78567715ce532f9d2669',1),
('fe896898ecec7fbec2e4c6ab32d4ed7befccb4c7491de058c0f1f9158f3efac3','01b347421433eccdad2e9f6885386c67057d51c6741f4aec5465010301e70791',2),
('04fefe2dc94ad6845a496a621700b611485722249762be7b0f656a97682150ab','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',3),
('336195f5e78196d427f8ac01af48c80079ae7f663160556a4b768dc01b643f3a','005fc4185b4f6096a1c6273010e11d67b436b338d6168bd54ccb9ecbaf2d7a27',5),
('72633620e62a880bdebbfabdc5fd2106c7857cd0fd49e4665eb0c57d711616b9','5f8d869fb478ab996da5b19c160fbe542fb565164cb648e8132974050d524df5',12),
('5118fef27267bb9c7b24ff6b155d252d4c05bf2c4a8d353804c8b22305c6176e','a25f5f5b1d12f03738f1e9e18c1e82dc7d671cc1a5f820e81d52c66a9167a687',4),
('22f76c188a989afe6528c429d46f0ae30eb75e0dc31450a1bda733fdfcc5a3f5','495afe547befeedeef191264812945e2c199da63da0e8dfde79bee7dbecb210f',9),
('60d15a0a78e149a0270d3d918e6c36932b43f5f93dd630eaeeb3a7fdf1d803de','9cf876e274c8bbc32e1ad874ee32f4d7c10c9a3f14a77931ea1f27acedad9d09',8),
('c5c697974c32186ebf39ab1e3cd332e66c749e3f6d7f93b9f2a291a1448cb4cd','26a020fdeb929b63b99ce0c66a95dec62364d84b3be7647b8453a0dbdce8d550',10),
('cd62cf9c9ffac0487d2b92a8c10612962ba032da1515f818e587ad785e8c77d9','a812c832adb8c843f1ddb02534f58f4244da39f526cb9296f397e5c03c559f52',6),
('54e6809d8172e5ebf0b23f7f7b31306c77250c8a16f0a810c988fce4279fd074','c288691bf8994f80e618d9ad85b7ca0e78ab09f95979e8f7682b754f1c06c681',11),
('c86f487d2b0820746e46f1a597b4be6907bfbc833d2ee1dfd1838984752db402','6dc32ae01ea2417f37f28b4acb7079d3d20ab741b88a9862fa06be0ed64af44f',7),
('865fbd22f8d4f3fecc0e2acf678870da3c0cc714db58ed17aebe5378e4398e19','f60dfcd2ab5bfb81c68082a92034f0a73cfcde11f914699c3e7f8dead61d7c96',13),
('8b455c6687722da711a36fe757b0a5c12dd874e7ab53e4aa76a5bb052d126815','e3ddd04bb0a8ca43b7d0acb1352eed64047dd634a95007e3c4d3bd274ee97155',1),
('c843259e5e6e097b5f1cea7f4d949e4d5e9884cd1b07753bcfa1ef543a957d6b','c1a6860e444ca046186f732c967079e88e0a7a8674704af5db51d34ecbe674f9',14),
('219bc62dc604b8c9f112101b7862a63d8ca68ec7b3ca4317d351395b2a477355','920a46c32b7493a13695db8b8fba08737779f9f9c5c5482c42429ac0b0845cd4',8),
('83434e8ea8cb7ae78cac4ae05cd1a2a37e70d4dd4cf70e2297fa1d391f3a37bc','22d04f665519fd8091f873476b0b4be4ad02abe10c610b1f81611b7cc37d6146',8),
('0d5b1c38e4a45e5b4bd2eddbc0ab5f50481c377066e86393a37e1b5757ab43f2','ad361d0f210a313d7e192498661c9173c2e1afca56c15722f2979cbdc4e0e80c',13);
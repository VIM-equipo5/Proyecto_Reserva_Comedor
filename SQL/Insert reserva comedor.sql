USE reserva_comedor;

INSERT INTO rol (NombreRol, Descripcion) VALUES
('administrador', 'Usuario administrativo, con autorizacion para hacer gestiones internas sobre la base de datos de la aplicacion'),
('usuario', 'Usuario llano, con autorizacion solo para realizar reservas');

INSERT INTO bebidas (Nombre, PrecioUnitario, Descripcion) VALUES
('Refresco', '1', 'Coca-cola, Coca-cola Zero, Fanta naranja, Fanta limón, Sprite'),
('Zumo de naranja', '1.5', 'Zumo de naranja'),
('Zumo de melocotón', '1.5', 'Zumo de melocotón'),
('Zumo de manzana', '1.5', 'Zumo de manzana'),
('Agua 0,5L', '0.75', 'zumo de naranja');

INSERT INTO categoria (Nombre, Descripcion) VALUES
('Entrante', 'Pica-pica, tablas de queso y embutidos, crudité con hummus'),
('Primer plato', 'Ensaladas, cremas y platos ligeros'),
('Segundo plato', 'Platos principales'),
('Postre', 'Platos dulces y fruta');

INSERT INTO platos (Nombre, Descripcion, PrecioUnitario, Tipo, IdCategoria) VALUES
-- Entrantes (1-5)
('Patatas','Patatas de bolsa al punto de sal',1.25,'Para abrir el apetito',1),
('Olivas','Olivas \'Receta de la abuela\'',1,'Para abrir el apetito',1),
('Gazpacho','Auténtico gazpacho andaluz',2.5,'Para abrir el apetito',1),
('Hummus','Pasta de garbanzos acompañada de crudité de verduras para mojar',4,'Para abrir el apetito',1),
('Setas','Setas con yema de huevo',4,'Para abrir el apetito',1),
-- Primeros platos (6-13)
('Ensalada César','Lechuga romana, queso parmesano, croutons y salsa César',6.5,'Ensaladas',2),
('Ensalada Caprese','Queso caprese, tomate y albahaca',5.5,'Ensaladas',2),
('Ensalada Waldorf','Apio, manzana, nueces, pasas y mayonesa',6.25,'Ensaladas',2),
('Ensalada griega','Lechuga, tomate, aceitunas negras y queso feta',5,'Ensaladas',2),
('Crema de calabaza y zanahoria','Crema de calabaza y zanahoria',4.5,'Cremas',2),
('Crema de verduras','Crema de verduras variadas (calabacín, puerro, cebolleta, zanahoria y patata)',4.5,'Cremas',2),
('Melón con jamón','Melón con jamón',6.75,'Platos ligeros',2),
('Ensalada templada de arroz','Ensalada de arroz templado con verduras(calabacín, pimiento, maíz dulce y aguacate)',0,'Platos ligeros',2),
-- Segundos platos (14-22)
('Tataki de atún','Cortes de atún semihechos, acompañados de algas wakame y salsa ponzu',11,'Pescados',3),
('Dorada a la marsellesa','Cortes de dorada acompañados de tomate, alcaparras, aceitunas y anchoas',12,'Pescados',3),
('Salmón de la casa','Salmón al horno con salsa de cítricos',9,'Pescados',3),
('Milanesa de ternera invertida','Escalope de ternera, queso y tomate acompañado de brotes tiernos',7.5,'Carnes',3),
('Pollo al estragón con verduras','Pollo al estragón con guarnición de verdura campestre',9,'Carnes',3),
('Entrecot al roquefort','Entrecot de buey con salsa de queso roquefort y patatas',12.5,'Carnes',3),
('Arroz a la cubana','Arroz con huevos fritos, salsa de tomate y plátano frito',6.75,'Vegetarianos',3),
('Poke vegano','Bol de arroz con algas wakame, aguacate y tofu',8.5,'Vegetarianos',3),
('Melanzane alla parmigiana','Lasaña de berenjena rellena de tomate y queso parmesano',8,'Vegetariano',3),
-- Postres (23-27)
('Flan de huevo','Huevo cuajado al baño María con canela',1.25,'Dulces',4),
('Mousse de chocolate','Crema de leche batida con chocolate negro',1,'Dulces',4),
('Músico','Frutos secos y moscatel',2,'Dulces',4),
('Crema catalana','Crema pastelera con base de yema cubierta por azúcar caramelizado',1.25,'Dulces',4),
('Fruta de temporada','Manzanas, plátanos, peras o mandarinas',0.75,'Dulces',4);

INSERT INTO usuario (NombreUsuario, Contraseña, Nombre, Apellido, FechaNacimiento, DNI, Telefono, idRol) VALUES
("UsuarioAdmin1","NoMeRobesPorFavor","Alba","Álvarez","1980-01-01",'A0000001',607543432,1),
("UsuarioAdmin2","NoMeRobesPorFavor","Benito","Bastos","1981-08-15",'B0000002',634598721,1),
("Usuario1","NoMeRobesPorFavor","Carmen","Castaño","1982-07-14",'C0000003',667246678,2),
("Usuario2","NoMeRobesPorFavor","Diego","Descamps","1973-06-19",'D0000004',621598888,2),
("Usuario3","NoMeRobesPorFavor","Emma","Echavarría","1983-06-22",'E0000005',607476521,2),
("Usuario4","NoMeRobesPorFavor","Francisco","Fuertes","1961-11-23",'F0000006',645987632,2),
("Usuario5","NoMeRobesPorFavor","Gabriela","Genover","1977-12-09",'G0000007',621478965,2),
("Usuario6","NoMeRobesPorFavor","Héctor","Hernández","1969-03-07",'H0000008',607548652,2),
("Usuario7","NoMeRobesPorFavor","Ingrid","Ibarra","1989-03-23",'I0000009',607159357,2),
("Usuario8","NoMeRobesPorFavor","Joan","Jofresa","1991-04-25",'J0000010',612345687,2),
("Usuario9","NoMeRobesPorFavor","Kelly","Kensington","1995-09-29",'K0000011',622312258,2),
("Usuario10","NoMeRobesPorFavor","Leorio","Lanero","1987-01-02",'L0000012',667899334,2),
("Usuario11","NoMeRobesPorFavor","Marta","Márquez","1999-01-01",'M0000013',662444512,2),
("Usuario12","NoMeRobesPorFavor","Néstor","Nabal","2000-05-14",'N0000014',697211324,2),
("Usuario13","NoMeRobesPorFavor","Olga","Ortiz","1984-08-15",'O0000015',612841112,2),
("Usuario14","NoMeRobesPorFavor","Pablo","Puerta","1984-08-12",'P0000016',634559621,2),
("Usuario15","NoMeRobesPorFavor","Qamra","Quesille","1999-09-19",'Q0000017',617999129,2),
("Usuario16","NoMeRobesPorFavor","Rodrigo","Requena","1972-04-28",'R0000018',632646656,2),
("Usuario17","NoMeRobesPorFavor","Sandra","Sandoval","2000-02-01",'S0000019',647802020,2),
("Usuario18","NoMeRobesPorFavor","Terry","Tan","1974-11-20",'T0000020',622196324,2);

INSERT INTO franjahoraria (CapacidadMax,OcupacionTotal,FranjaInicio,FranjaFin) VALUES
(10,0,1200,1215),
(10,0,1215,1230),
(10,0,1230,1245),
(10,0,1245,1300),
(10,0,1300,1315),
(10,0,1315,1330),
(10,0,1330,1345),
(10,0,1345,1400),
(10,0,1400,1415),
(10,0,1415,1430),
(10,0,1430,1445),
(10,0,1445,1500);

INSERT INTO reserva (CantidadComensales, PrecioTotal, FechaReservada, idUsuario, idFranja) VALUES 
(3, 54, '2021-04-01',3,7),
(2, 28.25, '2021-04-01',6,10),
(2, 28.5, '2021-04-01',8,10),
(1, 17.25, '2021-04-01',9,2),
(3, 47.25, '2021-04-01',10,3),
(2, 33, '2021-04-01',13,5),
(1, 16.75, '2021-04-01',14,7),
(1, 15.5, '2021-04-01',15,10),
(1, 40.5, '2021-04-01',16,11),
(2, 21.25, '2021-04-01',17,2),
(2, 22.5, '2021-04-02',2,6),
(1, 13, '2021-04-02',3,7),
(3, 52.25, '2021-04-02',4,1),
(2, 32.5, '2021-04-02',7,5),
(1, 16.5, '2021-04-02',8,10),
(1, 14.25, '2021-04-02',9,12),
(2, 34.5, '2021-04-02',10,10),
(3, 42.75, '2021-04-02',12,10),
(4, 58.75, '2021-04-05',3,7),
(2, 19.75, '2021-04-05',7,5);

INSERT INTO pedirplatos (IdReserva, IdPlato, CantidadPlatos) VALUES
(1, 6, 1),
(1, 7, 2),
(1, 15, 1),
(1, 18, 1),
(1, 19, 1),-- 
(2, 8, 1),
(2, 9, 1),
(2, 20, 1),
(2, 21, 1),-- 
(3, 8, 2),
(3, 20, 2),-- 
(4, 10, 1),
(4, 15, 1),-- 
(5, 9, 2),
(5, 10, 1),
(5, 18, 2),
(5, 19, 1),-- 
(6, 4, 1),
(6, 7, 1),
(6, 8, 1),
(6, 20, 1),
(6, 21, 1),-- 
(7, 8, 1),
(7, 22, 1),
(7, 27, 1),-- 
(8, 7, 1),
(8, 21, 1),
(8, 27, 1),-- 
(9, 8, 1),
(9, 20, 1),
(9, 26, 1),-- 
(10, 9, 2),
(10, 22, 1),
(10, 23, 1),-- 
(11, 10, 1),
(11, 16, 1),
(11, 17, 1),--
(12, 11, 1),
(12, 20, 1),
(12, 27, 1),--
(13, 4, 1),
(13, 5, 1),
(13, 9, 2),
(13, 10, 1),
(13, 21, 2),
(13, 22, 1),
(13, 26, 2),
(13, 27, 1),--
(14, 9, 2),
(14, 19, 1),
(14, 21, 1),--
(15, 11, 1),
(15, 16, 1),
(15, 25, 1),--
(16, 9, 1),
(16, 17, 1),
(16, 27, 1),--
(17, 10, 2),
(17, 19, 1),
(17, 21, 1),
(17, 26, 2),--
(18, 11, 2),
(18, 12, 1),
(18, 20, 1),
(18, 21, 1),
(18, 22, 1),
(18, 27, 2),-- 
(19, 1, 2),
(19, 2, 2),
(19, 6, 1),
(19, 9, 1),
(19, 12, 1),
(19, 15, 1),
(19, 16, 2),
(19, 17, 1),
(19, 18, 1),
(19, 24, 2),
(19, 25, 2),-- 
(20, 11, 2),
(20, 22, 1),
(20, 23, 1);-- 

INSERT INTO ofrecerbebidas (IdReserva, IdBebida, CantidadBebidas) VALUES
(1, 5, 2),
(1, 3, 1),-- 3
(2, 1, 1),
(2, 5, 1),-- 1.75
(3, 1, 1),
(3, 4, 1),-- 2.5
(4, 5, 1),-- 0.75
(5, 5, 3),-- 2.25
(6, 1, 2),-- 2
(7, 5, 1),
(7, 1, 1),-- 1.75
(8, 5, 1),-- 0.75
(9, 5, 1),-- 0.75
(10, 1, 2),-- 2
(11, 5, 2),-- 1.5
(12, 1, 1),-- 1
(13, 4, 1),-- 1.5
(13, 5, 2),-- 1.5
(14, 5, 2),-- 1.5
(15, 1, 1),-- 1
(16, 1, 1),-- 1
(17, 1, 2),-- 2
(18, 5, 3),-- 2.25
(19, 1, 1),
(19, 2, 1),
(19, 5, 2),-- 4
(20, 5, 2);-- 1.5

-- Deberíamos crear un campo extra a los platos/bebidas que indique si están disponibles o no?


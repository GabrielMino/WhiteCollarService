INSERT INTO SHOP VALUES (1, 2, 'Shop1');
INSERT INTO SHOP VALUES (2, 5, 'Shop2');

INSERT INTO PICTURES(id,author,name,price,date,shop_id) VALUES (null, 'Da Vinci', 'La Virgen de las rocas',200,CURDATE(),1);
INSERT INTO PICTURES(id,author,name,price,date,shop_id) VALUES (null, 'Picasso','Guernica',300,CURDATE(), 1);
INSERT INTO PICTURES(id,author,name,price,date,shop_id) VALUES (null, 'Monet',  'Sol naciente',400, CURDATE(), 2);
INSERT INTO PICTURES(id,author,name,price,date,shop_id) VALUES (null, 'Velazquez','Meninas',500,CURDATE(), 2);
-- CATEGORÍA

-- INSERT INTO Category (nombre, id) VALUES ('nombre', nextval('category_seq'));

INSERT INTO Category (nombre, id) VALUES ('SMT 1', 1);
INSERT INTO Category (nombre, id) VALUES ('SMT 3', 2);
INSERT INTO Category (nombre, id) VALUES ('SMT 4', 3);

ALTER SEQUENCE category_seq RESTART WITH 53;


-- PRODUCTOS

-- INSERT INTO Product (nombre, descripcion, precio, categoria, id) VALUES ('COMP', 'Ordenador portatil con forma de guante que permite invocar y guardar demonios', 366.66, currval('categoria_seq'), nextval('product_seq'));

INSERT INTO Product (nombre, descripcion, precio, categoria_id, id) VALUES ('COMP', 'Ordenador pórtatil con forma de guante que permite invocar y guardar demonios', 366.66, 1, 1);
INSERT INTO Product (nombre, descripcion, precio, categoria_id, id) VALUES ('Magatama', 'Obsequio del rey de los demonios para convertir a alguien en su fiel y más poderoso sirviente', 20.000, 2, 2);
INSERT INTO Product (nombre, descripcion, precio, categoria_id, id) VALUES ('Uniforme de samurái de Mikado', 'Prenda de ropa que portan los elegidos del ritual del héroe a la hora de defender el antiguo reino de Mikado', 50.00, 3, 3);

ALTER SEQUENCE product_seq RESTART WITH 53;




















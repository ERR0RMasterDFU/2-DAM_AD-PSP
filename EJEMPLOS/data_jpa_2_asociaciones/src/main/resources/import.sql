INSERT INTO Category (nombre, id) VALUES ('SMT', nextval('category_seq'))

INSERT INTO Product (nombre, descripcion, precio, categoria, id) VALUES ('COMP', 'Ordenador pórtatil con forma de guante que permite invocar y guardar demonios', 366.66, currval('categoria_seq'), nextval('product_seq'));

























INSERT INTO categoria(nome) VALUES ('Tecnologia'), ('Escritorio');


INSERT INTO produto(nome, preco, categoria_id) VALUES ('Notebook', 2000.0, 1);
INSERT INTO produto(nome, preco, categoria_id) VALUES ('Impressora', 800.0, 2);
INSERT INTO produto(nome, preco, categoria_id) VALUES ('Mouse', 80.0, 1);

INSERT INTO estado(nome) VALUES ('São Paulo'), ('Minas Gerais');

INSERT INTO cidade(nome, estado_id) VALUES ('Uberlândia', 2);
INSERT INTO cidade(nome, estado_id) VALUES ('Embu das Artes', 1);
INSERT INTO cidade(nome, estado_id) VALUES ('Taboão da Serra', 1);
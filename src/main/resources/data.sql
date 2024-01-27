INSERT INTO usuario (name, password) VALUES ('admin',  '$2y$10$Ypptc4erRUfHO6jpPynH.uMazTiyqKnBkaa/udvuOgJ/RMdqKjBQy');
INSERT INTO usuario (name, password) VALUES ('user',  '$2y$10$Ypptc4erRUfHO6jpPynH.uMazTiyqKnBkaa/udvuOgJ/RMdqKjBQy');

INSERT INTO role (authority) VALUES ('ROLE_COMUM');
INSERT INTO role (authority) VALUES ('ROLE_ADMIN');


INSERT INTO usuario_role (usuario_id, role_id) VALUES (1, 2);
INSERT INTO usuario_role (usuario_id, role_id) VALUES (2, 1);
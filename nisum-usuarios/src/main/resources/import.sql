INSERT INTO usuarios(username, password,  enabled, nombre, apellido, email)VALUES('eder', '$2a$10$nGXT5L/JFHr9jD1lEhd4p.RtLp0GEX7/xAlMnQZND5f50mVxFy29O', 1, 'Eder', 'Casarrubia', 'casarrubia999@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre,  apellido, email)VALUES('luis', '$2a$10$gJrduFyWnxmL5xDL23FCk.1XlI8D15IUyurFk4wgZpesESiKH4yIK', 1, 'Luis', 'Sandon', 'luis@gmail.com');

INSERT INTO roles(nombre)VALUES('ROLES_USER');
INSERT INTO roles(nombre)VALUES('ROLES_ADMIN');

INSERT INTO usuarios_roles(usuario_id, role_id)VALUES(1, 1);
INSERT INTO usuarios_roles(usuario_id, role_id)VALUES(2, 2);
INSERT INTO usuarios_roles(usuario_id, role_id)VALUES(2, 1);

INSERT INTO telefono(number, citycode, contrycode)VALUES('6523145', '1', '57');
INSERT INTO telefono(number, citycode, contrycode)VALUES('6589526', '2', '34');
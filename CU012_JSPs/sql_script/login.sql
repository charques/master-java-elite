DROP TABLE usuarios;

CREATE TABLE usuarios
(
username VARCHAR2(32) NOT NULL,
password VARCHAR2(32) NOT NULL,
nombre VARCHAR2(60) NOT NULL,
CONSTRAINT pk_usuarios PRIMARY KEY (username)
);

-- usuario: admin
-- password: admin
INSERT INTO usuarios VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'Usuario test');
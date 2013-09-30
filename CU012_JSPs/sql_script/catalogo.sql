DROP TABLE items;
DROP TABLE soportes_config;
DROP TABLE tipos_config;

DROP SEQUENCE items_seq;
DROP SEQUENCE soportes_seq;
DROP SEQUENCE tipos_seq;

/* CREA TABLAS */
CREATE TABLE items
(
item_id NUMBER(4),
item_titulo VARCHAR2(60) NOT NULL,
item_autor VARCHAR2(60) NOT NULL,
soporte_id NUMBER(4) NOT NULL,
tipo_id NUMBER(4) NOT NULL,
item_anio NUMBER(4),
CONSTRAINT pk_item PRIMARY KEY (item_id)
);

CREATE TABLE soportes_config 
(
soporte_id NUMBER(4),
soporte_desc VARCHAR2(60),
CONSTRAINT pk_soporte PRIMARY KEY (soporte_id)
);

CREATE TABLE tipos_config 
(
tipo_id NUMBER(4),
tipo_desc VARCHAR2(60),
CONSTRAINT pk_tipo PRIMARY KEY (tipo_id)
);

/* CREA SEQUENCIAS */
CREATE SEQUENCE items_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
CREATE SEQUENCE soportes_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
CREATE SEQUENCE tipos_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

/* INSERTA CONFIGURACION */    
INSERT INTO soportes_config (soporte_id, soporte_desc) VALUES (soportes_seq.nextval, 'CD');
INSERT INTO soportes_config (soporte_id, soporte_desc) VALUES (soportes_seq.nextval, 'DVD');
INSERT INTO soportes_config (soporte_id, soporte_desc) VALUES (soportes_seq.nextval, 'Bluray');
INSERT INTO tipos_config (tipo_id, tipo_desc) VALUES (tipos_seq.nextval, 'Mœsica');
INSERT INTO tipos_config (tipo_id, tipo_desc) VALUES (tipos_seq.nextval, 'Cine');
INSERT INTO tipos_config (tipo_id, tipo_desc) VALUES (tipos_seq.nextval, 'VideoJuegos');

SELECT * FROM soportes_config;
SELECT * FROM tipos_config;

/* INSERTA ITEMS CATALOGO */
INSERT INTO items (item_id, item_titulo, item_autor, soporte_id, tipo_id, item_anio) VALUES (items_seq.nextval, 'OK Computer', 'Radiohead', 1, 1, 2000);

SELECT * FROM items;



SELECT i.item_id, i.item_titulo, i.item_autor, i.soporte_id, s.soporte_desc, i.tipo_id, t.tipo_desc, i.item_anio 
FROM items i, soportes_config s, tipos_config t
WHERE i.soporte_id = s.soporte_id 
  AND i.tipo_id = t.tipo_id
  AND i.tipo_id = 1;
CREATE SEQUENCE contacts_jsf_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE TABLE contacts_jsf 
(
  itemId NUMBER(4) NOT NULL,
  nombre VARCHAR2(60) NOT NULL,
  apellidos VARCHAR2(60) NOT NULL,
  fechaNac DATE DEFAULT SYSDATE NOT NULL,
  email VARCHAR2(60) NOT NULL,
CONSTRAINT pk_contacts_jsf PRIMARY KEY (itemId)
);

INSERT INTO contacts_jsf (itemId, nombre, apellidos, fechaNac, email) VALUES (contacts_jsf_seq.nextval, 'juan', 'prueba', TO_DATE('14/02/1980','dd/mm/yyyy'), 'prueba@prueba.com');

SELECT *
FROM contacts_jsf;
/************************************************/
/* CU001_MOD01_NX001_TA02_Ejercicios_practicos  */
/************************************************/
/* Carlos Felipe Hernández Arques  - Julio 2012 */
/************************************************/

/* ELIMINA */
DROP TABLE regiones_actividades;
DROP TABLE actividades;
DROP TABLE censor;
DROP TABLE regiones;
DROP TABLE pauses;

DROP SEQUENCE paises_seq;
DROP SEQUENCE regiones_seq;
DROP SEQUENCE censo_seq;
DROP SEQUENCE actividades_seq;

/* CREA TABLAS */
CREATE TABLE paises
(
id_pais NUMBER(4),
nombre VARCHAR2(25) NOT NULL,
capital VARCHAR2(25) NOT NULL,
presupuesto NUMBER(10) NOT NULL,
CONSTRAINT pk_paises PRIMARY KEY (id_pais),
CONSTRAINT check_presupuesto CHECK (presupuesto > 0)
);

CREATE TABLE regiones
(
id_region NUMBER(4),
id_pais NUMBER(4) NOT NULL,
nombre VARCHAR2(25) NOT NULL,
extension NUMBER(8) NOT NULL,
población NUMBER(10,3) NOT NULL,
u_pobreza NUMBER(9,1) NOT NULL,
CONSTRAINT pk_regiones PRIMARY KEY (id_region),
CONSTRAINT fk_paises_reg FOREIGN KEY (id_pais) REFERENCES paises,
CONSTRAINT check_extension CHECK (extension > 0),
CONSTRAINT check_poblacion CHECK (población > 0),
CONSTRAINT check_u_pobreza CHECK (u_pobreza > 0)
);


CREATE TABLE censo
(
id_censo NUMBER(4),
nombre VARCHAR2(25) NOT NULL,
sexo CHAR(1) NOT NULL,
id_pais_nacionalidad NUMBER(4) NOT NULL,
id_region_censo NUMBER(4) NOT NULL,
ingresos NUMBER(9,1) NOT NULL,
cod_identifica VARCHAR2(9) NOT NULL,
CONSTRAINT pk_censo PRIMARY KEY (id_censo),
CONSTRAINT fk_paises_cen FOREIGN KEY (id_pais_nacionalidad) REFERENCES paises,
CONSTRAINT fk_regiones_cen FOREIGN KEY (id_region_censo) REFERENCES regiones,
CONSTRAINT check_valor_sexo CHECK ((sexo = 'V') OR (sexo = 'M')),
CONSTRAINT check_ingresos CHECK (ingresos > 0),
CONSTRAINT cod_identifica_unique UNIQUE (cod_identifica)
);

CREATE TABLE actividades
(
id_actividad NUMBER(4),
nombre VARCHAR2(25) NOT NULL,
costo_anio_persona NUMBER(6) NOT NULL,
CONSTRAINT pk_actividades PRIMARY KEY (id_actividad),
CONSTRAINT check_costo CHECK (costo_anio_persona > 0)
);

CREATE TABLE regiones_actividades
(
id_region NUMBER(4),
id_actividad NUMBER(4),
fecha_inicio DATE DEFAULT SYSDATE NOT NULL,
dias_actividad NUMBER(4) NOT NULL,
CONSTRAINT pk_regiones_actividades PRIMARY KEY (id_region, id_actividad),
CONSTRAINT check_dias_actividad CHECK (dias_actividad > 0)
);

/* CREA SEQUENCIAS */
CREATE SEQUENCE paises_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE SEQUENCE regiones_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
CREATE SEQUENCE censo_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

CREATE SEQUENCE actividades_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

/* INSERTA DATOS */
INSERT INTO paises (id_pais, nombre, capital, presupuesto) VALUES (paises_seq.nextval, 'Bolivia', 'La Paz', 2500000);
INSERT INTO paises (id_pais, nombre, capital, presupuesto) VALUES (paises_seq.nextval, 'Peru', 'Lima', 1453000);
INSERT INTO paises (id_pais, nombre, capital, presupuesto) VALUES (paises_seq.nextval, 'Ecuador', 'Quito', 900000);
INSERT INTO paises (id_pais, nombre, capital, presupuesto) VALUES (paises_seq.nextval, 'Paraguay', 'Asunción', 1854000);
INSERT INTO paises (id_pais, nombre, capital, presupuesto) VALUES (paises_seq.nextval, 'Chile', 'Santiago',4834300);

INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 1, 'Santa Cruz', 85487, 820833, 734);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 1, 'Pando', 8952, 76328, 823);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 1, 'La Paz', 13283, 2109234, 922);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 1, 'Beni', 34873, 290234, 843);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 1, 'Cochabamba', 103000, 992837, 998);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 2, 'Loreto', 253838, 121002, 1920);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 2, 'Cajamarca', 8276, 192847, 2023);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 2, 'Junin', 7265, 187264, 1754);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 2, 'Lima', 2637, 7600393, 2401);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 2, 'Puno', 10672, 2323423, 2183);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 3, 'Pastaza', 34837, 237383, 1400);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 3, 'Napo', 4536, 201923, 1345);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 3, 'Los Rios', 3425, 148373, 2021);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 3, 'Loja', 2918, 123726, 1986);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 3, 'El Oro', 1876, 89862, 1674);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 4, 'Boquerón', 87300, 168284, 1023);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 4, 'Cordillera', 2787, 9037, 1102);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 4, 'Misiones', 1872, 19837, 903);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 4, 'Concepción', 2324, 34994, 987);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 4, 'Canindiyu', 10474, 234993, 1054);
INSERT INTO regiones (id_region, id_pais, nombre, extension, poblacion, u_pobreza) VALUES (regiones_seq.nextval, 5, 'Atacama', 8274, 23239, 1593);

INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 1', 'V', 1, 2, 1232, '4763202Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 2', 'M', 1, 1, 2232, '4763203Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 3', 'V', 1, 2, 4232, '4763204Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 4', 'V', 1, 3, 928, '4763205Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 5', 'M', 1, 5, 1928, '4763206Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 6', 'V', 3, 4, 5001, '4763207Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 7', 'V', 1, 3, 827, '4763208Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 8', 'M', 2, 1, 2232, '4763209Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 9', 'V', 1, 2, 1121, '4763210Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 10', 'V', 1, 5, 7265, '4763211Y');

INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 11', 'V', 2, 7, 4232, '4763212Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 12', 'M', 2, 6, 3232, '4763213Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 13', 'V', 2, 7, 5232, '4763214Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 14', 'V', 2, 8, 1928, '4763215Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 15', 'M', 2, 10, 7928, '4763216Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 16', 'V', 3, 9, 5001, '4763217Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 17', 'V', 2, 8, 1227, '4763218Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 18', 'M', 1, 6, 8232, '473219Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 19', 'V', 2, 7, 2221, '4763220Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 20', 'V', 2, 10, 12365, '4763221Y');

INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 21', 'V', 3, 12, 1232, '47363222Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 22', 'M', 3, 11, 1532, '47363223Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 23', 'V', 3, 12, 2332, '47363224Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 24', 'V', 3, 13, 3228, '47363225Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 25', 'M', 3, 15, 1128, '47363226Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 26', 'V', 4, 14, 3401, '47363227Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 27', 'V', 3, 13, 1327, '47363228Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 28', 'M', 2, 11, 1232, '47363229Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 29', 'V', 3, 12, 2321, '47363230Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 30', 'V', 3, 15, 2165, '47363231Y');

INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 31', 'V', 4, 17, 1132, '47363232Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 32', 'M', 4, 16, 1232, '47363233Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 33', 'V', 4, 17, 1332, '47363234Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 34', 'V', 4, 18, 2228, '47363235Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 35', 'M', 4, 20, 928, '47363236Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 36', 'V', 1, 19, 2101, '47363237Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 37', 'V', 3, 18, 1127, '47363238Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 38', 'M', 4, 16, 1132, '47363239Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 39', 'V', 4, 17, 2221, '47363240Y');
INSERT INTO censo (id_censo, nombre, sexo, id_pais_nacionalidad, id_region_censo, ingresos, cod_identifica) VALUES (censo_seq.nextval, 'Encuestado 40', 'V', 4, 20, 1965, '47363241Y');

INSERT INTO actividades (id_actividad, nombre, costo_anio_persona) VALUES (actividades_seq.nextval, 'Sanidad', 1076);
INSERT INTO actividades (id_actividad, nombre, costo_anio_persona) VALUES (actividades_seq.nextval, 'Escolarización', 834);
INSERT INTO actividades (id_actividad, nombre, costo_anio_persona) VALUES (actividades_seq.nextval, 'Control de la natalidad', 133);
INSERT INTO actividades (id_actividad, nombre, costo_anio_persona) VALUES (actividades_seq.nextval, 'Asistencia social', 283);
INSERT INTO actividades (id_actividad, nombre, costo_anio_persona) VALUES (actividades_seq.nextval, 'Equipamiento agricola', 183);

INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (1, 1, TO_DATE('14/02/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (3, 1, TO_DATE('13/05/2010','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (5, 1, TO_DATE('09/07/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (8, 1, TO_DATE('01/12/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (13, 1, TO_DATE('23/11/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (15, 1, TO_DATE('01/02/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (17, 1, TO_DATE('15/07/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (20, 1, TO_DATE('02/04/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (2, 2, TO_DATE('25/10/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (4, 2, TO_DATE('11/05/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (6, 2, TO_DATE('17/01/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (8, 2, TO_DATE('01/04/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (11, 2, TO_DATE('21/10/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (14, 2, TO_DATE('03/04/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (16, 2, TO_DATE('12/08/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (19, 2, TO_DATE('02/04/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (7, 3, TO_DATE('25/10/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (9, 3, TO_DATE('11/05/2012','dd/mm/yyyy'), 180);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (12, 3, TO_DATE('17/01/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (14, 3, TO_DATE('01/04/2011','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (16, 3, TO_DATE('21/10/2011','dd/mm/yyyy'), 180);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (17, 3, TO_DATE('03/04/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (18, 3, TO_DATE('02/04/2012','dd/mm/yyyy'), 365);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (1, 4, TO_DATE('11/06/2012','dd/mm/yyyy'), 90);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (9, 4, TO_DATE('17/02/2012','dd/mm/yyyy'), 180);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (11, 4, TO_DATE('01/05/2011','dd/mm/yyyy'), 90);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (14, 4, TO_DATE('21/11/2011','dd/mm/yyyy'), 180);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (18, 4, TO_DATE('03/05/2012','dd/mm/yyyy'), 90);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (20, 4, TO_DATE('02/01/2012','dd/mm/yyyy'), 180);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (2, 5, TO_DATE('10/05/2011','dd/mm/yyyy'), 30);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (10, 5, TO_DATE('11/09/2011','dd/mm/yyyy'), 30);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (12, 5, TO_DATE('23/08/2012','dd/mm/yyyy'), 30);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (15, 5, TO_DATE('13/12/2012','dd/mm/yyyy'), 30);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (17, 5, TO_DATE('04/09/2012','dd/mm/yyyy'), 30);
INSERT INTO regiones_actividades (id_region, id_actividad, fecha_inicio, dias_actividad) VALUES (29, 5, TO_DATE('19/02/2011','dd/mm/yyyy'), 30);

/* Crear una vista con las características de aquellas actividades que han sido adoptadas en regiones para las que 
o bien su país no tiene presupuesto social para llevarlas a cabo globalmente (según la población de esa región y el 
costo por persona de tal actividad), o bien la densidad de población en dichas regiones está entre 1000 y 5000 hab./Km2. */

CREATE VIEW actividades_regiones AS
SELECT a.id_actividad, a.nombre, a.costo_anio_persona
FROM regiones_actividades ra, actividades a
WHERE ra.id_region IN (SELECT DISTINCT r.id_region
                        FROM regiones r, regiones_actividades ra, actividades a, paises p
                        WHERE r.id_region = ra.id_region
                          AND ra.id_actividad = a.id_actividad
                          AND r.id_pais = p.id_pais
                        GROUP BY (r.id_region, r.poblacion, a.costo_anio_persona, p.presupuesto)
                        HAVING (r.poblacion*a.costo_anio_persona) > p.presupuesto
                        UNION
                        SELECT r.id_region
                        FROM regiones r
                        WHERE round(poblacion/extension) BETWEEN 1000 AND 5000);

/* Crear una vista con 4 atributos: Nombre del país, Capital, Concepto y Cantidad. El concepto se refiere al significado del 
atributo Cantidad. Se incluirá la información de cada concepto para cada país existente. Los conceptos son los siguientes seis: 
- Personas censadas en el país. 
- Extensión total de las regiones del país. 
- Regiones contabilizadas del país. 
- Menor umbral de pobreza del país. 
- Población del país. 
- Actividades adoptadas por tal país. */

CREATE VIEW concepts AS
SELECT * FROM (
SELECT p.nombre, p.capital, 'personas censadas' as concepto , count (c.id_censo) as cantidad
FROM países p, regiones r, censo c
WHERE c.id_region_censo = r.id_region 
  AND r.id_pais = p.id_pais
GROUP BY p.nombre, p.capital
UNION ALL
SELECT p.nombre, p.capital, 'extension pais' as concepto, SUM(r.extension) cantidad
FROM países p, regiones r
WHERE r.id_pais = p.id_pais
GROUP BY p.nombre, p.capital
UNION ALL
SELECT p.nombre, p.capital, 'regiones país' as concepto, count(r.id_pais) cantidad
FROM países p, regiones r
WHERE p.id_pais = r.id_pais
GROUP BY p.nombre, p.capital
UNION ALL
SELECT p.nombre, p.capital, 'menor umbral pobreza' as concepto, MIN(r.u_pobreza) cantidad
FROM países p, regiones r
WHERE p.id_pais = r.id_pais
GROUP BY p.nombre, p.capital
UNION ALL
SELECT p.nombre, p.capital, 'población país' as concepto, SUM(repoblación) cantidad
FROM países p, regiones r
WHERE p.id_pais = r.id_pais
GROUP BY p.nombre, p.capital
UNION ALL
SELECT p.nombre, p.capital, 'actividades pais' as concepto, COUNT(ra.id_region) cantidad
FROM países p, regiones r, regiones_actividades ra 
WHERE p.id_pais = r.id_pais 
  AND r.id_region = ra.id_region
GROUP BY p.nombre, p.capital) ORDER BY nombre, concepto ASC;

/* Visualizar el nombre de País y las Regiones */
SELECT p.nombre "NOMBRE_PAIS", r.nombre "NOMBRE_REGION" 
FROM países p, regiones r
WHERE p.id_pais = r.id_pais;

/* Extraer las actividades por cada Región y País. */
SELECT p.nombre "NOMBRE_PAIS", r.nombre "NOMBRE_REGION", a.nombre "NOMBRE_ACTIVIDAD"
FROM regiones_actividades ra, regiones r, actividades a, países p
WHERE ra.id_region = r.id_region
  AND ra.id_actividad = a.id_actividad
  AND r.id_pais = p.id_pais;

/* Mostar los Países en los cuales no se ha desarrollado ninguna actividad. */
SELECT p.id_pais, p.nombre 
FROM regiones r, países p
WHERE id_region = (SELECT id_region FROM regiones r
                    MINUS
                    SELECT ra.id_region
                    FROM regiones_actividades ra, regiones r
                    WHERE ra.id_region = r.id_region)
      AND r.id_pais = p.id_pais;


/* Visualizar la población por Países */
SELECT p.nombre "NOMBRE_PAIS", SUM(r.poblacion) "POBLACION_PAIS"
FROM países p, regiones r
WHERE p.id_pais = r.id_pais
GROUP BY p.nombre;
			
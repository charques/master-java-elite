/************************************************/
/* CU001_MOD01_NX001_TA01_Ejercicios_practicos  */
/************************************************/
/* Carlos Felipe Hernández Arques  - Julio 2012 */
/************************************************/

create table emp_bckup as select * from emp;
create table dept_bckup as select * from dept;

/***************************/
/****** EJERCICIO 06 *******/
/***************************/

/* Contar nº de empleados. */
SELECT COUNT(*) FROM emp;

/* Contar nº de JOBS distintos. */
SELECT COUNT(DISTINCT job) FROM emp;

/* Extraer los distintos JOB/DEPARTAMENTO */
SELECT DISTINCT job, dname 
FROM emp, dept;

/* Nombre de los empleados que acaben en ‘N’ */
SELECT ename FROM emp WHERE ename LIKE '%N';

/* Sacar nombre y meses que lleva en la empresa para todos que no son del dto 10 ó que la comisión es nula. */
SELECT ename, ROUND(MONTHS_BETWEEN(sysdate,hiredate)) "MESES CONTRATADO"
FROM emp
WHERE (deptno <> 10) OR (comm is NULL);

/* Saca empleado y número de años trabajados. */
SELECT empno, to_number(to_char(sysdate, 'YYYY')) - to_number(to_char(hiredate, 'YYYY')) "AÑOS CONTRATADO" 
FROM emp;

/* Saca empleados que no pertenecen al dpto 10 o 40 */
SELECT  * 
FROM emp
WHERE deptno not in (10, 40);

/* Sacar el empleado, el año que entró, su salario + comisión de todos cuya antigu?edad oscila entre 12 y 18 años y no pertenecen al dpto 10 o 40. */
SELECT ename, to_char(hiredate, 'YYYY') "AÑO ENTRADA", nvl(sal,0) + nvl(comm,0) "SALARIO TOTAL"
FROM emp
WHERE ((to_number(to_char(sysdate, 'YYYY')) - to_number(to_char(hiredate, 'YYYY'))) BETWEEN 12 AND 32)
      AND deptno not in (10, 40);

/***************************/
/****** EJERCICIO 07 *******/
/***************************/

/* Sacamos de la tabla anterior el num. de empleados por dpto. */
SELECT deptno "DEPARTAMENTO", COUNT(*) "NUM_EMPLEADOS" 
FROM emp
GROUP BY deptno;

/* Sacar salario máximo y mínimo por trabajo para aquellos empleados que no entraron un viernes en la empresa */
SELECT job, MAX(sal) "MAXIMO", MIN(sal) "MINIMO"
FROM emp
WHERE to_number(to_char(hiredate,'D')) <> 6
GROUP BY job;

/***************************/
/****** EJERCICIO 08 *******/
/***************************/

/* Sacar la suma de salario por dpto y job para los empleados que no son manager y cuyos salarios estén entre 2000 y 5000 euros y la suma de salarios sea inferior a 7000 euros. */
SELECT sum(sal), deptno, job
FROM emp
WHERE (job not like 'MANAGER') AND (sal BETWEEN 2000 AND 5000) 
GROUP BY deptno, job
HAVING sum(sal) < 7000;

/* El nombre de jobs que pertenecen a más de dos empleados. */
SELECT job, count(job)
FROM emp
GROUP BY job
HAVING count(job) > 2;

/***************************/
/****** EJERCICIO 09 *******/
/***************************/

/* Sacar el nombre de empleado, el salario, la comisión ordenado por nombre empleado de forma descendente.
Para los empleados que no tienen comisión, mostrar el texto ‘SIN COMISIÓN’' */
SELECT ename, sal, DECODE(nvl(comm,0), 0, 'SIN COMISION', comm) "COMISION"
FROM emp
ORDER BY ename DESC;

/***************************/
/****** EJERCICIO 10 *******/
/***************************/

/* ELIMINA TABLAS */
DROP TABLE e3_ejemplares_prestamos;
DROP TABLE e3_prestamos;
DROP TABLE e3_empleados;
DROP TABLE e3_ejemplares;
DROP TABLE e3_libros;
DROP TABLE e3_socios;
DROP TABLE e3_autores;
DROP TABLE e3_temas;

/* CREA TABLAS */
CREATE TABLE e3_temas
(
id_tema NUMBER(4),
descripcion VARCHAR2(60) NOT NULL,
CONSTRAINT pk_temas PRIMARY KEY (id_tema)
);

CREATE TABLE e3_autores
(
id_autor NUMBER(4),
nombre VARCHAR2(60) NOT NULL,
CONSTRAINT pk_autores PRIMARY KEY (id_autor)
);

CREATE TABLE e3_socios
(
id_socio NUMBER(4),
nombre VARCHAR2(60) NOT NULL,
apellidos VARCHAR2(60) NOT NULL,
fecha_nac DATE,
fecha_alta DATE NOT NULL,
sexo CHAR(1),
direccion VARCHAR2(150),
CONSTRAINT pk_socios PRIMARY KEY (id_socio)
);

CREATE TABLE e3_libros
(
isbn VARCHAR2(17),
id_autor NUMBER(4) NOT NULL,
id_tema NUMBER(4) NOT NULL,
titulo VARCHAR2(180) NOT NULL,
fecha_alta DATE NOT NULL,
editorial VARCHAR2(100),
CONSTRAINT pk_libros PRIMARY KEY (isbn),
CONSTRAINT fk_libros_autores  FOREIGN KEY (id_autor) REFERENCES e3_autores,
CONSTRAINT fk_libros_temas  FOREIGN KEY (id_tema) REFERENCES e3_temas
);

CREATE TABLE e3_ejemplares
(
 id_ejemplar NUMBER(4),
 isbn VARCHAR2(17) NOT NULL,
 fecha_alta DATE NOT NULL,
 CONSTRAINT pk_ejemplares PRIMARY KEY (id_ejemplar),
 CONSTRAINT fk_ejemplares_libros  FOREIGN KEY (isbn) REFERENCES e3_libros
);

CREATE TABLE e3_empleados
(
 id_empleado NUMBER(4),
 nombre VARCHAR2(60) NOT NULL,
 fecha_alta DATE NOT NULL,
 CONSTRAINT pk_empleados PRIMARY KEY (id_empleado)
);

CREATE TABLE e3_prestamos
(
 id_prestamo NUMBER(4),
 id_socio NUMBER(4) NOT NULL,
 id_empleado NUMBER(4) NOT NULL,
 fecha_prestamo DATE NOT NULL,
 dias_prestamo NUMBER(2) NOT NULL,
 CONSTRAINT pk_prestamos PRIMARY KEY (id_prestamo),
 CONSTRAINT fk_prestamos_socios  FOREIGN KEY (id_socio) REFERENCES e3_socios,
 CONSTRAINT fk_prestamos_empleados  FOREIGN KEY (id_empleado) REFERENCES e3_empleados
);

CREATE TABLE e3_ejemplares_prestamos
(
  id_prestamo NUMBER(4),
  id_ejemplar NUMBER(4),
  devuelto NUMBER(1),
  fecha_devolucion DATE,
  CONSTRAINT pk_ejemplares_prestamos PRIMARY KEY (id_prestamo, id_ejemplar),
  CONSTRAINT check_devuelto CHECK (devuelto IN (0,1))
);

/***************************/
/****** EJERCICIO 11 *******/
/***************************/
ALTER TABLE emp ADD PRIMARY KEY (empno);

/***************************/
/****** EJERCICIO 12 *******/
/***************************/
ALTER TABLE dept ADD (pais  varchar2(50) NOT NULL);

/***************************/
/****** EJERCICIO 13 *******/
/***************************/
ALTER TABLE emp DROP COLUMN mgr;

/***************************/
/****** EJERCICIO 14 *******/
/***************************/
ALTER TABLE dept ADD CONSTRAINT FK_DEPARTAMENTO
      FOREIGN KEY (deptno) REFERENCES emp (deptno);

/***************************/
/****** EJERCICIO 15 *******/
/***************************/      
ALTER TABLE dept RENAME COLUMN loc TO localidad;
      
/***************************/
/****** EJERCICIO 16 *******/
/***************************/      
DROP TABLE emp;

/***************************/
/****** EJERCICIO 17 *******/
/***************************/      
DROP TABLE dept;

/***************************/
/****** EJERCICIO 19 *******/
/***************************/    
CREATE TABLE emp AS SELECT * FROM emp_bckup;
CREATE TABLE dept AS SELECT * FROM dept_bckup;

/***************************/
/****** EJERCICIO 20 *******/
/***************************/ 
TRUNCATE TABLE emp;
TRUNCATE TABLE dept;

/***************************/
/****** EJERCICIO 21 *******/
/***************************/
INSERT INTO e3_temas (id_tema, descripcion) VALUES (1, 'Filosofía');
INSERT INTO e3_temas (id_tema, descripcion) VALUES (2, 'Física');
INSERT INTO e3_temas (id_tema, descripcion) VALUES (3, 'Química');
INSERT INTO e3_temas (id_tema, descripcion) VALUES (4, 'Programación');
INSERT INTO e3_temas (id_tema, descripcion) VALUES (5, 'Viajes');
INSERT INTO e3_temas (id_tema, descripcion) VALUES (6, 'Cine');
INSERT INTO e3_temas (id_tema, descripcion) VALUES (7, 'Humor');
INSERT INTO e3_temas (id_tema, descripcion) VALUES (8, 'Miedo');
SELECT * FROM e3_temas;

INSERT INTO e3_autores (id_autor, nombre) VALUES (1, 'BADIOU ALAIN');
INSERT INTO e3_autores (id_autor, nombre) VALUES (2, 'RUSSELL BERTRAND');
INSERT INTO e3_autores (id_autor, nombre) VALUES (3, 'HAWKING STEPHEN');
INSERT INTO e3_autores (id_autor, nombre) VALUES (4, 'KAKU MICHIO');
INSERT INTO e3_autores (id_autor, nombre) VALUES (5, 'F. GRASES FREIXEDAS');
INSERT INTO e3_autores (id_autor, nombre) VALUES (6, 'F. JAVIER MOLDES');
INSERT INTO e3_autores (id_autor, nombre) VALUES (7, 'JEFF FRIESEN');
INSERT INTO e3_autores (id_autor, nombre) VALUES (8, 'MARIANO KIWI CARRIZO');
INSERT INTO e3_autores (id_autor, nombre) VALUES (9, 'LARRY ULLMAN');
INSERT INTO e3_autores (id_autor, nombre) VALUES (10, 'JENS PORUP');
INSERT INTO e3_autores (id_autor, nombre) VALUES (11, 'AA.VV.');
INSERT INTO e3_autores (id_autor, nombre) VALUES (12, 'KURT LANCASTER');
INSERT INTO e3_autores (id_autor, nombre) VALUES (13, 'JOSEP PLA');
SELECT * FROM e3_autores;

INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9789501265828', 1, 1, 'ELOGIO DEL AMOR', sysdate, 'PAIDOS');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9789876281683', 2, 1, 'POR QUE NO SOY CRISTIANO', sysdate, 'EDHASA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9789879317242', 3, 2, 'EL GRAN DISEÑO', sysdate, 'CRITICA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9789871786268', 4, 2, 'LA FISICA DEL FUTURO', sysdate, 'DEBATE');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788498920932', 3, 2, 'LOS SUEÑOS DE LOS QUE ESTA HECHA LA MATERIA', sysdate, 'CRITICA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788429172096', 5, 3, 'CRISTALIZACIÓN EN DISOLUCIÓN - CONCEPTOS BÁSICOS', sysdate, 'REVERTE');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788441529878', 6, 4, 'JAVA 7 (Manual Imprescindible)', sysdate, 'ANAYA MULTIMEDIA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788441529618', 7, 4, 'JAVA PARA DESARROLLO ANDROID', sysdate, 'ANAYA MULTIMEDIA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788426717467', 8, 4, 'FLEX 4.5 - PLATAFORMA PARA PROFESIONALES', sysdate, 'MARCOMBO');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9789501265829', 9, 4, 'PHP (PASO A PASO)', sysdate, 'ANAYA MULTIMEDIA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788408082934', 10, 5, 'COLOMBIA 1 (GUIAS VIAJE - LONELY PLANET)', sysdate, 'GEOPLANETA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788860404053', 10, 5, 'REPUBLICA DOMINICANA Y HAITI (GUIAS VIAJE - LONELY PLANET)', sysdate, 'GEOPLANETA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788480164382', 11, 6, 'EL CINE', sysdate, 'LAROUSE');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788441530225', 12, 6, 'EL CINE DSLR', sysdate, 'ANAYA MULTIMEDIA');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788423335992', 13, 7, 'VIAJE EN AUTOBÚS', sysdate, 'BOOKET');
INSERT INTO e3_libros (isbn, id_autor, id_tema, titulo, fecha_alta, editorial) VALUES ('9788423329052', 13, 7, 'LA CALLE ESTRECHA', sysdate, 'AUSTRAL');
SELECT * FROM e3_libros;

INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (1, 'MANUEL', 'GARCÍA LOPEZ', to_date('12/04/1980', 'DD/MM/YYYY'), sysdate, 'H', 'C/ ROMA, 39, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (2, 'DOLORES', 'MARTÍNEZ PEREZ', to_date('19/09/1956', 'DD/MM/YYYY'), sysdate, 'M', 'C/ PARIS, 11, 4A, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (3, 'VICTORIA', 'PUERTO LOPEZ', to_date('01/04/1977', 'DD/MM/YYYY'), sysdate, 'M', 'C/ AFECTO, 6, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (4, 'JOSÉ', 'HERNÁNDEZ SALAR', to_date('12/04/1965', 'DD/MM/YYYY'), sysdate, 'H', 'C/ CONCORDIA, 2, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (5, 'GONZALO', 'GARCÍA MARTIN', to_date('12/04/1990', 'DD/MM/YYYY'), sysdate, 'H', 'C/ MAYOR, 1, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (6, 'MARTIN', 'FERNÁNDEZ ARQUES', to_date('12/04/1954', 'DD/MM/YYYY'), sysdate, 'H', 'C/ PALOMA, 92, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (7, 'MARCOS', 'GARCÍA ROSAURO', to_date('12/04/1984', 'DD/MM/YYYY'), sysdate, 'H', 'C/ ALCALA, 2, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (8, 'ANA', 'GARCÍA CORRAL', to_date('18/09/1934', 'DD/MM/YYYY'), sysdate, 'H', 'C/ ALCALA, 2, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (9, 'MARIA', 'RUIZ PEREZ', to_date('11/05/1974', 'DD/MM/YYYY'), sysdate, 'H', 'C/ RIVERA, 12, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (10, 'LAURA', 'GAMBIN RAMIREZ', to_date('04/04/1991', 'DD/MM/YYYY'), sysdate, 'H', 'C/ MARISTA, 9, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (11, 'VIOLETA', 'NIETO ALVAREZ', to_date('11/02/1975', 'DD/MM/YYYY'), sysdate, 'H', 'C/ AMAPOLA, 22, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (12, 'ROCIO', 'CASTAÑON MAS', to_date('11/02/1980', 'DD/MM/YYYY'), sysdate, 'M', 'C/ ROSAS, 22, MADRID');
INSERT INTO e3_socios (id_socio, nombre, apellidos, fecha_nac, fecha_alta, sexo, direccion) VALUES (13, 'CINTAS', 'GARCIA MOLINA', to_date('11/02/1958', 'DD/MM/YYYY'), sysdate, 'M', 'C/ CLAVELES, 22, MADRID');
SELECT * FROM e3_socios;

INSERT INTO e3_empleados (id_empleado, nombre, fecha_alta) VALUES (1, 'MANUEL GARCÍA LOPEZ', sysdate);
INSERT INTO e3_empleados (id_empleado, nombre, fecha_alta) VALUES (2, 'CARMEN RAMOS BARRERA', sysdate);
INSERT INTO e3_empleados (id_empleado, nombre, fecha_alta) VALUES (3, 'ALFREDO PESCADOR CABANILLAS', sysdate);
INSERT INTO e3_empleados (id_empleado, nombre, fecha_alta) VALUES (4, 'LIDIA FERNANDEZ PILO', sysdate);
INSERT INTO e3_empleados (id_empleado, nombre, fecha_alta) VALUES (5, 'NURIA GOMEZ ENCANTANDO', sysdate);
INSERT INTO e3_empleados (id_empleado, nombre, fecha_alta) VALUES (6, 'PEDRO RUIZ POLO', sysdate);
INSERT INTO e3_empleados (id_empleado, nombre, fecha_alta) VALUES (7, 'MARIA ESTEVEZ GONZALEZ', sysdate);
SELECT * FROM e3_empleados;

INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (1, '9789501265828', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (2, '9789501265828', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (3, '9789876281683', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (4, '9789876281683', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (5, '9789876281683', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (6, '9789879317242', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (7, '9789879317242', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (8, '9789871786268', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (9, '9788498920932', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (10, '9788498920932', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (11, '9788441529878', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (12, '9788441529878', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (13, '9788441529618', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (14, '9788426717467', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (15, '9788426717467', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (16, '9789501265829', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (17, '9788408082934', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (18, '9788408082934', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (19, '9788408082934', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (20, '9788860404053', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (21, '9788480164382', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (22, '9788441530225', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (23, '9788423335992', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (24, '9788423335992', sysdate);
INSERT INTO e3_ejemplares (id_ejemplar, isbn, fecha_alta) VALUES (25, '9788423329052', sysdate);
SELECT * FROM e3_ejemplares;

INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (1, 1, 1,  to_date('11/05/1990', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (1, 1, 1,  to_date('18/05/1990', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (2, 2, 2,  to_date('15/09/1995', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (2, 12, 1,  to_date('22/09/1995', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (3, 2, 3,  to_date('01/06/2005', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (3, 5, 1,  to_date('08/06/2005', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (4, 3, 3,  to_date('11/11/2008', 'DD/MM/YYYY'), 10);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (4, 4, 1,  to_date('22/11/2008', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (5, 4, 4,  to_date('21/12/2010', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (5, 3, 1,  to_date('28/12/2010', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (6, 4, 4,  to_date('11/01/2011', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (6, 12, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (7, 4, 4,  to_date('02/10/2011', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (7, 20, 1,  to_date('05/10/2011', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (8, 5, 5,  to_date('11/12/2011', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (8, 21, 1,  to_date('18/12/2011', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (9, 6, 5,  to_date('11/01/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (9, 17, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (10, 6, 6,  to_date('12/01/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (10, 15, 1,  to_date('14/01/2012', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (11, 7, 5,  to_date('01/02/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (11, 18, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (12, 8, 4,  to_date('05/03/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (12, 25, 1,  to_date('21/03/2012', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (12, 9, 4,  to_date('06/03/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (12, 21, 1,  to_date('08/03/2012', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (13, 10, 3,  to_date('14/04/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (13, 23, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (14, 10, 3,  to_date('21/06/2012', 'DD/MM/YYYY'), 20);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (14, 22, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (15, 11, 2,  to_date('25/06/2012', 'DD/MM/YYYY'), 10);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (15, 3, 1,  to_date('02/07/2012', 'DD/MM/YYYY'));
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (16, 11, 1,  to_date('01/07/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (16, 6, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (17, 11, 1,  to_date('01/07/2012', 'DD/MM/YYYY'), 7);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (17, 9, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (18, 12, 1,  to_date('02/07/2012', 'DD/MM/YYYY'), 10);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (18, 5, 0,  null);
INSERT INTO e3_prestamos (id_prestamo, id_socio, id_empleado, fecha_prestamo, dias_prestamo) VALUES (19, 13, 1,  to_date('03/07/2012', 'DD/MM/YYYY'), 10);
INSERT INTO e3_ejemplares_prestamos (id_prestamo, id_ejemplar, devuelto, fecha_devolucion) VALUES (19, 12, 1,  to_date('04/07/2012', 'DD/MM/YYYY'));

SELECT * FROM e3_prestamos;
SELECT * FROM e3_ejemplares_prestamos;

/***************************/
/****** EJERCICIO 22 *******/
/***************************/ 
INSERT INTO emp (SELECT * FROM emp_bckup);
INSERT INTO dept (SELECT * FROM dept_bckup);

/***************************/
/****** EJERCICIO 23 *******/
/***************************/      
UPDATE emp SET sal=sal*1.1;

/***************************/
/****** EJERCICIO 24 *******/
/***************************/      
UPDATE emp SET sal=sal+(nvl(comm,0)*0.1)
WHERE upper(ename) NOT LIKE '___L%';

/***************************/
/****** EJERCICIO 25 *******/
/***************************/      
UPDATE emp 
SET sal = (SELECT avg(sal) FROM emp WHERE deptno IN (SELECT DISTINCT deptno FROM emp WHERE job='ANALYST'))
WHERE job = 'ANALYST';

/***************************/
/****** EJERCICIO 26 *******/
/***************************/
TRUNCATE TABLE emp;
INSERT INTO emp (SELECT * FROM emp_bckup);
CREATE TABLE emp2 AS SELECT * FROM emp_bckup;
DELETE FROM emp WHERE upper(job) NOT LIKE 'ANALYST';
UPDATE emp SET sal=9000;

SELECT * FROM emp;
SELECT * FROM emp2;

MERGE INTO emp USING emp2
ON (emp.empno = emp2.empno)
WHEN MATCHED THEN
UPDATE SET emp.sal = emp2.sal
WHEN NOT MATCHED THEN
INSERT (empno, ename, sal)
VALUES (emp2.empno, emp2.ename, emp2.sal);

SELECT * FROM emp;

/***************************/
/****** EJERCICIO 27 *******/
/***************************/
SELECT t.id_tema, t.descripcion "TEMA", l.titulo "LIBRO"
FROM e3_temas t, e3_libros l
WHERE t.id_tema = l.id_tema;
     
/***************************/
/****** EJERCICIO 28 *******/
/***************************/
SELECT s.nombre "SOCIO", l.titulo, p.fecha_prestamo
FROM e3_socios s, e3_prestamos p , e3_ejemplares_prestamos ep, e3_ejemplares e, e3_libros l
WHERE s.id_socio = p.id_socio
  AND p.id_prestamo = ep.id_prestamo
  AND ep.id_ejemplar = e.id_ejemplar
  AND e.isbn = l.isbn
  AND sysdate - p.fecha_prestamo < 365*2
  AND sysdate - s.fecha_alta < 365*3;

/***************************/
/****** EJERCICIO 29 *******/
/***************************/
SELECT e.nombre "NOMBRE EMPLEADO", COUNT(DISTINCT ep.id_ejemplar) "EJEMPLARES"
FROM e3_prestamos p, e3_socios s, e3_empleados e, e3_ejemplares_prestamos ep
WHERE ((p.id_socio = s.id_socio) 
  AND (p.id_empleado = e.id_empleado)
  AND (p.id_prestamo = ep.id_prestamo)
  AND (upper(s.nombre) LIKE '%S') 
  AND (length(s.nombre) > 5)
  AND (s.sexo = 'M'))
GROUP BY e.nombre;

/***************************/
/****** EJERCICIO 30 *******/
/***************************/
SELECT t.descripcion "TEMA", l.titulo "LIBRO"
FROM e3_libros l RIGHT JOIN e3_temas t
ON t.id_tema = l.id_tema;

SELECT t.descripcion, l.titulo
FROM e3_temas t, e3_libros l
WHERE t.id_tema = l.id_tema (+);

/***************************/
/****** EJERCICIO 31 *******/
/***************************/
SELECT s.nombre, s.apellidos, l.titulo, e.id_ejemplar
FROM e3_socios s, e3_prestamos p, e3_ejemplares_prestamos ep, e3_ejemplares e, e3_libros l
WHERE s.id_socio = p.id_socio (+)
  AND p.id_prestamo = ep.id_prestamo (+)
  AND ep.id_ejemplar = e.id_ejemplar (+)
  AND e.isbn = l.isbn (+);
     
/***************************/
/****** EJERCICIO 32 *******/
/***************************/
SELECT s.id_socio, s.nombre, s.apellidos, e.nombre "NOMBRE_EMPLEADO"
FROM e3_socios s, e3_empleados e, e3_prestamos p
WHERE e.id_empleado  = p.id_empleado (+)
  AND  s.id_socio (+) = p.id_socio;

/***************************/
/****** EJERCICIO 33 *******/
/***************************/
SELECT s.nombre, s.apellidos, count(*)
FROM e3_socios s, e3_prestamos p, e3_ejemplares_prestamos ep
WHERE s.id_socio = p.id_socio
  AND p.id_prestamo = ep.id_prestamo
  AND ep.devuelto = 0
GROUP BY s.nombre, s.apellidos;

/***************************/
/****** EJERCICIO 34 *******/
/***************************/
SELECT s.nombre "SOCIO", e.nombre "EMPLEADO", e.id_empleado
FROM e3_socios s 
FULL JOIN (e3_prestamos p FULL JOIN e3_empleados e ON p.id_empleado = e.id_empleado)
ON s.id_socio = p.id_socio;

/***************************/
/****** EJERCICIO 35 *******/
/***************************/
SELECT empno, ename
FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);

/***************************/
/****** EJERCICIO 36 *******/
/***************************/
SELECT avg(emp.sal) "SALARIO" , emp.deptno 
FROM emp 
WHERE emp.sal > 1000 
  AND (SELECT AVG(emp.sal) FROM emp)>(SELECT avg(emp.sal) FROM emp, dept WHERE dept.loc ='CHICAGO' and dept.deptno = emp.deptno)
GROUP BY deptno;

/***************************/
/****** EJERCICIO 37 *******/
/***************************/
SELECT p.id_socio, s.nombre
FROM e3_socios s, e3_prestamos p, e3_ejemplares_prestamos ep, e3_empleados e
WHERE s.id_socio = p.id_socio
  AND p.id_prestamo = ep.id_prestamo
  AND p.id_empleado = e.id_empleado
  AND ep.devuelto = 0
  AND upper(e.nombre) NOT LIKE 'J%'
GROUP BY p.id_socio, s.nombre
HAVING COUNT(*) > 1;

/***************************/
/****** EJERCICIO 38 *******/
/***************************/
SELECT job, DECODE(GROUPING(deptno),1, 'TOTAL JOB', 0, deptno) deptno, SUM(sal) 
FROM emp
GROUP BY ROLLUP(job, deptno);

/***************************/
/****** EJERCICIO 39 *******/
/***************************/
SELECT s.id_socio
FROM e3_socios s
WHERE s.id_socio NOT IN(SELECT DISTINCT p.id_socio
FROM e3_prestamos p, e3_ejemplares_prestamos ep
WHERE p.id_prestamo = ep.id_prestamo
AND ep.devuelto = 0);

SELECT s.id_socio FROM e3_socios s
MINUS
SELECT DISTINCT(p.id_socio) FROM e3_prestamos p, e3_ejemplares_prestamos ep
WHERE p.id_prestamo = ep.id_prestamo
AND ep.devuelto = 0;

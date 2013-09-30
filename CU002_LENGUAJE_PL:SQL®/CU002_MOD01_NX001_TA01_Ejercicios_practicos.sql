/************************************************/
/* CU002_MOD01_NX001_TA01_Ejercicios_practicos  */
/************************************************/
/* Carlos Felipe Hernández Arques  - Agosto 2012 */
/************************************************/

/***************************/
/****** EJERCICIO 01 *******/
/***************************/

CREATE TABLE vendedores (
Empno NUMBER (4),
Sal NUMBER (7,2),
Comm NUMBER (7,2));

DECLARE
  empleado emp%ROWTYPE;
  CURSOR empleados_comision IS
    SELECT * 
    FROM emp 
    WHERE comm IS NOT NULL;

BEGIN
  FOR empleado IN empleados_comision LOOP
    DBMS_OUTPUT.PUT_LINE('empleado ' || empleado.empno);
    INSERT INTO vendedores VALUES (empleado.empno, empleado.sal, empleado.comm);
  END LOOP;
END;
/

-- PRUEBA
SELECT * FROM vendedores;

/***************************/
/****** EJERCICIO 02 *******/
/***************************/

CREATE TABLE temp (
Código NUMBER (7),
Mensaje VARCHAR2 (80));

CREATE SEQUENCE temp_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

DECLARE
  i NUMBER;
  mensaje VARCHAR2(80);
BEGIN
  UPDATE vendedores SET comm= comm + sal*0.15 WHERE comm > 350;
  i := sql%rowcount;
  
  IF(i > 3) THEN
    ROLLBACK;
    mensaje := 'ROLLBACK';
  ELSE 
    COMMIT;
    mensaje := 'COMMIT';
  END IF;
  
  -- Inserta el valor en temp
  DBMS_OUTPUT.PUT_LINE('mensaje ' || mensaje);
  INSERT INTO temp VALUES (temp_seq.nextval, mensaje);
  COMMIT;
END;
/

-- PRUEBA
SELECT * FROM temp;

/***************************/
/****** EJERCICIO 03 *******/
/***************************/

DECLARE
  i NUMBER;
BEGIN
  UPDATE emp SET job = 'DIRECTOR' WHERE sal > 2000;
  i := sql%rowcount;
  
  INSERT INTO temp VALUES (temp_seq.nextval, to_char(i) || ' filas actualizadas');
  DBMS_OUTPUT.PUT_LINE(to_char(i) || ' filas actualizadas');
  
  IF(i > 5) THEN
    DELETE FROM emp WHERE sal > 3000;
    i := sql%rowcount;
    INSERT INTO temp VALUES (temp_seq.nextval, to_char(i) || ' filas eliminadas');
    DBMS_OUTPUT.PUT_LINE(to_char(i) || ' filas eliminadas');
  END IF;

  COMMIT;
END;
/

-- PRUEBA
SELECT *
FROM emp
WHERE sal > 2000;

SELECT *
FROM temp;

/***************************/
/****** EJERCICIO 04 *******/
/***************************/

DECLARE
  i NUMBER;
  mensaje VARCHAR2(80);
BEGIN
  FOR i in 0..100 LOOP
    IF MOD(i,2) = 0 THEN
      mensaje := 'PAR';
    ELSE
      mensaje := 'IMPAR';
    END IF;
    INSERT INTO temp VALUES (i, mensaje);
    DBMS_OUTPUT.PUT_LINE(to_char(i) || ' : ' || mensaje);
  END LOOP;

  COMMIT;
END;
/

-- PRUEBA
SELECT * FROM temp;

/***************************/
/****** EJERCICIO 05 *******/
/***************************/

CREATE TABLE mas_pagados (
Nombre VARCHAR2 (10),
Salario NUMBER (7,2));

DECLARE
  contador NUMBER(1) := 0;
  empleado emp%ROWTYPE;
  CURSOR empleados_salario IS
    SELECT *
    FROM emp
    ORDER BY sal DESC;

BEGIN
  OPEN empleados_salario;
  LOOP 
    FETCH empleados_salario INTO empleado;
    DBMS_OUTPUT.PUT_LINE('empleado: ' || empleado.ename || ', sal: ' || empleado.sal);
    contador := contador + 1;
    INSERT INTO mas_pagados VALUES (empleado.ename, empleado.sal);
    EXIT WHEN contador = 5;
    EXIT WHEN empleados_salario%NOTFOUND;
    
  END LOOP;
  CLOSE empleados_salario;
  COMMIT;
END;
/

-- PRUEBA
SELECT * FROM mas_pagados;

/***************************/
/****** EJERCICIO 06 *******/
/***************************/

DECLARE
  ganancias NUMBER(6);
  mas_2000 NUMBER(4);
  comm_mayor_sal NUMBER(4);
BEGIN

  SELECT sum(nvl(sal,0) + nvl(comm,0)) INTO ganancias
  FROM emp
  WHERE deptno = 20
  GROUP BY deptno;
  DBMS_OUTPUT.PUT_LINE('ganancias: ' || ganancias);
  
  SELECT count(*) INTO mas_2000
  FROM emp
  WHERE deptno = 20
    AND nvl(sal,0) + nvl(comm,0) > 2000
  GROUP BY deptno;
  DBMS_OUTPUT.PUT_LINE('mas_2000: ' || mas_2000);
  
  SELECT count(*) INTO comm_mayor_sal
  FROM emp
  WHERE deptno = 20
    AND nvl(comm,0) > nvl(sal,0)
  GROUP BY deptno;
  DBMS_OUTPUT.PUT_LINE('comm_mayor_sal: ' || comm_mayor_sal);
  
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
END;
/

/***************************/
/****** EJERCICIO 07 *******/
/***************************/

CREATE TABLE temp2 (
Codigo NUMBER (5),
Importe NUMBER (7,2),
Mensaje VARCHAR2 (50));

DECLARE
  empleado emp%ROWTYPE;
  mensaje VARCHAR2 (50);
  CURSOR empleados IS
    SELECT empno, nvl(sal,0) + nvl(comm,0) GANANCIAS
    FROM emp;

BEGIN

  FOR empleado IN empleados LOOP
    mensaje := 'Ganancias inferiores a 2000€';
    IF empleado.ganancias > 2000 THEN
      mensaje := 'Ganancias superiores a 2000€';
    END IF;
    DBMS_OUTPUT.PUT_LINE('empleado: ' || empleado.empno || ', ganancias: ' || empleado.ganancias || ' - ' || mensaje);
    INSERT INTO temp2 VALUES (empleado.empno, empleado.ganancias, mensaje);
  END LOOP;
  
  COMMIT;
END;
/

-- PRUEBA
SELECT * FROM temp2;

/***************************/
/****** EJERCICIO 08 *******/
/***************************/

SET echo ON;
SET verify OFF;
SET DEFINE '&';

prompt 'Introduce un número de empleado: ';
/
accept empno default '7698';
/
DECLARE
  salario1 NUMBER(7,2);
  salario2 NUMBER(7,2);
BEGIN

  SELECT sal INTO salario1
  FROM emp
  WHERE empno = '&empno';
  
  UPDATE emp SET sal= sal * 1.10 WHERE empno = '&empno';
  
  SELECT sal INTO salario2
  FROM emp
  WHERE empno = '&empno';
  
  DBMS_OUTPUT.PUT_LINE('SE HA INCREMENTADO EL SALARIO UN 10%. ANTES : ' || salario1 || ' AHORA : '|| salario2);
  COMMIT;
  
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
    WHEN TOO_MANY_ROWS THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);

END;
/

/***************************/
/****** EJERCICIO 09 *******/
/***************************/

SET echo ON;
SET verify OFF;
SET DEFINE '&';

accept deptno prompt 'Introduce el número de departamento: ';
accept nombre prompt 'Introduce el nombre del departamento: ';
accept localidad prompt 'Introduce la localidad del departamento: ';
/
DECLARE
  ecode    NUMBER(38);
  emesg VARCHAR2(250);
BEGIN
  INSERT INTO dept VALUES ('&deptno', '&nombre', '&localidad');
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('SE HA INSERTADO EL DEPARTAMENTO : ' || '&deptno' || ' - ' || '&nombre' || ' - ' || '&localidad');
  
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: EL CODIGO ' || '&deptno' || ' YA EXISTE.');
      INSERT INTO temp VALUES (temp_seq.nextval, 'ERROR: EL CODIGO ' || '&deptno' || ' YA EXISTE.');
      COMMIT;
    WHEN OTHERS THEN  
      ecode := SQLCODE;
      emesg := SQLERRM;
        
      IF ecode = -1438 THEN /* ORA-01438: value larger than specified precision allows. */ 
        DBMS_OUTPUT.PUT_LINE('ERROR: SE HA EXCEDIDO LA LONGITUD DE UNA COLUMNA.');
        INSERT INTO temp VALUES (temp_seq.nextval, 'ERROR: SE HA EXCEDIDO LA LONGITUD DE UNA COLUMNA.');
        COMMIT;
      ELSE
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || ecode || ' MENSAJE: '|| emesg);
        INSERT INTO temp VALUES (temp_seq.nextval, 'ERROR: ' || ecode || ' MENSAJE: '|| emesg);
        COMMIT; 
      END IF;
END;
/

/***************************/
/****** EJERCICIO 10 *******/
/***************************/

SET echo ON;
SET verify OFF;
SET DEFINE '&';

accept empno prompt 'Introduce el número de empleado: ';
/
DECLARE
  salario NUMBER(7,2);
  SALARIO_INFERIOR EXCEPTION;
  ecode    NUMBER(38);
  emesg VARCHAR2(250);
BEGIN
  SELECT sal INTO salario
  FROM emp
  WHERE empno = '&empno';
  
  IF salario >= 1000 THEN
    UPDATE emp SET sal= sal - 500 WHERE empno = '&empno';
    INSERT INTO temp VALUES (temp_seq.nextval, 'SE HA REDUCIDO EL SALARIO DE ' || '&empno' || ' EN 500€.');
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('SE HA REDUCIDO EL SALARIO DE ' || '&empno' || ' EN 500€.');
  ELSE
    RAISE SALARIO_INFERIOR;
  END IF;
  
  EXCEPTION
    WHEN SALARIO_INFERIOR THEN
      DBMS_OUTPUT.PUT_LINE('&empno' || ' FONDOS INSUFICIENTES.');
      INSERT INTO temp VALUES (temp_seq.nextval, '&empno' || ' FONDOS INSUFICIENTES.');
      COMMIT;
    WHEN OTHERS THEN  
      ecode := SQLCODE;
      emesg := SQLERRM;
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || ecode || ' MENSAJE: '|| emesg);
      INSERT INTO temp VALUES (temp_seq.nextval, 'ERROR: ' || ecode || ' MENSAJE: '|| emesg);
      COMMIT; 
END;
/

/***************************/
/****** EJERCICIO 11 *******/
/***************************/

SET echo ON;
SET verify OFF;
SET DEFINE '&';

accept job prompt 'Introduce un job: ';
/
DECLARE
  puesto VARCHAR2(9);
  mediasalario NUMBER(7,2);
  departamentodallas VARCHAR2(13);
  i NUMBER;
BEGIN
  SELECT DISTINCT job INTO puesto
  FROM emp
  WHERE job = '&job';
  
  SELECT AVG(sal) INTO mediasalario
  FROM emp
  WHERE job = puesto
  GROUP BY job;

  SELECT DISTINCT deptno INTO departamentodallas
  FROM dept
  WHERE loc = 'DALLAS';
  
  UPDATE emp SET sal = mediasalario WHERE deptno = departamentodallas;
  i := sql%rowcount;
  DBMS_OUTPUT.PUT_LINE('SE HAN ACTUALIZADO ' || i || ' FILAS.');
  COMMIT;
  
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE(' EL JOB ' || '&job' || ' NO EXITE.');
    WHEN OTHERS THEN  
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
END;
/


/***************************/
/****** EJERCICIO 12 *******/
/***************************/

SET echo ON;
SET verify OFF;
SET DEFINE '&';

accept t1 prompt 'Introduce un código de tema a sustituir: ';
accept t2 prompt 'Introduce el nuevo código de tema: ';
/
DECLARE
  temasustituir e3_temas%ROWTYPE;
  temanuevo NUMBER(4);
BEGIN
  temanuevo := '&t2';

  SELECT * INTO temasustituir
  FROM e3_temas
  WHERE id_tema = '&t1';
  
  INSERT INTO e3_temas VALUES (temanuevo, temasustituir.descripcion);
  UPDATE e3_libros SET id_tema = temanuevo WHERE id_tema = temasustituir.id_tema;
  DELETE FROM e3_temas WHERE id_tema = temasustituir.id_tema;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('LA SUSTITUCION SE HA REALIZADO CON EXITO.');
  
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE(' EL TEMA ' || '&t1' || ' NO EXITE.');
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE(' EL TEMA ' || '&t2' || ' YA EXISTE.');
    WHEN OTHERS THEN  
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
END;
/

-- PRUEBA
SELECT * FROM e3_temas;
SELECT * FROM e3_libros;

/***************************/
/****** EJERCICIO 13 *******/
/***************************/

DECLARE
  empleado emp%ROWTYPE;
  incremento NUMBER;
  
  CURSOR empleados IS
    SELECT e.empno, e.sal, e.job, e.hiredate, d.loc
    FROM emp e, dept d
    WHERE e.deptno = d.deptno
    AND (d.loc = 'BOSTON' OR d.loc = 'NEW YORK');

BEGIN

  FOR empleado IN empleados LOOP
    incremento := 0;
    -- CALCULA EL INCREMENTO
    IF empleado.loc = 'BOSTON' THEN
      CASE
        WHEN TRUNC(MONTHS_BETWEEN (sysdate, empleado.hiredate) / 12) < 10 THEN
          incremento := 1.10;
        WHEN TRUNC(MONTHS_BETWEEN (sysdate, empleado.hiredate) / 12) <= 20 THEN
          incremento := 1.15;
        WHEN TRUNC(MONTHS_BETWEEN (sysdate, empleado.hiredate) / 12) > 20 THEN
          incremento := 1.20;
      END CASE;
    ELSIF empleado.loc = 'NEW YORK' THEN
      CASE
        WHEN empleado.job='MANAGER' THEN 
          incremento := 1.00;
        WHEN empleado.job='ANALYST' THEN  
          incremento := 1.12;
        ELSE 
          incremento := 1.17;
      END CASE;
    END IF;
    
    -- ACTUALIZA EL SALARIO 
    IF incremento > 1 THEN
      UPDATE emp SET sal = sal * incremento WHERE empno = empleado.empno;
      COMMIT;
      DBMS_OUTPUT.PUT_LINE('SE HA INCREMENTADO EL SALARIO DEL EMPLEADO ' || empleado.empno || ' UN ' || to_char(incremento - 1) || '%' );
    END IF;
  END LOOP;

END;
/

-- PRUEBA
SELECT * FROM emp;

/***************************/
/****** EJERCICIO 14 *******/
/***************************/

DECLARE
  
  CURSOR socios_prestamos IS
    SELECT s.id_socio, s.nombre, s.apellidos, s.sexo, p.id_prestamo
    FROM e3_prestamos p RIGHT JOIN e3_socios s 
    ON s.id_socio = p.id_socio
      AND s.fecha_alta < (current_timestamp - INTERVAL '36' MONTH)
      AND p.fecha_prestamo >= (current_timestamp - INTERVAL '24' MONTH)
    ORDER BY s.id_socio;
    
  prestamo socios_prestamos%ROWTYPE;
  id_socio NUMBER(4,0);
  num_prestamos NUMBER(3);
  texto VARCHAR2(200);
BEGIN

  -- procesa los prestamos
  id_socio := 1;
  num_prestamos := 1;
  FOR prestamo IN socios_prestamos LOOP
    
    -- es un prestamo
    IF prestamo.id_prestamo > 0 THEN
      -- detecta el cambio de socio
      IF prestamo.id_socio = id_socio THEN
        num_prestamos := num_prestamos + 1;
      ELSE
        -- construye el texto en funcion del sexo y número de prestamos
        texto := prestamo.nombre || ' ' || prestamo.apellidos;
        texto := texto || ' --- ' || num_prestamos;
        IF prestamo.sexo = 'H' THEN
          IF num_prestamos > 0 THEN
            texto := texto || ' --- ' || 'Las edades del Hombre';
          END IF;
          IF num_prestamos > 2 THEN
            texto := texto || ' --- ' || 'Como ser un buen DBA Oracle';
          END IF;
        ELSE
          IF num_prestamos > 0 THEN
            texto := texto || ' --- ' || 'D. Quijote de la Mancha';
          END IF;
          IF num_prestamos > 2 THEN
            texto := texto || ' --- ' || 'La vida es sueño';
          END IF;
        END IF;
        
        DBMS_OUTPUT.PUT_LINE(texto);
        id_socio := prestamo.id_socio;
        num_prestamos := 1;
      END IF;
    ELSE
      -- el socio no tiene prestamos o no cumple con las condiciones de fechas
      texto := prestamo.nombre || ' ' || prestamo.apellidos;
      texto := texto || ' --- ' || 'Sin regalo';
      DBMS_OUTPUT.PUT_LINE(texto);
    END IF;
    
  END LOOP;

END;
/

/***************************/
/****** EJERCICIO 15 *******/
/***************************/

DECLARE
  TYPE Registro_Prestamo IS RECORD
  (
    isbn e3_libros.isbn%TYPE,
    nombre VARCHAR2(200),
    titulo e3_libros.titulo%TYPE,
    fecha_prestamo e3_prestamos.fecha_prestamo%TYPE,
    dias_prestamo e3_prestamos.dias_prestamo%TYPE,
    fecha_devolucion e3_ejemplares_prestamos.fecha_devolucion%TYPE,
    puntuacion INTEGER
  );

  TYPE Tipo_Tabla_Calculo_Puntos IS TABLE OF Registro_Prestamo;
  tablaCalculoPuntos Tipo_Tabla_Calculo_Puntos;

  auxDate DATE;
  auxDev DATE;
  
  diffDias NUMBER;
  diasPrestado NUMBER;
BEGIN

  SELECT l.isbn, s.nombre || ' ' || s.apellidos nombre, l.titulo, p.fecha_prestamo, p.dias_prestamo, ep.fecha_devolucion, 0 BULK COLLECT INTO tablaCalculoPuntos
  FROM e3_prestamos p, e3_ejemplares_prestamos ep, e3_socios s, e3_ejemplares e, e3_libros l
  WHERE p.id_prestamo = ep.id_prestamo
    AND p.id_socio = s.id_socio
    AND ep.id_ejemplar = e.id_ejemplar
    AND e.isbn = l.isbn;
    
  FOR i IN 1..tablaCalculoPuntos.COUNT LOOP
    -- El libro se ha devuelto
    IF tablaCalculoPuntos(i).fecha_devolucion IS NOT NULL THEN
      auxDate := tablaCalculoPuntos(i).fecha_prestamo + tablaCalculoPuntos(i).dias_prestamo;
      diffDias := tablaCalculoPuntos(i).fecha_devolucion - auxDate;
      IF(diffDias <= 0) THEN
        tablaCalculoPuntos(i).puntuacion := 1;
      ELSIF (diffDias <= 3) THEN
        tablaCalculoPuntos(i).puntuacion := -1;
      ELSIF (diffDias > 4) THEN
        tablaCalculoPuntos(i).puntuacion := -2;
      END IF;
    ELSE
      -- El libro no se ha devuelto
      diasPrestado := floor(SYSDATE - tablaCalculoPuntos(i).fecha_prestamo);
      IF(diasPrestado > tablaCalculoPuntos(i).dias_prestamo) THEN
        tablaCalculoPuntos(i).puntuacion := -10;
      END IF;
    END IF;
    DBMS_OUTPUT.PUT_LINE(tablaCalculoPuntos(i).nombre || ' . ' || tablaCalculoPuntos(i).titulo || ' . ' || tablaCalculoPuntos(i).puntuacion);
  END LOOP;
  
END;
/

/***************************/
/****** EJERCICIO 16 *******/
/***************************/

CREATE TABLE tabla_log (
Id_usuario VARCHAR2(30),
Fecha DATE);

CREATE OR REPLACE PROCEDURE QUIEN_EJECUTA IS
BEGIN
  INSERT INTO tabla_log VALUES (user, sysdate);
  COMMIT;
END QUIEN_EJECUTA;
/

-- PRUEBA
exec QUIEN_EJECUTA;
SELECT * FROM tabla_log;

/***************************/
/****** EJERCICIO 17 *******/
/***************************/

CREATE OR REPLACE PROCEDURE ACTUALIZA_SALARIO (id_empleado NUMBER, porcentaje NUMBER) IS
temp_porcentaje NUMBER;
BEGIN
  temp_porcentaje := 1 + (porcentaje / 100);   
  UPDATE emp SET sal = sal * temp_porcentaje WHERE empno = id_empleado;
  COMMIT;
  QUIEN_EJECUTA;
END ACTUALIZA_SALARIO;
/

-- PRUEBA
exec ACTUALIZA_SALARIO(7698,10);
SELECT * FROM emp;

/***************************/
/****** EJERCICIO 18 *******/
/***************************/

CREATE OR REPLACE FUNCTION FN_SALARIO_DEPARTAMENTO (id_departamento NUMBER)
RETURN NUMBER
IS
suma_salario NUMBER;
BEGIN
  SELECT SUM(sal) INTO suma_salario
  FROM emp
  WHERE deptno = id_departamento
  GROUP BY deptno;
  
  RETURN suma_salario;
  
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      RETURN -1;
    WHEN OTHERS THEN  
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      RETURN -1;
      
END FN_SALARIO_DEPARTAMENTO;
/

-- PRUEBA
DECLARE
  salario NUMBER;
BEGIN
	salario := FN_SALARIO_DEPARTAMENTO(10);
  DBMS_OUTPUT.PUT_LINE('EL SALARIO DEL DEPT. 10 ES: ' || salario);
END; 
/

SELECT FN_SALARIO_DEPARTAMENTO(20) 
FROM dual;

/***************************/
/****** EJERCICIO 19 *******/
/***************************/

CREATE OR REPLACE PROCEDURE MOSTRAR_SALARIOS IS
  departamento NUMBER;
  suma_salario NUMBER;
  CURSOR departamentos IS
    SELECT deptno
    FROM dept;

BEGIN

  FOR departamento IN departamentos LOOP
    SELECT SUM(sal) INTO suma_salario
    FROM emp
    WHERE deptno = departamento.deptno
    GROUP BY deptno;
    
    DBMS_OUTPUT.PUT_LINE('Departamento: ' || departamento.deptno || ' Suma: ' || suma_salario);
    
  END LOOP;
  
END MOSTRAR_SALARIOS;
/

-- PRUEBA
exec MOSTRAR_SALARIOS;

/***************************/
/****** EJERCICIO 20 *******/
/***************************/

CREATE TABLE salario_departamentos (
deptno NUMBER (2),
sal_tot NUMBER (7,2));

CREATE OR REPLACE PROCEDURE ALTA_SAL_DEPT(id_departamento NUMBER)
IS
salario NUMBER;
BEGIN
  salario := FN_SALARIO_DEPARTAMENTO(id_departamento);
  
  IF salario > 0 THEN
    INSERT INTO salario_departamentos VALUES (id_departamento, salario);
    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('El departamento ' || id_departamento || ' no existe.');
  END IF;
  
END ALTA_SAL_DEPT;
/

-- PRUEBA
exec ALTA_SAL_DEPT(10);
exec ALTA_SAL_DEPT(20);
exec ALTA_SAL_DEPT(30);
exec ALTA_SAL_DEPT(40);
SELECT * FROM salario_departamentos;
exec ALTA_SAL_DEPT(55);

/***************************/
/****** EJERCICIO 21 *******/
/***************************/

CREATE OR REPLACE FUNCTION FN_SALARIO_MEDIO_DEPARTAMENTO (id_departamento NUMBER, trabajo VARCHAR2)
RETURN NUMBER
IS
salario_medio NUMBER;
BEGIN
  SELECT AVG(sal) INTO salario_medio
  FROM emp
  WHERE deptno = id_departamento
    AND job = trabajo
  GROUP BY deptno;
  RETURN salario_medio;
  
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN 0;
    WHEN OTHERS THEN  
      RETURN 0;
  
END FN_SALARIO_MEDIO_DEPARTAMENTO;
/

-- PRUEBA
SELECT FN_SALARIO_MEDIO_DEPARTAMENTO(10, 'DIRECTOR') 
FROM dual;

SELECT FN_SALARIO_MEDIO_DEPARTAMENTO(60, 'DIRECTOR') 
FROM dual;

/***************************/
/****** EJERCICIO 22 *******/
/***************************/

CREATE OR REPLACE TYPE mayor_menor_type AS OBJECT 
(
mayor NUMBER 
, menor NUMBER
)
/

CREATE OR REPLACE FUNCTION FN_MAYOR_MENOR (number1 IN NUMBER, number2 IN NUMBER, number3 IN NUMBER)
RETURN mayor_menor_type AS 
output mayor_menor_type;
BEGIN
  output := mayor_menor_type(NULL, NULL);
  
  IF number1 > number2 THEN
    output.mayor := number1;
    output.menor := number2;
  ELSE
    output.mayor := number2;
    output.menor := number1;
  END IF;
  
  IF output.mayor < number3 THEN
    output.mayor := number3;
  END IF;
  
  IF output.menor > number3 THEN
    output.menor := number3;
  END IF;
  
  return (output);
END FN_MAYOR_MENOR;
/

-- PRUEBA
DECLARE
  output mayor_menor_type;
BEGIN
  output := FN_MAYOR_MENOR(10, 32, 25);
  DBMS_OUTPUT.PUT_LINE('MAYOR: ' || output.mayor || ' MENOR: ' || output.menor);

  output := FN_MAYOR_MENOR(55, 22, 15);
  DBMS_OUTPUT.PUT_LINE('MAYOR: ' || output.mayor || ' MENOR: ' || output.menor);
END; 
/

/***************************/
/****** EJERCICIO 23 *******/
/***************************/

CREATE OR REPLACE PACKAGE GESTION_DE_DEPART AS
   PROCEDURE ALTA_DEPT(numero NUMBER, nombre VARCHAR2, localidad VARCHAR2);
   PROCEDURE BAJA_DEPT(departamento NUMBER);
   FUNCTION MOD_DEPT(departamento NUMBER, localidad VARCHAR2) RETURN BOOLEAN;
END GESTION_DE_DEPART;
/

CREATE OR REPLACE PACKAGE BODY GESTION_DE_DEPART IS
 
 PROCEDURE ALTA_DEPT(numero NUMBER, nombre VARCHAR2, localidad VARCHAR2) 
 IS
  numero_temp NUMBER;
  ERROR_NUMERO_DEPT EXCEPTION;
 BEGIN
  BEGIN
    numero_temp := numero;
    -- COMPRUEBA SI ES MODULO DE 10
    IF (numero_temp = 0) OR (MOD(numero_temp, 10) <> 0) THEN
      RAISE ERROR_NUMERO_DEPT;
    END IF;
  EXCEPTION
    WHEN ERROR_NUMERO_DEPT THEN
      -- AL NO CUMPLIR LA CONDICION, SE CALCULA UN NUMERO DE DEPARTAMENTO
      SELECT MAX(deptno) + 10 INTO numero_temp
      FROM dept;
  END;
    
  INSERT INTO dept VALUES (numero_temp, nombre, localidad);
  COMMIT;
  
 EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
    ROLLBACK;
    RAISE;
 END ALTA_DEPT;
 
 PROCEDURE BAJA_DEPT(departamento NUMBER) 
 IS
 BEGIN
  DELETE FROM dept WHERE deptno = departamento;
  COMMIT;
  
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      ROLLBACK;
      RAISE;
 END BAJA_DEPT;
 
 FUNCTION MOD_DEPT(departamento NUMBER, localidad VARCHAR2) 
 RETURN BOOLEAN
 IS
 BEGIN
  UPDATE dept SET loc = localidad WHERE deptno = departamento;
  COMMIT;
  RETURN TRUE;
  
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      ROLLBACK;
      RETURN FALSE;
 END MOD_DEPT;
 
END GESTION_DE_DEPART; 
/

-- PRUEBA
exec GESTION_DE_DEPART.ALTA_DEPT(85, 'PRUEBA_1', 'MADRID');
exec GESTION_DE_DEPART.ALTA_DEPT(85, 'PRUEBA_2', 'BARCELONA');
SELECT * FROM dept;
exec GESTION_DE_DEPART.BAJA_DEPT(60);
SELECT * FROM dept;

DECLARE
  output BOOLEAN;
BEGIN
  output := GESTION_DE_DEPART.MOD_DEPT(50, 'CIUDAD REAL');
  IF output = TRUE THEN
    DBMS_OUTPUT.PUT_LINE('DEPARTAMENTO MODIFICADO CON EXITO');
  ELSE
    DBMS_OUTPUT.PUT_LINE('OCURRIO UN FALLO EN LA MODIFICACION DEL DEPARTAMENTO');
  END IF;
END; 
/

/***************************/
/****** EJERCICIO 24 *******/
/***************************/

CREATE OR REPLACE PACKAGE GESTION_DE_EMPLEADOS AS
   PROCEDURE ALTA_EMP(nombre VARCHAR2, trabajo VARCHAR2, jefe NUMBER);
   PROCEDURE BAJA_EMP(empleado NUMBER);
   PROCEDURE MOD_EMP(empleado NUMBER, departamento NUMBER);
END GESTION_DE_EMPLEADOS;
/

CREATE OR REPLACE PACKAGE BODY GESTION_DE_EMPLEADOS IS

  PROCEDURE ALTA_EMP(nombre VARCHAR2, trabajo VARCHAR2, jefe NUMBER)
  IS
    empno NUMBER(4);
    sal NUMBER(7,2);
    comm NUMBER(7,2);
    emp_jefe emp%ROWTYPE;
  BEGIN
    -- obtiene el número de empleado
    SELECT MAX(empno) + 1 INTO empno
    FROM emp;
  
    -- obtiene el jefe
    SELECT * INTO emp_jefe
    FROM emp
    WHERE empno = jefe;
  
    -- obtiene el salario
    sal := FN_SALARIO_MEDIO_DEPARTAMENTO(emp_jefe.deptno, trabajo);
  
    -- obtiene la comisión
    comm := NULL;
    IF trabajo = 'SALESMAN' THEN
      comm := 0;
    END IF;
    
    -- inserta el empleado
    INSERT INTO emp VALUES (empno, nombre, trabajo, emp_jefe.empno, sysdate, sal, comm, emp_jefe.deptno);
    DBMS_OUTPUT.PUT_LINE(empno || ' - ' || nombre || ' - ' || trabajo || ' - ' || emp_jefe.empno || ' - ' || sysdate || ' - ' || sal || ' - ' || comm || ' - ' || emp_jefe.deptno);
    COMMIT;
    
    EXCEPTION
      WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
        ROLLBACK;
        RAISE;
        
  END ALTA_EMP;

  PROCEDURE BAJA_EMP(empleado NUMBER)
  IS
    num_subordinados NUMBER;
    empleado_eliminar emp%ROWTYPE;
    nuevo_jefe emp%ROWTYPE;
  BEGIN
  
  -- obtiene empleado a eliminar
  SELECT * INTO empleado_eliminar
  FROM emp
  WHERE empno = empleado;
  
  -- obtiene el numero de subordinados
  SELECT count(*) INTO num_subordinados 
  FROM emp
  WHERE mgr = empleado;
  
  -- es jefe
  IF num_subordinados > 0 THEN
    -- obtiene subordinado con mayor salario
    SELECT * INTO nuevo_jefe
    FROM emp 
    WHERE sal=(SELECT MAX(sal) FROM emp WHERE mgr = empleado);

    -- actualiza el jefe del nuevo jefe
    UPDATE emp SET mgr = empleado_eliminar.mgr WHERE empno = nuevo_jefe.empno;
    
    -- actualiza el jefe de los subordinados
    UPDATE emp SET mgr = nuevo_jefe.empno WHERE mgr = empleado;
  END IF;
  
  -- elimina el empleado
  DELETE FROM emp WHERE empno = empleado;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('EL EMPLEADO ' || empleado || ' SE HA ELIMINADO CON EXITO.');
  
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      ROLLBACK;
      RAISE;
  END BAJA_EMP;

  PROCEDURE MOD_EMP(empleado NUMBER, departamento NUMBER)
  IS
    numero_temp NUMBER(2);
  BEGIN
    numero_temp := departamento;
  
    -- comprueba si el departamento existe
    BEGIN
      SELECT deptno INTO numero_temp
      FROM dept
      WHERE deptno = numero_temp;
      
      EXCEPTION
        -- si el departamento no existe, lo crea y obtiene el número
        WHEN NO_DATA_FOUND THEN
          GESTION_DE_DEPART.ALTA_DEPT(0, 'DEPT_AUTO', 'LOC_AUTO');
          SELECT MAX(deptno) INTO numero_temp
          FROM dept;
    END;
  
    DBMS_OUTPUT.PUT_LINE('ACTUALIZANDO EMPLEADO: ' || empleado || ' - DEPARTAMENTO: '|| numero_temp);
    UPDATE emp SET deptno = numero_temp WHERE empno = empleado;
    COMMIT;
  
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      ROLLBACK;
      RAISE;
  END MOD_EMP;

END GESTION_DE_EMPLEADOS;
/

-- PRUEBA
exec GESTION_DE_EMPLEADOS.ALTA_EMP('PRUEBA1', 'CLERK', 7782);
exec GESTION_DE_EMPLEADOS.ALTA_EMP('PRUEBA2', 'SALESMAN', 7698);

exec GESTION_DE_EMPLEADOS.BAJA_EMP(7499);

exec GESTION_DE_EMPLEADOS.MOD_EMP(7938, 90);
SELECT * FROM dept;
SELECT * FROM emp WHERE empno = 7938;

/***************************/
/****** EJERCICIO 25 *******/
/***************************/

CREATE TABLE historicos_dept 
(
DEPTNO NUMBER(2) NOT NULL,
DNAME VARCHAR2(14),
LOC VARCHAR2(13)
);

CREATE OR REPLACE TRIGGER dept_before_delete
BEFORE DELETE
    ON dept
    FOR EACH ROW

DECLARE

BEGIN
    INSERT INTO historicos_dept
    VALUES
     ( :old.deptno,
       :old.dname,
       :old.loc);
END;
/

-- PRUEBA
exec GESTION_DE_DEPART.ALTA_DEPT(50, 'PRUEBA', 'MADRID');
exec GESTION_DE_DEPART.BAJA_DEPT(50);
SELECT * FROM historicos_dept;

/***************************/
/****** EJERCICIO 26 *******/
/***************************/

CREATE OR REPLACE TRIGGER dept_before_insert_update
BEFORE INSERT OR UPDATE
    ON dept
    FOR EACH ROW

DECLARE
    ERROR_NUMERO_DEPT EXCEPTION;
BEGIN
    -- SE COMPRUEBA SI ES MODULO DE 10
    IF (:new.deptno = 0) OR (MOD(:new.deptno, 10) <> 0) THEN
      RAISE ERROR_NUMERO_DEPT;
    END IF;
    
    EXCEPTION
      WHEN ERROR_NUMERO_DEPT THEN
        :new.deptno := round(:new.deptno/10)*10;
END;
/

-- PRUEBA
INSERT INTO dept VALUES (51, 'PRUEBA_TRIGGER', 'MADRID_1');
SELECT * FROM dept;
INSERT INTO dept VALUES (56, 'PRUEBA_TRIGGER', 'MADRID_2');
SELECT * FROM dept;
UPDATE dept SET deptno = 71 WHERE loc = 'MADRID_1';
SELECT * FROM dept;
DELETE FROM dept WHERE loc like 'MADRID%';

/***************************/
/****** EJERCICIO 27 *******/
/***************************/

CREATE OR REPLACE TRIGGER emp_after_insert
AFTER INSERT OR UPDATE OR DELETE
    ON emp
    FOR EACH ROW

DECLARE
    salario_total NUMBER;
    num_dept NUMBER;
BEGIN
  
  num_dept := :new.deptno;
  
  SELECT sal_tot INTO salario_total
  FROM salario_departamentos
  WHERE deptno = num_dept;
  
  IF inserting THEN
    salario_total := salario_total + :new.sal;
  END IF;
  
  IF updating THEN
    salario_total := salario_total - :old.sal + :new.sal;
  END IF;
  
  IF deleting THEN
    salario_total := salario_total - :old.sal;
  END IF;

  UPDATE salario_departamentos SET sal_tot = salario_total WHERE deptno = num_dept;

  EXCEPTION
    WHEN OTHERS THEN  
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      
END;
/

-- PRUEBA
exec GESTION_DE_EMPLEADOS.ALTA_EMP('PRUEBA5', 'CLERK', 7782);
exec GESTION_DE_EMPLEADOS.BAJA_EMP(7941);
SELECT * FROM salario_departamentos;

/***************************/
/****** EJERCICIO 28 *******/
/***************************/

CREATE TABLE SALGRADE
        (GRADE NUMBER,
         LOSAL NUMBER,
         HISAL NUMBER);

INSERT INTO SALGRADE VALUES (1,  700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);
COMMIT;

CREATE OR REPLACE TRIGGER emp_after_insert_grade
BEFORE INSERT OR UPDATE
    ON emp
    FOR EACH ROW

DECLARE
    grade salgrade%ROWTYPE;
BEGIN

  SELECT * INTO grade 
  FROM salgrade
  WHERE grade = :new.deptno/10;
  
  IF :new.sal < grade.losal THEN
    DBMS_OUTPUT.PUT_LINE('El salario ' || :new.sal || ' está por debajo del mínimo ('|| grade.losal || '). ' || ' Se ajusta salario al mínimo.');
    :new.sal := grade.losal;
  ELSIF :new.sal > grade.hisal THEN
    DBMS_OUTPUT.PUT_LINE('El salario ' || :new.sal || ' está por encima del máximo ('|| grade.hisal || '). ' || ' Se ajusta salario al máximo.');
    :new.sal := grade.hisal;
  END IF;

  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      INSERT INTO salgrade VALUES (:new.deptno/10, 1000, 5000);
    WHEN OTHERS THEN  
      DBMS_OUTPUT.PUT_LINE('ERROR: ' || SQLCODE || ' MENSAJE: '|| SQLERRM);
      
END;
/

-- PRUEBA
INSERT INTO emp VALUES (8000, 'GRADE1', 'SALESMAN', 7844, SYSDATE, 1, 0, 30);
SELECT * FROM emp WHERE empno = 8000;
UPDATE emp SET sal = 25000 WHERE empno = 7844;
SELECT * FROM emp WHERE empno = 7844;

/***************************/
/****** EJERCICIO 29 *******/
/***************************/

DECLARE
  TYPE CursorTipoEmp IS REF CURSOR RETURN emp%ROWTYPE;    -- restrictivo
  cv_emp_rest CursorTipoEmp;
  
  TYPE CursorGenerico IS REF CURSOR;                      -- no restrictivo
  cv_emp_norest CursorGenerico;
  
  empleado emp%ROWTYPE;
BEGIN

  IF NOT cv_emp_rest%ISOPEN THEN
    OPEN cv_emp_rest FOR SELECT * FROM emp;
    DBMS_OUTPUT.PUT_LINE('Empleados cursor variable restrictivo'); 
    LOOP
      FETCH cv_emp_rest INTO empleado;
      EXIT WHEN cv_emp_rest%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('empleado: ' || empleado.empno || ', nombre: ' || empleado.ename);
    END LOOP;
    CLOSE cv_emp_rest;
  END IF;
  
  DBMS_OUTPUT.PUT_LINE(''); 
  
  IF NOT cv_emp_norest%ISOPEN THEN
    OPEN cv_emp_norest FOR SELECT * FROM emp;
    DBMS_OUTPUT.PUT_LINE('Empleados cursor variable NO restrictivo'); 
    LOOP
      FETCH cv_emp_norest INTO empleado;
      EXIT WHEN cv_emp_norest%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE('empleado: ' || empleado.empno || ', nombre: ' || empleado.ename);
    END LOOP;
    CLOSE cv_emp_norest;
  END IF;
  
END;
/

/***************************/
/****** EJERCICIO 30 *******/
/***************************/

DECLARE
  TYPE CursorSocios IS REF CURSOR;    
  cv_socios CursorSocios;

  TYPE CursorPrestamos IS REF CURSOR;    
  cv_prestamos CursorPrestamos;
  
  type rec_socio is record
  (
    id_socio  INTEGER(4),
    nombre VARCHAR(200),
    libros_prestados  INTEGER(4)
  );
  socio rec_socio;
  
  type rec_prestamo is record
  (
    nombre VARCHAR(200),
    titulo VARCHAR(200),
    dias_sobre INTEGER(4)
  );
  prestamo rec_prestamo;
BEGIN

  IF NOT cv_socios%ISOPEN THEN
    OPEN cv_socios FOR 
      SELECT p.id_socio, s.nombre || ' ' || s.apellidos nombre, count(p.id_socio) libros_prestados
      FROM e3_prestamos p, e3_ejemplares_prestamos ep, e3_socios s
      WHERE p.id_prestamo = ep.id_prestamo
        AND p.id_socio = s.id_socio
        AND ep.devuelto = 0
      GROUP BY p.id_socio, s.nombre, s.apellidos;
      
    LOOP
      FETCH cv_socios INTO socio;
      EXIT WHEN cv_socios%NOTFOUND;
      --DBMS_OUTPUT.PUT_LINE('id_socio: ' || socio.id_socio || ', nombre: ' || socio.nombre || ', libros_prestados: ' || socio.libros_prestados);
      
      IF socio.libros_prestados = 1 THEN
        DBMS_OUTPUT.PUT_LINE(socio.nombre || ' - Por favor, debe vd devolver el libro pues ha sobrepasado el préstamo en una semana');
      ELSIF socio.libros_prestados > 1 THEN
        -- procesa socios con más de un prestamo
        OPEN cv_prestamos FOR 
          SELECT s.nombre || ' ' || s.apellidos nombre, l.titulo, floor(sysdate - p.fecha_prestamo) - p.dias_prestamo dias_sobre
          FROM e3_prestamos p, e3_ejemplares_prestamos ep, e3_socios s, e3_ejemplares e, e3_libros l
          WHERE p.id_prestamo = ep.id_prestamo
            AND p.id_socio = s.id_socio
            AND ep.id_ejemplar = e.id_ejemplar
            AND l.isbn = e.isbn
            AND ep.devuelto = 0
            AND p.id_socio = socio.id_socio;
        
        LOOP
          FETCH cv_prestamos INTO prestamo;
          EXIT WHEN cv_prestamos%NOTFOUND;
          DBMS_OUTPUT.PUT_LINE(prestamo.nombre || ' - ' || prestamo.titulo || ' - ' || prestamo.dias_sobre);
        
        END LOOP;
      END IF;
      
    END LOOP;
    CLOSE cv_socios;
  END IF;
  
END;
/

/***************************/
/****** EJERCICIO 31 *******/
/***************************/

CREATE OR REPLACE PROCEDURE ELIMINA_TABLA(nombre_tabla VARCHAR2)
IS
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE ' || nombre_tabla;
END ELIMINA_TABLA;
/

-- PRUEBA
CREATE TABLE tabla_prueba (campo NUMBER);
exec ELIMINA_TABLA('tabla_prueba');

/***************************/
/****** EJERCICIO 32 *******/
/***************************/

CREATE TABLE emp_copy AS SELECT * FROM emp;
TRUNCATE TABLE emp_copy;
SELECT * FROM emp_copy;
DESC emp;

CREATE OR REPLACE PROCEDURE COPY_TABLA_EMP
IS
  v_empno dbms_sql.number_table;
  v_ename dbms_sql.varchar2_table;
  v_job dbms_sql.varchar2_table;
  v_mgr dbms_sql.number_table;
  v_hiredate dbms_sql.date_table;
  v_sal dbms_sql.number_table;
  v_comm dbms_sql.number_table;
  v_deptno dbms_sql.number_table;

  insert_query VARCHAR2(300);
  c NUMBER;
  dummy NUMBER;
  interval_lo NUMBER;
  interval_hi NUMBER;
  num_emp NUMBER;
BEGIN

  SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
  BULK COLLECT INTO v_empno, v_ename, v_job, v_mgr, v_hiredate, v_sal, v_comm, v_deptno
  FROM emp;
  
  SELECT count(*) INTO num_emp
  FROM emp;

  /*FOR i IN v_empno.FIRST .. v_empno.LAST LOOP
     dbms_output.put_line(v_empno(i) || ', ' || v_ename(i));
  END LOOP;*/
  
  -- bucle para la insercion de 5 en 5 elementos
  interval_lo := 0;
  interval_hi := 0;
  LOOP
    IF interval_hi + 5 <= num_emp THEN
      interval_lo := interval_hi + 1;
      interval_hi := interval_hi + 5;
    ELSE 
      interval_lo := interval_hi + 1;
      interval_hi := num_emp;
    END IF;
  
    insert_query := 'INSERT INTO emp_copy VALUES (:empno_array, :ename_array, 
      :job_array, :mgr_array, :hiredate_array, :sal_array, :comm_array, 
      :deptno_array)';
    c := DBMS_SQL.OPEN_CURSOR;
    DBMS_SQL.PARSE(c, insert_query, DBMS_SQL.NATIVE);
    DBMS_SQL.BIND_ARRAY(c, ':empno_array', v_empno, interval_lo, interval_hi);
    DBMS_SQL.BIND_ARRAY(c, ':ename_array', v_ename, interval_lo, interval_hi);
    DBMS_SQL.BIND_ARRAY(c, ':job_array', v_job, interval_lo, interval_hi);
    DBMS_SQL.BIND_ARRAY(c, ':mgr_array', v_mgr, interval_lo, interval_hi);
    DBMS_SQL.BIND_ARRAY(c, ':hiredate_array', v_hiredate, interval_lo, interval_hi);
    DBMS_SQL.BIND_ARRAY(c, ':sal_array', v_sal, interval_lo, interval_hi);
    DBMS_SQL.BIND_ARRAY(c, ':comm_array', v_comm, interval_lo, interval_hi);
    DBMS_SQL.BIND_ARRAY(c, ':deptno_array', v_deptno, interval_lo, interval_hi);
    dummy := DBMS_SQL.EXECUTE(c);
    DBMS_SQL.CLOSE_CURSOR(c);
    DBMS_OUTPUT.PUT_LINE('lo: ' || interval_lo || ' hi: ' || interval_hi || ' num_emp: ' || num_emp);
    DBMS_OUTPUT.PUT_LINE('items insertados ' || dummy); 
    EXIT WHEN interval_hi = num_emp;
  END LOOP; 
  
  EXCEPTION WHEN OTHERS THEN
    IF DBMS_SQL.IS_OPEN(c) THEN
      DBMS_SQL.CLOSE_CURSOR(c);
    END IF;
    RAISE;
   
END COPY_TABLA_EMP;
/

-- PRUEBA
exec COPY_TABLA_EMP();
SELECT * FROM emp_copy;
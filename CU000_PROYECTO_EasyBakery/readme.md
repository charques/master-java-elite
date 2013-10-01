CU000_PROYECTO - EasyBakery
===========================

Introducción
------------

Como proyecto de fin de master se ha desarrollado una aplicación web para la gestión de la producción de una panadería artesanal. 

El sistema se centra en el concepto de lote. Un lote representa a una remesa de producto, elaborada en un día en concreto y basada en una receta. De este modo el panadero en un día normal de trabajo daría de alta una serie de lotes de producto basados en la producción diaria. Estos lotes, como no puede ser de otra manera, generan una cantidad de producto producido y un coste.

Módulos
-------

El sistema está formado por los siguientes módulos:

**Módulo de login y seguridad**

El módulo de logín gestiona el acceso y la seguridad de la aplicación basado en usuarios y roles. La tecnología base para el desarrollo de este módulo es Spring Security. El modelo de datos de seguridad está definido en el fichero /easybakery/src/main/resources/security_schema.sql

Hay 2 usuarios preconfigurados en el sistema. El usuario admin tiene rol de administración y tiene permiso para la eliminación de materias primas, recetas y lotes. El usuario user no tiene rol de administración.

**Módulo de materias primas**

El módulo de materias primas permite mantener un conjunto de materias primas que se utilizarán para configurar recetas. 

Lo forman 2 pantallas: 

-	la pantalla de listado, que permite acceder a la edición u eliminar  elementos.
-	la pantalla de creación/edición, que permite gestionar una materia prima en función de los siguientes campos: 
	* Descripción: descripción básica de la materia prima.
	* Precio: precio unitario de la materia prima en función de la unidad de medida.
	* Unidad: unidad de medida.

**Módulo de recetas**

El módulo de recetas permite mantener un conjunto de recetas que se utilizarán para crear lotes de producto.

Lo forman 2 pantallas: 

-	la pantalla de listado, que permite acceder a la edición u eliminar  elementos.
-	la pantalla de creación/edición, que permite gestionar una receta en función de los siguientes campos:
	*	Descripción: descripción básica de la receta.
	*	Comentario: comentario extendido.
	*	Ingredientes: lista de ingredientes de la receta basados en materias primas. Para cada ingrediente se puede seleccionar la materia prima y el porcentaje de esta que es necesario para producir la receta.


**Módulo de lotes**

El módulo de lotes permite mantener un conjunto de lotes basados en las recetas anteriores.
 
Lo forman 3 pantallas: 

-	la pantalla de listado, que permite acceder a la edición u eliminar  elementos.
-	la pantalla de creación, que permite crear un lote en función de los siguientes campos:
	*	Receta: tipo de receta en la que se basa el lote. El resto de bloques de la pantalla se cargan vía AJAX al seleccionar la receta.
	*	Cantidad: cantidad de producto. Las cantidades de cada ingrediente se calculan en función de la cantidad total.
	*	Descripción: descripción del lote.

**Módulo de estadísticas**

El panel de estadísticas permite visualizar datos de producción (kg) y coste (€) de lotes. Estos datos se muestran agrupados por meses y pueden ser filtrados por tipo de receta y año.


Entorno de ejecución
--------------------

La aplicación ha sido configurada para ejecutarse en un servidor de aplicaciones Tomcat 7.0 o similar.

La url de acceso en una instalación en local es:

**http://localhost:8080/easybakery/**

Tecnologías
-----------

-	**Spring MVC:** Framework base. Inyección de dependencias y configuración de la aplicación.
-	**Spring Security:** Seguridad y login
-	**Spring Data + JPA + QueryDSL + HSQLDB:** Capa de persistencia
-	**JSP + JQuery + Ajax + JSON + Tiles:** Capa de presentación
-	**Log4j + Spring AOP:** Logging
-	**Maven:** Configuración de proyecto

Modelo de datos
---------------

El script **squema.sql** define el modelo de datos de negocio  de la aplicación. 
El script **security_squema.xml** define el modelo de datos de seguridad de la aplicación.

Con el fin de simplificar la configuración de la aplicación y teniendo en cuenta el motivo didáctico de esta se ha utilizado una base datos HSQLDB embebida.



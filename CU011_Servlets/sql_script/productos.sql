
DROP TABLE productos;

CREATE TABLE productos
(
id_prod NUMBER(8),
nombre VARCHAR2(60) NOT NULL,
descripcion VARCHAR2(1500) NOT NULL,
precio NUMBER(8,2)
);



INSERT INTO productos (id_prod, nombre, descripcion, precio) VALUES (1, 'Cámara Canon Ixus 230HS Plata', 'Elegante y delgada, es la nueva cámara digital Canon Ixus 230HS en color plata. Gracias al objetivo zoom 8x y la capacidad para trabajar con poca luz del HS System.', 159.5);
INSERT INTO productos (id_prod, nombre, descripcion, precio) VALUES (2, 'La cámara Olympus con el zoom más potente: la supersoom SP810 UZ. Presenta un objetivo zoom gran angular 1:2.9-5.7 24-864mm que es muy rápido y un sensor de imagen de 14 Megapíxeles que hacen de la SP-810UZ un objeto de deseo en su categoría.', 185.99);
INSERT INTO productos (id_prod, nombre, descripcion, precio) VALUES (3, 'La vida es demasiado corta como para tener una cámara fea o que tenga menús complicados o que no haga buenas fotos. Para no tener esos problemas hazte con la nueva Olympus PEN Mini.', 234.8);
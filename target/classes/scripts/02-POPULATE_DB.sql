INSERT INTO CATEGORIA_PRODUCTO (ID_CATEGORIA, NOMBRE)
VALUES 
	(1, 'Informatica'),
	(2, 'Cosméticos'),
	(3, 'Moda'),
	(4, 'Música');
	
INSERT INTO PRODUCTO (FECHA_MODIFICACION, FECHA_CREADA, ACTIVO, IMAGEN_URL, UDS_ALMACEN,
                          PRECIO_UNIDAD, DESCRIPCION, ID_CATEGORIA, NOMBRE, ID_PRODUCTO)
VALUES 
	('18/10/2023', '18/10/2023', 1, NULL, 20, 249.99, 
	'Un ordenador simple y común para las tareas del cotidiano',
	 1, 'Ordenador', 1),
	('18/10/2023', '18/10/2023', 1,  NULL, 15,  29.99,
	'Una guitarra española excelente para practicar tu música',
	4, 'Guitarra', 2);

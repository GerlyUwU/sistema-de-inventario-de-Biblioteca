-- Crear la tabla de libros
CREATE TABLE Libros (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT NOT NULL,
    autor TEXT NOT NULL,
    genero TEXT,
    anio_publicacion INTEGER,
    copias_disponibles INTEGER
);

-- Crear la tabla de usuarios
CREATE TABLE Usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    direccion TEXT,
    telefono TEXT,
    numero_identificacion TEXT
);

-- Crear la tabla de préstamos
CREATE TABLE Prestamos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_usuario INTEGER,
    id_libro INTEGER,
    fecha_prestamo TEXT,
    fecha_devolucion TEXT,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id),
    FOREIGN KEY (id_libro) REFERENCES Libros(id)
);

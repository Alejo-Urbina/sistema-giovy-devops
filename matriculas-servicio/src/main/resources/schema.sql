CREATE TABLE matriculas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT NOT NULL,     -- ID de usuario tipo estudiante
    asignatura_id BIGINT NOT NULL,     -- ID de la asignatura
    fecha_matricula DATE DEFAULT CURRENT_DATE,
    estado VARCHAR(20) NOT NULL        -- Ej: 'ACTIVA', 'CANCELADA'
);
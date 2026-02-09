--- DROP
DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE ROLE CASCADE CONSTRAINTS;
DROP TABLE PUBLICACION CASCADE CONSTRAINTS;
DROP TABLE MENSAJE CASCADE CONSTRAINTS;
-- DROP TABLE MENSAJE CASCADE CONSTRAINTS;

-- OBJETOS

CREATE TABLE USERS(
                      id_user NUMBER(8) GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
                      username VARCHAR2(32) NOT NULL UNIQUE,
                      email VARCHAR2(64) NOT NULL UNIQUE,
                      pwd VARCHAR2(32) NOT NULL,
                      register_date DATE DEFAULT SYSDATE NOT NULL,
                      id_role NUMBER(3) NOT NULL,
                      banned Number(1) DEFAULT 0 NOT NULL,
                      CONSTRAINT PK_USER PRIMARY KEY (id_user),
                      CONSTRAINT chk_is_banned CHECK (banned IN (0,1))
);

CREATE TABLE ROLE(
                     id_role NUMBER(3) GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
                     nombre_role VARCHAR(20) NOT NULL,
                     permisos VARCHAR(6) NOT NULL,
                     CONSTRAINT PK_ROLE PRIMARY KEY (id_role)
);

CREATE TABLE publicacion(
    id_publicacion NUMBER(5) GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
    id_user NUMBER(8) NOT NULL,
    content_pub VARCHAR2(255),
    fecha_pub DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT PK_PUBLICACION PRIMARY KEY (id_publicacion)
);

CREATE TABLE mensaje(
    id_mensaje NUMBER(10) GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
    id_user_sender NUMBER(8) NOT NULL,
    id_user_receiver NUMBER(8) NOT NULL,
    fecha_mensaje DATE DEFAULT SYSDATE NOT NULL,
    content_msg VARCHAR2(255),
    CONSTRAINT PK_MENSAJE PRIMARY KEY (id_mensaje)

);


/*
CREATE TABLE mensaje(
    id_mensaje NUMBER(10)GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
    id_sender NUMBER(8) NOT NULL,
    id_receiver NUMBER(8) NOT NULL,
    mensaje VARCHAR2(500),
    CONSTRAINT PK_MENSAJE PRIMARY KEY (id_mensaje)
);*/


-- LLAVES FORANEAS

ALTER TABLE USERS
    ADD CONSTRAINT FK_USERS_ROLE FOREIGN KEY (id_role)
        REFERENCES ROLE (id_role);

ALTER TABLE publicacion
    ADD CONSTRAINT FK_PUBLICACION_USER FOREIGN KEY (id_user)
        REFERENCES USERS (id_user);

ALTER TABLE mensaje
    ADD CONSTRAINT fk_mensaje_sender FOREIGN KEY (id_user_sender)
        REFERENCES USERS (id_user);


ALTER TABLE mensaje
    ADD CONSTRAINT fk_mensaje_receiver FOREIGN KEY (id_user_receiver)
        REFERENCES USERS (id_user);

/*
ALTER TABLE mensaje
    ADD CONSTRAINT FK_MENSAJE_SENDER FOREIGN KEY (id_user)
        REFERENCES USERS (id_user);

ALTER TABLE mensaje
    ADD CONSTRAINT FK_MENSAJE_RECEIVER FOREIGN KEY (id_user)
        REFERENCES USERS (id_user);
        
        */

-- POBLACION

-- PERMISOS === (X X X X X X)
--              (Ver feed, Publicar en el feed, Enviar mensajes, Panel de Reportes, Panel de Moderador, Panel General de Admin)
INSERT INTO ROLE (NOMBRE_ROLE,PERMISOS) VALUES ('Admin','111111');
INSERT INTO ROLE (NOMBRE_ROLE,PERMISOS) VALUES ('Mod','111110');
INSERT INTO ROLE (NOMBRE_ROLE,PERMISOS) VALUES ('Helper','111100');
INSERT INTO ROLE (NOMBRE_ROLE,PERMISOS) VALUES ('User','111000');
INSERT INTO ROLE (NOMBRE_ROLE,PERMISOS) VALUES ('Muted','110000');
INSERT INTO ROLE (NOMBRE_ROLE,PERMISOS) VALUES ('Restricted','100000');
INSERT INTO ROLE (NOMBRE_ROLE,PERMISOS) VALUES ('VacBanned','000000');

-- Default Users
INSERT INTO USERS(username,email,pwd,id_role) VALUES ('test','test@test.com','1234',3);
INSERT INTO USERS(username,email,pwd,id_role) VALUES ('panxitovilla','panixo@gmail.com','12390',4);


INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de publicaciones');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy fue un buen día para programar');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy aprendiendo Oracle SQL');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Me gusta cómo quedó el modelo de datos');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'¿Alguien más usa JavaFX?');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy tomando un café mientras estudio');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando inserts masivos');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy llovió un poco en Santiago');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy revisando mis commits');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Quiero mejorar mi front end');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy escuchando música mientras programo');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'¿Qué tal su día?');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Me encanta optimizar bases de datos');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy aprendí algo nuevo sobre transacciones');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy probando validaciones en Java');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'A veces programar es terapéutico');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy preparando un proyecto personal');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'¿Qué framework recomiendan para UI?');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy me levanté motivado');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el feed con más datos');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy revisando documentación técnica');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Me gusta cómo quedó mi setup de Linux');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy aprendí sobre claves foráneas');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy haciendo pruebas de rendimiento');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando inserts automáticos');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy trabajando en un backlog');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy cociné algo rico');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy revisando mis notas de clase');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el scroll infinito');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy me siento productivo');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy aprendiendo sobre índices');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando consultas JOIN');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy revisé mi proyecto de Java');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy tomando un descanso corto');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de roles');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy aprendí sobre normalización');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy revisando triggers');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando la interfaz del sistema');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy salí a caminar un rato');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy pensando en un nuevo proyecto');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando la carga del servidor');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy estudié modelado ER');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy revisando mis diagramas');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de permisos');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy aprendí sobre commits en Oracle');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy ajustando mi código Java');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de login');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy revisé mis tareas pendientes');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy haciendo pruebas de UI');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de mensajes');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy aprendí sobre constraints');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy revisando mis scripts SQL');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de reportes');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy me siento inspirado');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy preparando una presentación');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de notificaciones');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hoy aprendí sobre sequences');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Estoy revisando mis clases Java');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Probando el sistema de búsqueda');


-- SELECTS

SELECT * FROM USERS;

SELECT * FROM ROLE;

SELECT u.username NOMBRE_USER,
       u.email CORREO,
       u.pwd PASSWORD,
       r.nombre_role rol,
       u.banned IS_BAN
FROM USERS U JOIN ROLE R
                  ON U.ID_ROLE = R.ID_ROLE;

SELECT p.id_publicacion ID,
       u.username USUARIO,
       p.content_pub CONTENIDO,
       p.fecha_pub FECHA_PUBLICACION
FROM PUBLICACION P JOIN USERS U
    ON P.ID_USER = U.ID_USER;


SELECT p.id_publicacion ID,
       u.username USUARIO,
       p.content_pub CONTENIDO,
       p.fecha_pub FECHA_PUBLICACION
FROM PUBLICACION P JOIN USERS U
    ON P.ID_USER = U.ID_USER
ORDER BY p.id_publicacion DESC
OFFSET 5 ROWS FETCH NEXT 5 ROWS ONLY;
    
    
SELECT
U_SENDER.username ENVIO,
U_RECEIVER.username destino,
M.content_msg MENSAJE,
M.FECHA_MENSAJE FECHA_MENSAJE
FROM MENSAJE M
JOIN USERS U_SENDER ON M.ID_USER_SENDER = U_SENDER.ID_USER
JOIN USERS U_RECEIVER ON M.ID_USER_RECEIVER = U_RECEIVER.ID_USER
ORDER BY M.FECHA_MENSAJE DESC;

SELECT
U_SENDER.username ENVIO,
U_RECEIVER.username destino,
M.content_msg MENSAJE,
TO_CHAR(M.FECHA_MENSAJE, 'DD/MM/YYYY HH:MM:SS') FECHA_MENSAJE
FROM MENSAJE M
JOIN USERS U_SENDER ON M.ID_USER_SENDER = U_SENDER.ID_USER
JOIN USERS U_RECEIVER ON M.ID_USER_RECEIVER = U_RECEIVER.ID_USER
WHERE U_SENDER.ID_USER = 2
ORDER BY M.FECHA_MENSAJE DESC;

SELECT
U_SENDER.username ENVIO,
U_RECEIVER.username destino,
M.content_msg MENSAJE,
TO_CHAR(M.FECHA_MENSAJE, 'DD/MM/YYYY HH24:MI:SS') FECHA_MENSAJE
FROM MENSAJE M
JOIN USERS U_SENDER ON M.ID_USER_SENDER = U_SENDER.ID_USER
JOIN USERS U_RECEIVER ON M.ID_USER_RECEIVER = U_RECEIVER.ID_USER
ORDER BY M.FECHA_MENSAJE DESC;


SELECT * FROM PUBLICACION;

--

COMMIT;
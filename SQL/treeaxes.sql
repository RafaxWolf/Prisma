--- DROP
DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE ROLE CASCADE CONSTRAINTS;
DROP TABLE PUBLICACION CASCADE CONSTRAINTS;
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

INSERT INTO USERS(username,email,pwd,id_role) VALUES ('test','test@test.com','1234',3);
INSERT INTO USERS(username,email,pwd,id_role) VALUES ('panxitovilla','panixo@gmail.com','12390',4);


INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Hola como esta todo el mundo');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'ayer me levante');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Olaaa');
INSERT INTO publicacion(id_user,content_pub) VALUES (2,'Adios');




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


SELECT * FROM PUBLICACION;

--
COMMIT;

--- NEW QUERY
SELECT

    u.username, u.password, r.role_name, p.name AS "permission_name"


FROM USERS u
         JOIN USER_ROLES ur ON u.id = ur.user_id
         JOIN ROLES r ON ur.role_id = r.id
         JOIN ROLE_PERMISSIONS rp ON r.id = rp.role_id
         JOIN PERMISSIONS p ON rp.permission_id = p.id;



-- CREATE TABLE users(
--                       id_user NUMBER(8) GENERATED ALWAYS AS IDENTITY
--     INCREMENT BY 1 NOT NULL,
--                       username VARCHAR2(32) NOT NULL UNIQUE,
--                       register_date DATE DEFAULT SYSDATE NOT NULL,
--                       banned Number(1) DEFAULT 0 NOT NULL,
--                       CONSTRAINT PK_USER PRIMARY KEY (id_user),
--                       CONSTRAINT chk_is_banned CHECK (banned IN (0,1))
-- );
--
--
-- CREATE TABLE messages(
--
--     id_message NUMBER(8) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 NOT NULL,
--     id_user_sender NUMBER(8) NOT NULL,
--     id_user_receiver NUMBER(8) NOT NULL,
--     content_msg VARCHAR2(1000) NOT NULL,
--     fecha_mensaje DATE DEFAULT SYSDATE NOT NULL,
--
--     CONSTRAINT PK_MESSAGE PRIMARY KEY (id_message),
--
--     CONSTRAINT FK_SENDER FOREIGN KEY (id_user_sender) REFERENCES users (id_user),
--     CONSTRAINT FK_RECEIVER FOREIGN KEY (id_user_receiver) REFERENCES users (id_user)
--
-- );
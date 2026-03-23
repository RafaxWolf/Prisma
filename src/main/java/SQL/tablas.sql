--- DROP & PURGE
DROP TABLE users CASCADE CONSTRAINTS PURGE;
DROP TABLE messages CASCADE CONSTRAINTS PURGE;

-- Tables
CREATE TABLE users(
      id_user NUMBER(8) GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
      username VARCHAR2(32) NOT NULL UNIQUE,
      register_date DATE DEFAULT SYSDATE NOT NULL,
      banned Number(1) DEFAULT 0 NOT NULL,
      CONSTRAINT PK_USER PRIMARY KEY (id_user),
      CONSTRAINT chk_is_banned CHECK (banned IN (0,1))
);
CREATE TABLE messages(
      id_message NUMBER(8) GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
      id_user_sender NUMBER(8) NOT NULL,
      id_user_receiver NUMBER(8) NOT NULL,
      content_msg VARCHAR2(1000) NOT NULL,
      fecha_mensaje DATE DEFAULT SYSDATE NOT NULL,

    -- Foreign Keys
    CONSTRAINT PK_MESSAGE PRIMARY KEY (id_message),

    CONSTRAINT FK_SENDER FOREIGN KEY (id_user_sender) REFERENCES users (id_user),
    CONSTRAINT FK_RECEIVER FOREIGN KEY (id_user_receiver) REFERENCES users (id_user)
);

-- Listas
-- Users
SELECT u.id_user ID_USER,
    u.username USER_NAME,
    u.banned IS_BAN,
    u.register_date REGISTER_DATE
FROM users u
ORDER BY u.id_user ASC;

-- Messages
SELECT m.id_message ID_MESSAGE,
    U_SENDER.username SENDER,
    U_RECEIVER.username RECEIVER,
    m.content_msg MENSAJE,
    TO_CHAR(m.fecha_mensaje, 'DD/MM/YYYY HH:MM:SS') FECHA_MENSAJE
FROM messages m
    JOIN users U_SENDER ON m.id_user_sender = U_SENDER.id_user
    JOIN users U_RECEIVER ON m.id_user_receiver = U_RECEIVER.id_user
ORDER BY m.fecha_mensaje;

-- Commit
COMMIT;
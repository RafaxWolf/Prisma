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

    id_message NUMBER(8) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 NOT NULL,
    id_user_sender NUMBER(8) NOT NULL,
    id_user_receiver NUMBER(8) NOT NULL,
    content_msg VARCHAR2(1000) NOT NULL,
    fecha_mensaje DATE DEFAULT SYSDATE NOT NULL,

    CONSTRAINT PK_MESSAGE PRIMARY KEY (id_message),

    CONSTRAINT FK_SENDER FOREIGN KEY (id_user_sender) REFERENCES users (id_user),
    CONSTRAINT FK_RECEIVER FOREIGN KEY (id_user_receiver) REFERENCES users (id_user)

);
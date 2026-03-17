CREATE TABLE users(
                      id_user NUMBER(8) GENERATED ALWAYS AS IDENTITY
    INCREMENT BY 1 NOT NULL,
                      username VARCHAR2(32) NOT NULL UNIQUE,
                      register_date DATE DEFAULT SYSDATE NOT NULL,
                      banned Number(1) DEFAULT 0 NOT NULL,
                      CONSTRAINT PK_USER PRIMARY KEY (id_user),
                      CONSTRAINT chk_is_banned CHECK (banned IN (0,1))
);
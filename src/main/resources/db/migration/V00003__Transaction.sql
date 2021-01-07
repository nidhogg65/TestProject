CREATE TABLE TRANSACTION (
    ID                  BIGINT          NOT NULL        PRIMARY KEY AUTO_INCREMENT,
    ACCOUNT_ID_FROM     BIGINT          NOT NULL,
    ACCOUNT_ID_TO       BIGINT          NOT NULL,
    AMOUNT              DECIMAL(12,2)   NOT NULL,
    TYPE                SMALLINT        NOT NULL,
    CATEGORY            SMALLINT        NOT NULL,
    CREATED_AT          TIMESTAMP       NOT NULL
);

ALTER TABLE TRANSACTION ADD FOREIGN KEY (ACCOUNT_ID_FROM) REFERENCES ACCOUNT(ID);
ALTER TABLE TRANSACTION ADD FOREIGN KEY (ACCOUNT_ID_TO) REFERENCES ACCOUNT(ID);
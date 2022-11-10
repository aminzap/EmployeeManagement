CREATE TABLE LOCATION
(
    ID             BIGINT       NOT NULL,
    STREET_ADDRESS VARCHAR(255) NOT NULL,
    POSTAL_CODE    VARCHAR(50)  NOT NULL,
    CITY           VARCHAR(100) NOT NULL,
    PROVINCE       VARCHAR(100) NOT NULL,
    COUNTRY_ID     BIGINT       NOT NULL,
    PRIMARY KEY (ID)
);
ALTER TABLE LOCATION
    ADD CONSTRAINT FK_LOCATION_COUNTRY FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (ID);
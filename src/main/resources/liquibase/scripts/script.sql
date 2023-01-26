-- liquibase formatted sql

-- changeset Shilov:1

CREATE TABLE sock
(
    id          BIGINT NOT NULL,
    color       VARCHAR(255),
    cotton_part INTEGER NOT NULL CHECK ( cotton_part >=0 AND cotton_part <=100),
    CONSTRAINT pk_sock PRIMARY KEY (id)
);
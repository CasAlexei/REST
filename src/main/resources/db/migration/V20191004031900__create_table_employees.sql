CREATE TABLE employees
(
    employee_id    NUMBER(6) PRIMARY KEY,
    first_name     VARCHAR2(20),
    last_name      VARCHAR2(25)        NOT NULL,
    email          VARCHAR2(25) UNIQUE NOT NULL,
    phone_number   VARCHAR2(20),
    hire_date      DATE                NOT NULL,
    job_id         VARCHAR2(10)        NOT NULL,
    salary         NUMBER(8, 2),
    commission_pct NUMBER(2, 2)
);

CREATE SEQUENCE employees_seq NOCACHE;


ALTER TABLE employees
    MODIFY employee_id DEFAULT employees_seq.nextval;  --whe use sequence to generate id. nextval give a next id by id++




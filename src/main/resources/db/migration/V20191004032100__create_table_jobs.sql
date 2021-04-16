CREATE TABLE jobs
(
    job_id     VARCHAR2(10) PRIMARY KEY,
    job_title  VARCHAR2(35) NOT NULL,
    min_salary NUMBER(6),
    max_salary NUMBER(6),

    CONSTRAINT min_max_salary_ck CHECK ( min_salary < max_salary )
);
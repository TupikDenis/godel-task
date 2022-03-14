CREATE TABLE IF NOT EXISTS employees
(
    id    SERIAL PRIMARY KEY,
    first_name  VARCHAR(20) NOT NULL ,
    last_name VARCHAR(20) NOT NULL ,
    department_id BIGINT  NOT NULL,
    job_title VARCHAR(15) NOT NULL,
    gender VARCHAR(10) NOT NULL
);
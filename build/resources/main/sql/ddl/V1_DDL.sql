CREATE SCHEMA "manager"

CREATE TABLE "manager".tb_category(
        idCategory serial NOT NULL,
        name VARCHAR(100) NOT NULL,
        description VARCHAR(250) NOT NULL
)
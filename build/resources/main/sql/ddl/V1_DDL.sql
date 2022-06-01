CREATE SCHEMA "manager"


CREATE TABLE "manager".tb_category(
        id_category serial NOT NULL,
        name VARCHAR(100) NOT NULL,
        description VARCHAR(250) NOT null,
        date_insert timestamptz not null,
        date_update timestamptz not null,
        CONSTRAINT tb_category_pk PRIMARY KEY (id_category)
)

CREATE TABLE "manager".tb_product(
        id_product serial NOT NULL,
        name VARCHAR(100) NOT NULL,
        description VARCHAR(250) NOT null,
        price numeric not null,
        id_category serial not null,
        date_insert timestamptz not null,
        date_update timestamptz not null,
        CONSTRAINT tb_product_pk PRIMARY KEY (id_product)
);


-- invoice.tb_transaction_invoice foreign keys

ALTER TABLE manager.tb_product ADD CONSTRAINT tb_product_fk FOREIGN KEY (id_category) REFERENCES manager.tb_category(id_category);
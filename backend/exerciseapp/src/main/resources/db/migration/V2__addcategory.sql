CREATE TABLE IF NOT EXISTS category (
    category_id SERIAL,
    name VARCHAR(45) NOT NULL,
    PRIMARY KEY(category_id)
)
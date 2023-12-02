CREATE TABLE user_app(
    user_id SERIAL,
    username VARCHAR(45) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(45) NOT NULL,
    is_active BOOLEAN,
    PRIMARY KEY (user_id)

)
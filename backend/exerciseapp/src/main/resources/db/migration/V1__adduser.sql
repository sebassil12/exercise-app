CREATE TABLE user_app(
    user_id SERIAL,
    username VARCHAR(45) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(245) NOT NULL,
    is_active BOOLEAN,
    role VARCHAR(45),
    PRIMARY KEY (user_id)

)
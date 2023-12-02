CREATE TABLE IF NOT EXISTS exercise (
    exercise_id SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    image_url VARCHAR(45)
)
CREATE TABLE IF NOT EXISTS category_exercise(
    category_exercise_id SERIAL PRIMARY KEY,
    category_id INT NOT NULL,
    exercise_id INT NOT NULL,
    FOREIGN KEY(category_id) REFERENCES category(category_id),
    FOREIGN KEY(exercise_id) REFERENCES exercise(exercise_id)
)
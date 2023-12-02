CREATE TABLE IF NOT EXISTS favorite (
    favorite_id SERIAL PRIMARY KEY ,
    user_id INT NOT NULL, 
    exercise_id INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user_app(user_id),
    FOREIGN KEY(exercise_id) REFERENCES exercise(exercise_id)
)
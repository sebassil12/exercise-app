package com.exercise.exerciseapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_exercise")
public class CategoryExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_exercise_id")
    private Integer categoryExerciseId;
    @JoinColumn(name = "category_id")
    private Integer categoryId;
    @JoinColumn(name = "exercise_id")
    private Integer exerciseId;

    public CategoryExercise(){

    }

    public CategoryExercise(Integer categoryId, Integer exerciseId){
        this.categoryId=categoryId;
        this.exerciseId=exerciseId;
    }

    public Integer getCategoryId(){
        return categoryId;
    }

    public Integer getExerciseId(){
        return exerciseId;
    }

    @Override
    public String toString(){
        return "{CategoryExercise"+
                "id="+categoryExerciseId+
                "categoryId="+categoryId+
                "exerciseId="+exerciseId+
                "}";
    }
}

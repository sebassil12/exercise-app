package com.exercise.exerciseapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="favorite_id")
    private Integer favoriteId;
    @JoinColumn(name="user_id")
    private Integer userId;
    @JoinColumn(name="exercise_id")
    private Integer exerciseId;

    public Favorite(){

    }
    public Favorite(Integer userId, Integer exerciseId){
        this.userId=userId;
        this.exerciseId=exerciseId;
    }

    public Integer getUserId(){
        return userId;
    }
    public Integer getExerciseId(){
        return exerciseId;
    }
    public void setUserId(Integer userId){
        this.userId=userId;
    }
    public void setExerciseId(Integer exerciseId){
        this.exerciseId=exerciseId;
    }
    @Override
    public String toString(){
        return "{Favorite"+
                "id="+favoriteId+
                "userId="+userId+
                "exerciseId="+exerciseId+
                "}";
    }
}

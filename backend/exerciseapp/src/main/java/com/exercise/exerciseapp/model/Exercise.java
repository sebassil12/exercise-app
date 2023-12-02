package com.exercise.exerciseapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Integer exerciseId;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;

    public Exercise(){

    }

    public Exercise(Integer exerciseId, String name, String imageUrl){
        this.exerciseId=exerciseId;
        this.name=name;
        this.imageUrl=imageUrl;
    }

    public Integer getId(){
        return exerciseId;
    }
    public String getName(){
        return name;
    }
    public String getImage(){
        return imageUrl;
    }
    public void setId(Integer exerciseId){
        this.exerciseId=exerciseId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setImage(String imageUrl){
        this.imageUrl=imageUrl;
    }
    @Override
    public String toString(){
        return "{Exercise"+
                "exerciseId="+exerciseId+
                "name="+name+
                "imageUrl="+imageUrl+
                "}";
    }
}

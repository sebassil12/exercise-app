package com.exercise.exerciseapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Integer categoryId;
    private String name;

    public Category(){
        
    }
    public Category(Integer categoryId, String name){
        this.categoryId=categoryId;
        this.name=name;
    }

    public Integer getId(){
        return categoryId;
    }
    public String getName(){
        return name;
    }

    public void setId(Integer categoryId){
        this.categoryId=categoryId;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return "{Category "+
                "categoryId=" + categoryId+
                "name="+name+
                "}";
    }

}

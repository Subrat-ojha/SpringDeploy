package com.javacracker.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String difficulty;
    private String topics; // Store as comma-separated (e.g. "Array,Sorting")
    private double acceptance;
    private double frequency;
    private boolean premium;
    private boolean solution;
    private boolean solved;

    // Getters and setters
}

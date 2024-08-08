package com.crmanagement.crmsystem;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="lead_db")
public class LeadEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String contact;
    private String address;
    private String companyName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    private String clientStage;
    private boolean isActive;

}

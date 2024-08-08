package com.crmanagement.crmsystem;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lead {
    private int id;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String companyName;
    private LocalDateTime createdAt  = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private String notes;
    private String clientStage;
    private boolean isActive;

}

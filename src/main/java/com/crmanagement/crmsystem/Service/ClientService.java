package com.crmanagement.crmsystem.Service;

import java.util.List;

import com.crmanagement.crmsystem.Lead;

public interface ClientService {

        //Lead CRUD operations
    String createLead(Lead lead);
    List<Lead> readLeads();
    String updateLead(int id, Lead lead);
    Boolean deleteLead(int id);


        //Lead handlind functionalities
}

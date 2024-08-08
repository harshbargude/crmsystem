package com.crmanagement.crmsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crmanagement.crmsystem.Lead;
import com.crmanagement.crmsystem.Service.ClientService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public class CRMcontroller {

    @Autowired
    private ClientService clientService;

    @PostMapping("createLead")
    public String CreateLead(@RequestBody Lead lead) {
        return clientService.createLead(lead);
    }

    @PutMapping("updatelead/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Lead lead) {
        return clientService.updateLead(id, lead);
    }

    @GetMapping("leads")
    public List<Lead> getLeads() {
        return clientService.readLeads();
    }

    @DeleteMapping("deletelead/{id}")
    public String deleteLead(@PathVariable int id) {
        if (clientService.deleteLead(id)) {
            return "Lead deleted successfully";
        } else {
            return "Failed to delete lead with id " + id;
        }
    }
   
}

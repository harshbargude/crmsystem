package com.crmanagement.crmsystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crmanagement.crmsystem.Lead;
import com.crmanagement.crmsystem.LeadEntity;
import com.crmanagement.crmsystem.repository.CrmRepository;

@Service
public class ClientServiceIMP implements ClientService{

    @Autowired
    private CrmRepository crmRepository;

    @Override
    public String createLead(Lead lead) {
        LeadEntity leadEntity = new LeadEntity();
        BeanUtils.copyProperties(lead, leadEntity);
        crmRepository.save(leadEntity);

        return "New lead added";
    }

    @Override
    public List<Lead> readLeads() {
        List<LeadEntity> entities = crmRepository.findAll();
        List<Lead> leads = new ArrayList<>();
        for(LeadEntity entity: entities) {
            Lead lead = new Lead();
            lead.setId(entity.getId());
            lead.setName(entity.getName());
            lead.setEmail(entity.getEmail());
            lead.setContact(entity.getContact());
            lead.setAddress(entity.getAddress());
            lead.setCompanyName(entity.getCompanyName());
            lead.setCreatedAt(entity.getCreatedAt());
            lead.setUpdatedAt(entity.getUpdatedAt());
            lead.setNotes(entity.getNotes());
            lead.setClientStage(entity.getClientStage());
            lead.setActive(entity.isActive());

            leads.add(lead);
        }
        return leads;
    }

    @Override
    public String updateLead(int id, Lead client) {
        LeadEntity leadEntity =  crmRepository.findById(id).get();
        leadEntity.setName(client.getName());
        leadEntity.setContact(client.getContact());
        leadEntity.setEmail(client.getEmail());
        leadEntity.setAddress(client.getAddress());
        leadEntity.setCompanyName(client.getCompanyName());
        leadEntity.setUpdatedAt(client.getUpdatedAt());
        leadEntity.setNotes(client.getNotes());
        leadEntity.setClientStage(client.getClientStage());
        leadEntity.setActive(client.isActive());
        crmRepository.save(leadEntity);
        return  "Lead Updated Successfully!!";
    }

    @Override
    public Boolean deleteLead(int id) {
        if (crmRepository.existsById(id)) {
            crmRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}

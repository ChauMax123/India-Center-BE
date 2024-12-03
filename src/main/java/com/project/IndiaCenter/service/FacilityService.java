package com.project.IndiaCenter.service;

import com.project.IndiaCenter.dto.FacilityDTO;
import com.project.IndiaCenter.entity.Facility;
import com.project.IndiaCenter.repository.FacilityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FacilityService {
    private FacilityRepository facilityRepository;
    public List<Facility> getAllFacilities(){
        return facilityRepository.findAll();
    };
    public Facility getFacilityById(Long id){
        return facilityRepository.findById(id).orElse(null);
    };
    public Facility addFacility(FacilityDTO facilityDTO){
        Facility facility = new Facility();
        facility.setName(facilityDTO.getName());
        facility.setDescription(facilityDTO.getDescription());
        facility.setAvailable(facilityDTO.isAvailable());

        return facilityRepository.save(facility);
    };
}

package com.project.IndiaCenter.controller;

import com.project.IndiaCenter.dto.FacilityDTO;
import com.project.IndiaCenter.entity.Facility;
import com.project.IndiaCenter.service.FacilityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/facilities")
@AllArgsConstructor
public class FacilityController {

    private FacilityService facilityService;

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{id}")
    public Facility getFacilityByID(@PathVariable Long id) {
        return facilityService.getFacilityById(id);
    }
    @PostMapping
    public ResponseEntity<Facility> addFacility(@RequestBody FacilityDTO facilityDTO){
        Facility newFacility =  facilityService.addFacility(facilityDTO);
        return new ResponseEntity<>(newFacility, HttpStatus.CREATED);
    }
}

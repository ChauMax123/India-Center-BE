package com.project.IndiaCenter.controller;

import com.project.IndiaCenter.dto.InquiryDTO;
import com.project.IndiaCenter.entity.Inquiry;
import com.project.IndiaCenter.service.InquiryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiry")
@AllArgsConstructor
public class InquiryController {
    private InquiryService inquiryService;

    @GetMapping
    public List<Inquiry> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @GetMapping("/{id}")
    public Inquiry getInquiryById(@PathVariable Long id) {
        return inquiryService.getInquiryById(id);
    }

    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(@RequestBody InquiryDTO inquiryDTO) {
        Inquiry newInquiry = inquiryService.createInquiry(inquiryDTO);
        return new ResponseEntity<>(newInquiry, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        inquiryService.deleteInquiry(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inquiry> updateInquiry(@PathVariable Long id,
                                                 @RequestParam String message) {

        Inquiry updatedInquiry = inquiryService.updateInquiry(id, message);
        return ResponseEntity.ok(updatedInquiry);
    }
}

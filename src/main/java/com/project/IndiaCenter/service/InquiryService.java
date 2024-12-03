package com.project.IndiaCenter.service;

import com.project.IndiaCenter.dto.InquiryDTO;
import com.project.IndiaCenter.entity.Inquiry;
import com.project.IndiaCenter.repository.InquiryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InquiryService {
    private InquiryRepository inquiryRepository;

    public Inquiry createInquiry(InquiryDTO inquiryDTO) {

        Inquiry inquiry = new Inquiry();
        inquiry.setFacilityId(inquiryDTO.getFacilityId());
        inquiry.setUserName(inquiryDTO.getUserName());
        inquiry.setMessage(inquiryDTO.getMessage());
        inquiry.setStatus("Pending");

        return inquiryRepository.save(inquiry);
    }

    public List<Inquiry> getAllInquiries(){
        return inquiryRepository.findAll();
    }

    public Inquiry getInquiryById(Long inquiryId){
        return inquiryRepository.findById(inquiryId).orElse(null);
    }

    public void deleteInquiry(Long id){
        inquiryRepository.deleteById(id);
    }

    public Inquiry updateInquiry(Long inquiryId, String status){
        Inquiry updatedInquiry = inquiryRepository.findById(inquiryId)
                .orElseThrow(() -> new IllegalArgumentException("Inquiry not found"));

        updatedInquiry.setStatus(status);
        return inquiryRepository.save(updatedInquiry);
    }
}

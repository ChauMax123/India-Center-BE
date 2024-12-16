package com.project.IndiaCenter.service;

import com.project.IndiaCenter.dto.InquiryDTO;
import com.project.IndiaCenter.entity.Inquiry;
import com.project.IndiaCenter.repository.InquiryRepository;
import com.project.IndiaCenter.utils.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InquiryService {
    private final InquiryRepository inquiryRepository;
    private final EmailService emailService;

    public Inquiry createInquiry(InquiryDTO inquiryDTO) {
        // Create the inquiry entity from the DTO
        Inquiry newInquiry = new Inquiry();
        newInquiry.setFromName(inquiryDTO.getFromName());
        newInquiry.setPhone(inquiryDTO.getPhone());
        newInquiry.setEmail(inquiryDTO.getEmail());
        newInquiry.setSubject(inquiryDTO.getSubject());
        newInquiry.setMessage(inquiryDTO.getMessage());

        newInquiry.setStatus("Pending");

        // Save the inquiry
        Inquiry savedInquiry = inquiryRepository.save(newInquiry);

        // Send the initial inquiry email to the admin
        String emailSubject = "New Inquiry Received: " + inquiryDTO.getSubject();
        String emailMessage = "<html><body>" +
                "<h2>You have received a new inquiry:</h2>" +
                "<p><strong>Name:</strong> " + inquiryDTO.getFromName() + "</p>" +
                "<p><strong>Phone:</strong> " + inquiryDTO.getPhone() + "</p>" +
                "<p><strong>Email:</strong> " + inquiryDTO.getEmail() + "</p>" +
                "<p><strong>Subject:</strong> " + inquiryDTO.getSubject() + "</p>" +
                "<p><strong>Message:</strong><br>" + inquiryDTO.getMessage() + "</p>" +
                "</body></html>";

        emailService.sendEmail("indiacenterlatvia@gmail.com", emailSubject, emailMessage);

        // Log the email sending
        System.out.println("Return email being sent to: " + inquiryDTO.getEmail());

        // Send the return email to the user
        String returnEmailSubject = "Thank you for your inquiry!";
        String returnEmailMessage = "<html><body>" +
                "<h2>Thank you for your inquiry!</h2>" +
                "<p>Dear " + inquiryDTO.getFromName() + ",</p>" +
                "<p>We have received your inquiry regarding: <b>" + inquiryDTO.getSubject() + "</b>.</p>" +
                "<p>Our team will get back to you shortly. In the meantime, feel free to contact us if you have any further questions.</p>" +
                "<p>Best regards,<br>India Center Team</p>" +
                "</body></html>";
        emailService.sendEmail(inquiryDTO.getEmail(), returnEmailSubject, returnEmailMessage);


        return savedInquiry;
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

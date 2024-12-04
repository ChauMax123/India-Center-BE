package com.project.IndiaCenter.service;

import com.project.IndiaCenter.dto.BookingDTO;
import com.project.IndiaCenter.entity.Booking;
import com.project.IndiaCenter.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;

    public Booking createBooking(BookingDTO bookingDTO) {

        if(!isFacilityAvailable(bookingDTO.getFacilityId(), bookingDTO.getStartTime(), bookingDTO.getEndTime())){
              throw new IllegalArgumentException("Facility is not available during the requested time.");
         }

        Booking booking = new Booking();
        booking.setFacilityId(bookingDTO.getFacilityId());
        booking.setUserName(bookingDTO.getUserName());
        booking.setStartTime(bookingDTO.getStartTime());
        booking.setEndTime(bookingDTO.getEndTime());

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(@PathVariable Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void deleteBooking(@PathVariable Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public Booking updateBooking(Long bookingId, LocalDateTime startTime, LocalDateTime endTime) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found."));

        if(!isFacilityAvailable(existingBooking.getFacilityId(), startTime, endTime)){
             throw new IllegalArgumentException("Facility is not available during the requested time.");
        }

        existingBooking.setStartTime(startTime);
        existingBooking.setEndTime(endTime);

        return bookingRepository.save(existingBooking);
    }

    public Boolean isFacilityAvailable(Long facilityId, LocalDateTime startTime, LocalDateTime endTime) {
        List<Booking> existingBookings = bookingRepository.findAll();
        for (Booking booking : existingBookings) {
            if (booking.getFacilityId().equals(facilityId) && booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(startTime)) {
                return false;
            }
        }
        return true;
    }

}

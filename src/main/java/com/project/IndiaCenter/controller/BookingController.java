package com.project.IndiaCenter.controller;

import com.project.IndiaCenter.dto.BookingDTO;
import com.project.IndiaCenter.entity.Booking;
import com.project.IndiaCenter.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(BookingDTO bookingDTO) {

        Booking booking = bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Booking> updateBooking(@RequestParam Long bookingId,
                                                 @RequestParam LocalDateTime startTime,
                                                 @RequestParam LocalDateTime endTime) {
        Booking updatedBooking = bookingService.updateBooking(bookingId, startTime, endTime);
        return ResponseEntity.ok(updatedBooking);
    }
}

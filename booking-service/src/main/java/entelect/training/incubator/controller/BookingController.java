package entelect.training.incubator.controller;

import entelect.training.incubator.model.Booking;
import entelect.training.incubator.model.BookingCustomerSearchRequest;
import entelect.training.incubator.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) { this.bookingService = bookingService; }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        final Booking savedBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getBookings() {
        List<Booking> bookings = bookingService.getBookings();

        if (!bookings.isEmpty()) {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchBooking(@RequestBody BookingCustomerSearchRequest searchRequest) {

        Booking booking = bookingService.searchBookings(searchRequest);

        if (booking != null) {
            return ResponseEntity.ok(booking);
        }

        return ResponseEntity.notFound().build();
    }
}

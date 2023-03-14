package entelect.training.incubator.service;

import entelect.training.incubator.model.Booking;
import entelect.training.incubator.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) { this.bookingRepository = bookingRepository; }

    public Booking createBooking(Booking booking) { return bookingRepository.save(booking); }

    public List<Booking> getBookings() {
        Iterable<Booking> bookingIterable = bookingRepository.findAll();

        List<Booking> result = new ArrayList<>();
        bookingIterable.forEach(result::add);

        return result;
    }


}

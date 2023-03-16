package entelect.training.incubator.service;

import entelect.training.incubator.model.Booking;
import entelect.training.incubator.model.BookingCustomerSearchRequest;
import entelect.training.incubator.model.SearchType;
import entelect.training.incubator.repository.BookingRepository;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.function.Supplier;

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

    public Booking searchBookings(BookingCustomerSearchRequest searchRequest) {
        Map<SearchType, Supplier<Optional<Booking>>> searchStrategies = new HashMap();

        searchStrategies.put(SearchType.CUSTOMER_SEARCH, () -> bookingRepository.findByCustomerId(searchRequest.getCustomerID()));
        searchStrategies.put(SearchType.REFERENCE_SEARCH, () -> bookingRepository.findByReference(searchRequest.getReferenceNumber()));

        Optional<Booking> bookingOptional = searchStrategies.get(searchRequest.getSearchType()).get();

        return bookingOptional.orElse(null);
    }


}

package entelect.training.incubator.repository;

import entelect.training.incubator.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

    Optional<Booking> findByCustomerId(Integer customerID);

    Optional<Booking> findByReference(String referenceNumber);
}

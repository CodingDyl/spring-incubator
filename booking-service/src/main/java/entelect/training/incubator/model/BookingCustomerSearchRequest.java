package entelect.training.incubator.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingCustomerSearchRequest {
    private SearchType searchType;
    private Integer customerID;
    private String referenceNumber;
}

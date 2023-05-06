package org.awesome.models.rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class RentForm {

    private Long rentalNo;
    private String user;
    private String book;
    private LocalDate returnDt;
    private LocalDate rentDt;
}

package com.assignment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class PriceServiceTest {

    @Test
    public void calculatePrice() {

        // create mock object
        DiscountRepo repoMock = mock(DiscountRepo.class);

        // create fake values
        when(repoMock.getDiscountPercentage("MOB"))
                .thenReturn(10.0);

        when(repoMock.getDiscountPercentage("LAP"))
                .thenReturn(20.0);

        // create service with mock
        PriceService service = new PriceService(repoMock);

        // call method
        double res = service.calculateFinalPrice(1000, "MOB");

        // check result
        assertEquals(900, res);
    }
}

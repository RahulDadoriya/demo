package com.citiustech.demo.utilities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CalculateTaxTest {

    @Test
    public void calculateTaxTest () {
        double originalAmount = 123.3;
        assertEquals(CalculateTax.calculateTaxAmount(originalAmount), 128.6);
    }
}

package org.schoen.ben.euler.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

public class PrimeFamilyCalculatorTest {

    @Test
    public void testGetPrimeFamilies() throws Exception {
        List<PrimeFamily> primeFamilies = PrimeFamilyCalculator.getPrimeFamilies(new BigInteger("547"));
        Assert.assertEquals("1 PrimeFamily gevonden", 1, primeFamilies.size());
    }
}

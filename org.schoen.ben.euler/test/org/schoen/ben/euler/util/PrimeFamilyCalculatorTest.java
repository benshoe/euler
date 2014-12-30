package org.schoen.ben.euler.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class PrimeFamilyCalculatorTest {

    @Before
    public void cleanUp() {
        PrimeFamilyCalculator.getInstance().clear();
    }

    @Test
    public void testGetPrimeFamilies() throws Exception {
        PrimeFamilyCalculator.addPrime(new BigInteger("47"));
        Map<PrimeFamily, List<Prime>> primeFamilies = PrimeFamilyCalculator.getPrimeFamilies();
        Assert.assertEquals("2 PrimeFamily gevonden", 2, primeFamilies.size());
    }

    @Test
    public void testGetPrimeFamilies2() throws Exception {
        PrimeFamilyCalculator.addPrime(new BigInteger("471"));
        Map<PrimeFamily, List<Prime>> primeFamilies = PrimeFamilyCalculator.getPrimeFamilies();
        System.out.println(primeFamilies);
        Assert.assertEquals("3 PrimeFamily gevonden", 3, primeFamilies.size());
    }

    @Test
    public void testFamiliesBelow100() {
        for (int i = 11; i < 100; i +=2) {
            if(PrimeUtil.isPrime(i)) {
                PrimeFamilyCalculator.addPrime(new BigInteger(String.valueOf(i)));
            }
        }
        Map<PrimeFamily, List<Prime>> primeFamilies = PrimeFamilyCalculator.getPrimeFamilies();
        PrimeFamily pfSize6 = null;
        int maxNumberOfPrimes = 0;
        for (PrimeFamily primeFamily : primeFamilies.keySet()) {
            List<Prime> primes = primeFamilies.get(primeFamily);
            int numberOfPrimes = primes.size();
            if(numberOfPrimes > maxNumberOfPrimes) {
                maxNumberOfPrimes = numberOfPrimes;
                pfSize6 = primeFamily;
            }
        }
        Assert.assertEquals("Max size = 6", 6, maxNumberOfPrimes);
        List<Prime> primes = primeFamilies.get(pfSize6);
        for (Prime prime : primes) {
            System.out.println(prime);
        }
    }

}

package org.schoen.ben.euler.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class PrimeFamilyCalculatorTest {

    @Before
    public void cleanUp() {
        PrimeFamilyCalculator.getInstance().clear();
    }

    @Test
    public void testGetPrimeFamilies() throws Exception {
        PrimeFamilyCalculator.addPrime(47L);
        Map<PrimeFamily, List<Prime>> primeFamilies = PrimeFamilyCalculator.getPrimeFamilies();
        Assert.assertEquals("2 PrimeFamily gevonden", 2, primeFamilies.size());
    }

    @Test
    public void testGetPrimeFamilies2() throws Exception {
        PrimeFamilyCalculator.addPrime(471L);
        Map<PrimeFamily, List<Prime>> primeFamilies = PrimeFamilyCalculator.getPrimeFamilies();
        System.out.println(primeFamilies);
        Assert.assertEquals("3 PrimeFamily gevonden", 3, primeFamilies.size());
    }

    @Test
    public void testFamiliesBelow100() {
        for (long i = 11; i < 100; i +=2) {
            if(PrimeUtil.isPrime(i)) {
                PrimeFamilyCalculator.addPrime(i);
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

    @Test
    public void testTwoDuplicateNumbers() {
        for (long i = 56003; i < 56995; i +=2) {
            if(PrimeUtil.isPrime(i)) {
                PrimeFamilyCalculator.addPrime(i);
            }
        }
        Map<PrimeFamily, List<Prime>> primeFamilies = PrimeFamilyCalculator.getPrimeFamilies();
        PrimeFamily primeFamilySize7 = null;
        int maxNumberOfPrimes = 0;
        for (PrimeFamily primeFamily : primeFamilies.keySet()) {
            List<Prime> primes = primeFamilies.get(primeFamily);
            int numberOfPrimes = primes.size();
            if(numberOfPrimes > maxNumberOfPrimes) {
                maxNumberOfPrimes = numberOfPrimes;
                primeFamilySize7 = primeFamily;
            }
        }
        List<Prime> primes = primeFamilies.get(primeFamilySize7);
        for (Prime prime : primes) {
            System.out.println(prime);
        }
        Assert.assertEquals("De priem-familie moet 7 groot zijn.", 7, maxNumberOfPrimes);
    }
}

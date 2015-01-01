package org.schoen.ben.euler.util;

import org.junit.Assert;
import org.junit.Test;

public class PrimeFamilyFinderTest {

    @Test
    public void testGetNumberOfPrimeFamilyMembers() throws Exception {
        int familyMembers = PrimeFamilyFinder.getNumberOfPrimeFamilyMembers("13", 0);
        Assert.assertEquals("Zes members verwacht", 6, familyMembers);
    }
}

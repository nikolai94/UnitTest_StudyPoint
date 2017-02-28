/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dk.cphbusiness.unit_testing.MonthYear;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

/**
 *
 * @author nikolai
 */
@DisplayName("TestMonthYear")
public class MonthYearTest {
    
    public MonthYearTest() {
    }
    
    @TestFactory
    public Collection<DynamicTest> dynamicTest()
    {
        MonthYear monthYear = new MonthYear();
        int[] validMonthResult = {28,29,30,31};
        int[] validMonth = {2,2,4,3};
        int[] validYear = {2017,2016,2017,2017};
        
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < validMonthResult.length; i++) {
            int result = monthYear.getNumDaysInMonth(validMonth[i], validYear[i]);
            int expResult = validMonthResult[i];
            
            Executable exec = () -> assertEquals(result, expResult);
            
            String testName = "Test - getNumDaysInMonth - valid: "+i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(testName, exec);
            dynamicTests.add(dynamicTest); 
        }
        
        return dynamicTests;
    }
    
    @Test
    public void testMonthInvalid() {
        MonthYear monthYear = new MonthYear();
        assertEquals(-1, monthYear.getNumDaysInMonth(0, 2016));
        
        assertEquals(-1, monthYear.getNumDaysInMonth(13, 2016));
    }
    
    @Test
    public void testYearInvalid(){
        MonthYear monthYear = new MonthYear();
        assertEquals(-1, monthYear.getNumDaysInMonth(1, 0));
        assertEquals(-1, monthYear.getNumDaysInMonth(1, (Integer.MAX_VALUE+1)));
    }
    
    
    
}
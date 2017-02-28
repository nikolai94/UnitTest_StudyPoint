/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testReimburse;

import DECISION_TABLES.Reimburse;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author nikolai
 */
@RunWith(Parameterized.class)
public class ReimburseTest {

    private boolean deductible;
    private boolean doctorsOffice;
    private double expenses;
    private double expectedResult;
    private static final double DELTA = 1e-15;
    
    Reimburse reimburse;
    
    public ReimburseTest(boolean deductible, boolean doctorsOffice, double expenses, double expectedResult) {
        this.deductible = deductible;
        this.doctorsOffice = doctorsOffice;
        this.expenses = expenses;
        this.expectedResult = expectedResult;
        
        reimburse = new Reimburse(deductible,doctorsOffice,expenses);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{true, true, 50, 25.0},{true, false, 50, 40.0},{false, true, 50, -1.0},{false, false, 50, -1.0}});
    }

    @Test
    public void testHowMuchReimburse() {
        double result = this.reimburse.howMuchReimburse();
        assertEquals(expectedResult, result, DELTA);
    }

}

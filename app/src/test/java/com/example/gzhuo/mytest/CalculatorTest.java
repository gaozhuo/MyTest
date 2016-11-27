package com.example.gzhuo.mytest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaozhuo on 2016/11/2.
 */
public class CalculatorTest {
    Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();

    }

    @Test
    public void sum() throws Exception {
        double result = mCalculator.sum(3, 4);
        assertEquals(7, result, 0.0001);

    }

    @Test
    public void divide() throws Exception {
        double result = mCalculator.divide(8, 4);
        assertEquals(2, result, 0.0001);

    }

    @Test
    public void multiply() throws Exception {
        double result = mCalculator.multiply(3, 4);
        assertEquals(12, result, 0.0001);

    }

}
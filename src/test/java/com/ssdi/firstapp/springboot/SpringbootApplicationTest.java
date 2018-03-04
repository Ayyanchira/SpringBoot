package com.ssdi.firstapp.springboot;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpringbootApplicationTest {

    @Test
    public void sayHello() {
        Assert.assertEquals("Hello! Welcome to spring boot application",SpringbootApplication.sayHello());
    }
}
package com.rpshjha.qabootcamp;

import com.rpshjha.qabootcamp.designpattern.CreateServiceOrder;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 5:18 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class DesignPatternDemo {

    @Test
    public void testBuilderDesign() {

        CreateServiceOrder createServiceOrder = CreateServiceOrder.builder
                .setOrderNumber("12345")
                .setOrderRefNumber("123456789")
                .setCustomerID("1")
                .build();


        System.out.println(createServiceOrder);
    }
}

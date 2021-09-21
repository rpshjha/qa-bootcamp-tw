package com.rpshjha.qabootcamp.helper;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 2:55 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class TestHelper {

    public static String getRandomEmail() {
        return "dummy" + System.currentTimeMillis() + "@yopmail.com";
    }

    public static String getRandomPassword() {
        return "Admin@123";
    }
}

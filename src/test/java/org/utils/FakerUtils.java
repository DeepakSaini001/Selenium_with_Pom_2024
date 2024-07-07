package org.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static Long generateRandomNumber(){
        Faker faker = new Faker();
        
        return faker.number().randomNumber(10, true);
        
    }
}

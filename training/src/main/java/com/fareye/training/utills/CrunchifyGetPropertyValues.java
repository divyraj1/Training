package com.fareye.training.utills;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Date;
import java.util.Properties;
import java.util.*;

@Component
public class CrunchifyGetPropertyValues {
    String result = "";
    InputStream inputStream;
    public Properties getPropValues() throws IOException {
        Properties prop = null;
        try {
            prop = new Properties();
            String propFileName = "application.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            Date time = new Date(System.currentTimeMillis());
            // get the property value and print it out
//            String user = prop.getProperty("user");
//            String company1 = prop.getProperty("company1");
//            String company2 = prop.getProperty("company2");
//            String company3 = prop.getProperty("company3");
//            result = "Company List = " + company1 + ", " + company2 + ", " + company3;
//            System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
            // System.out.println(prop.keySet());
            // System.out.println(prop.values());
            // Getting an iterator
            Iterator hmIterator = prop.entrySet().iterator();

            // Display message only


            // Iterating through Hashmap and
            // adding some bonus marks for every student
            while (hmIterator.hasNext()) {

                Map.Entry mapElement
                        = (Map.Entry) hmIterator.next();
                String value = (String) mapElement.getValue();

                // Printing mark corresponding to string entries
                System.out.println(mapElement.getKey() + " : "
                        + value);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return prop;
    }
}

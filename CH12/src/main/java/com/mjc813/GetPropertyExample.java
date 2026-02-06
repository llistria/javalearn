package com.mjc813;
import java.util.Properties;
import java.util.Set;
public class GetPropertyExample {
    public void GPE(){
        String osName = System.getProperty("osName");
        String userName = System.getProperty("osName");
        String userHome = System.getProperty("osName");
        System.out.println(osName);
        System.out.println(userName);
        System.out.println(userHome);

        System.out.println("------------------------------");
        System.out.println("key: value");
        System.out.println("------------------------------");
        Properties props = System.getProperties();
        Set keys = props.keySet();
        for (Object objKey : keys){
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.printf("%-40s: %s/n", key, value);
        }
    }
}

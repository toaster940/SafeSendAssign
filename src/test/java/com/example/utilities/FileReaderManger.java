package com.example.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManger {
    private final Properties properties;

    public FileReaderManger() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String propertyFilePath = System.getProperty("user.dir")+ "/src/test/resources/configuration.properties";

        try {
            fileReader = new FileReader(propertyFilePath);
            bufferedReader = new BufferedReader(fileReader);
            properties = new Properties();

            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getUrl() {
        String url = properties.getProperty("LoginUrl");

        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the config file.");
    }

    public long getTime() {
        String timeout = properties.getProperty("timeout");

        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout not specified in the config file.");
        }
    }
    public String getLoginPageTitle(){
        return properties.getProperty("loginPageTitle");
    }
    public String getUsername(){
        return properties.getProperty("username");
    }
    public String getPassword(){
        return properties.getProperty("password");
    }
}

package com.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class LambdaMethodHandler {
    public String handleRequest(String input, Context context) {

        System.out.println("Inside lambda function");
        String [] pathNames;
        File f = new File("/opt/lib");
        pathNames = f.list();
        for(String pathName : pathNames){
            System.out.println(pathName);
        }

        System.setProperty("webdriver.chrome.driver","/opt/lib/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--single-process");
        options.addArguments("--disable-dev-shm-usage");
        options.setBinary("/opt/lib/headless-chromium");

        ChromeDriver driver = new ChromeDriver(options);
        System.out.println("Browser started!!!!");
        driver.get("https://google.com/");
        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();
        return "Hello World - ";
    }
}

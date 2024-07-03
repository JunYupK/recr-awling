package com.recruit.recrawling.crawling.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
@Slf4j
public class RecruitCrawlingService {
    private static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static String WEB_DRIVER_PATH = "C:\\Users\\top15\\Downloads\\chromedriver-win64\\chromedriver.exe";
    public String initCrawlingService(){
        String source = "";
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        WebDriver webDriver = new ChromeDriver(options);

        log.info("웹 드라이버 세팅 완료");
        try{
            log.info("홈페이지 접속");
            webDriver.get("https://careers.kakao.com/jobs?skillSet=&part=TECHNOLOGY&company=KAKAO&keyword=&employeeType=&page=1");
            log.info("2초 대기");
            Thread.sleep(2000);
            source = webDriver.getPageSource();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            webDriver.close();
        }
        System.out.println(source);
        return source;
    }
}

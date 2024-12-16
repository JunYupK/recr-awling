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
import java.util.List;

public interface RecruitCrawlingService {
    /**
     * 지정된 URL의 웹페이지를 크롤링합니다.
     * @param url 크롤링할 웹페이지 URL
     * @return 페이지 소스
     */
    String crawlPage(String url);

    /**
     * 웹드라이버를 초기화합니다.
     * @return 초기화된 WebDriver 인스턴스
     */
    WebDriver initializeWebDriver();

    /**
     * 크롤링 작업을 완료하고 리소스를 정리합니다.
     * @param webDriver 종료할 WebDriver 인스턴스
     */
    void cleanup(WebDriver webDriver);

    public List<String> extractUrls(String baseUrl);

    public List<String> extractUrlsBySelector(String baseUrl, String cssSelector);
}

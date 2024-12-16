package com.recruit.recrawling.crawling.serviceImpl;

import com.recruit.recrawling.crawling.CrawlingException;
import com.recruit.recrawling.crawling.service.RecruitCrawlingService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public class RecruitCrawlingServiceImpl implements RecruitCrawlingService {

    private final String webDriverPath = "C:\\Users\\top15\\Downloads\\chromedriver-win64\\chromedriver.exe";
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static final int PAGE_LOAD_TIMEOUT = 10;
    private static final int IMPLICIT_WAIT = 5;

    @Override
    public String crawlPage(String url) {
        String pageSource = "";
        WebDriver driver = null;  // 변수명을 driver로 변경

        try {
            driver = initializeWebDriver();  // driver 사용
            log.info("Accessing webpage: {}", url);
            driver.get(url);

            // Explicit wait for page load
            new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT))  // driver 사용
                    .until(webDriver -> ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState")
                            .equals("complete"));

            pageSource = driver.getPageSource();  // driver 사용
            log.info("Successfully crawled page: {}", url);

        } catch (Exception e) {
            log.error("Error while crawling page: {}", url, e);
            throw new CrawlingException("Failed to crawl page: " + url, e);
        } finally {
            cleanup(driver);  // driver 사용
        }

        return pageSource;
    }

    @Override
    public WebDriver initializeWebDriver() {
        try {
            System.setProperty(WEB_DRIVER_ID, webDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments(
                    "--start-maximized",
                    "--disable-popup-blocking",
                    "--disable-notifications",
                    "--headless"  // 백그라운드 실행 옵션
            );

            WebDriver driver = new ChromeDriver(options);  // 변수명을 driver로 변경
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            log.info("WebDriver initialized successfully");
            return driver;

        } catch (Exception e) {
            log.error("Failed to initialize WebDriver", e);
            throw new CrawlingException("WebDriver initialization failed", e);
        }
    }

    @Override
    public void cleanup(WebDriver driver) {  // 매개변수명도 driver로 변경
        if (driver != null) {
            try {
                driver.quit();
                log.info("WebDriver closed successfully");
            } catch (Exception e) {
                log.error("Error while closing WebDriver", e);
            }
        }
    }
}
package com.recruit.recrawling.crawling;

public class CrawlingException extends RuntimeException{
    public CrawlingException(String message) {
        super(message);
    }
    public CrawlingException(String message, Throwable cause) {
        super(message, cause);
    }
}

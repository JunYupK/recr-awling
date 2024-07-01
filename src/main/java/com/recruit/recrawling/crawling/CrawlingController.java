package com.recruit.recrawling.crawling;

import com.recruit.recrawling.crawling.service.RecruitCrawlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crwaling")
public class CrawlingController {
    @Autowired
    private RecruitCrawlingService recruitCrawlingService;
    @GetMapping("check")
    public String check(){
        return recruitCrawlingService.initCrawlingService();
    }
}

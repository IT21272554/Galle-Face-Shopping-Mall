package com.june_we_118.gallefaceshoppingmall.Controller.SearchEngineController;

import com.june_we_118.gallefaceshoppingmall.Entity.SearchEngineEntity.SearchHistory;
import com.june_we_118.gallefaceshoppingmall.Service.SearchEngineService.SearchEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/search")
public class SearchEngineController {

    @Autowired
    private SearchEngineService searchEngineService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveSearchHistory(@RequestBody SearchHistory searchHistory) {
        searchEngineService.saveOrUpdate(searchHistory);
        return ResponseEntity.ok().build();
    }

}

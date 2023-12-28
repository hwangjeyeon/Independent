package gdscnamuton.Independent.controller;


import gdscnamuton.Independent.service.CategoryClassificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DataProvideController {

    private final CategoryClassificationService categoryClassificationService;


    // 사용자가 요청한 테이블 카테고리에 맞춰 전달
    @GetMapping("/data/{category}")
    public List<?> dataProvides(@PathVariable(name="category") String category){
        return categoryClassificationService.findCategory(category);
    }

}
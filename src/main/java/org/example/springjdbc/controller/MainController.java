package org.example.springjdbc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Component Scan
@RequestMapping("/") // Mapping URL - DispatcherServlet
public class MainController {
    @GetMapping("/")
    public String index() { // Return으로 나오는 String을 view resolver가 처리
        return "index";
    }
}

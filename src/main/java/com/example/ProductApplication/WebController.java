package com.example.ProductApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index"; // Este es el nombre del archivo index.html (sin la extensión)
    }
}

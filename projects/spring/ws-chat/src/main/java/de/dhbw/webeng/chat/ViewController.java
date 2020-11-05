package de.dhbw.webeng.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping({"/"})
    public String getStartPage() {
        return "index";
    }
}

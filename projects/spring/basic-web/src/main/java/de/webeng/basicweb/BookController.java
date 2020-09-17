package de.webeng.basicweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("books")
public class BookController {

    @GetMapping("")
    public @ResponseBody Book[] getAllBooks() {
        return new Book[] {
                new Book("Brockhaus Band 1"), new Book("Brockhaus Band 2")
        };
    }

    @GetMapping("raw")
    public @ResponseBody String getAllBooksRaw() {
    return "Brockhaus Band 1, Brockhaus Band 2";
    }
}

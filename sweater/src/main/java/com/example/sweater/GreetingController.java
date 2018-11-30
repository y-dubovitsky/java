package com.example.sweater;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Контроллер, отвечает за получение данных от пользователя и возвращает ему ответ.
 */
@Controller
public class GreetingController {

    /**
     *
     * @param name - имя переменной, с которой пользователь работает 'insert';
     * @param model
     * @return
     */
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="insert", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("insert", name);
        return "greeting";
    }

    /**
     * Мапинг.
     * @param map - variable - имя переменной; value - ее значение.
     * @return - страницу index.mustache
     */
    @GetMapping("/index")
    public String index(Map<String, Object> map) {
        map.put("variable", "value");
        return "index";
    }

    @GetMapping()
    public String main() {
        return "main";
    }

}

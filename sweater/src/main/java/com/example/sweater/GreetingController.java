package com.example.sweater;

import com.example.sweater.entity.Message;
import com.example.sweater.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Контроллер, отвечает за получение данных от пользователя и возвращает ему ответ.
 */
@Controller
public class GreetingController {

    /**
     * This means to get the bean called userRepository
     * Which is auto-generated by Spring, we will use it to handle the data
     */
    @Autowired
    private MessageRepo messageRepo;

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

    /**
     * Map ONLY GET Requests
     * @param model
     * @return
     */
    @GetMapping()
    public @ResponseBody
    String main(Map<String, Object> model) {

        Iterable<Message> allMessage = messageRepo.findAll();
        model.put("Messages", allMessage);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message); // Сохраняем в репозиторий

        Iterable<Message> allMessage = messageRepo.findAll();
        model.put("messages", allMessage);

        return "main";
    }

    @PostMapping("filter")
    public String find(@RequestParam String filter, Map<String, Object> model) {
        List<Message> listMessages = messageRepo.findByTag(filter);

        model.put("messages", listMessages);
        return "main";
    }
}

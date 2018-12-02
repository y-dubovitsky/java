//package com.example.sweater;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.sweater.entity.*;
//import com.example.sweater.repo.*;
//
//import java.util.Map;
//
///**
// * This means that this class is a Controller
// */
//@Controller
///**
// * This means URL's start with /demo (after Application path)
// */
//@RequestMapping(path="/demo")
//public class MainController {
//    /**
//     * This means to get the bean called userRepository
//     * Which is auto-generated by Spring, we will use it to handle the data
//     */
//    @Autowired
//    private MessageRepo messageRepo;
//
//    /**
//     * Map ONLY GET Requests
//     * @param model
//     * @return
//     */
//    @GetMapping()
//    public @ResponseBody String main(Map<String, Object> model) {
//
//        Iterable<Message> allMessage = messageRepo.findAll();
//        model.put("Messages", allMessage);
//        return "main";
//    }
//
//    @PostMapping
//    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
//        Message message = new Message(text, tag);
//        messageRepo.save(message); // Сохраняем в репозиторий
//
//        Iterable<Message> allMessage = messageRepo.findAll();
//        model.put("Messages", allMessage);
//
//        return "main";
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//

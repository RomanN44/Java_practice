package com.example.practice.controller;

import com.example.practice.dao.ResourceDao;
import com.example.practice.service.HistoryService;
import com.example.practice.service.ResourceService;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Controller
public class ResourceController{
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryService historyService;

    @GetMapping("/resources")
    public String mainResources(Model model)
    {
        model.addAttribute("resources", resourceService.loadAllFreeResources());
        model.addAttribute("title", "Свободные записи:");
        return "resources";
    }

    @RequestMapping("/resource")
    public String bookingResources(@AuthenticationPrincipal User user,
                                   @RequestParam(value = "action") Long action, Model model)
    {
        resourceService.bookingResource(action, userService.getIdByLogin(user.getUsername()));
        model.addAttribute("resources", resourceService.loadAllFreeResources());
        model.addAttribute("title", "Свободные записи:");

        historyService.createRecord(userService.getIdByLogin(user.getUsername()), action, "booking");
        return "resources";
    }

    @GetMapping("/resources/my-resources")
    public String myResources(@AuthenticationPrincipal User user, Model model)
    {
        model.addAttribute("resources", resourceService.loadUsersResources(userService.getIdByLogin(user.getUsername())));
        model.addAttribute("title", "Ваши записи:");
        return "my-resources";
    }

    @RequestMapping("/resources/my-resources")
    public String deleteMyResources(@AuthenticationPrincipal User user,
                                   @RequestParam(value = "action") Long action, Model model)
    {
        resourceService.clearResource(action);
        model.addAttribute("resources", resourceService.loadUsersResources(userService.getIdByLogin(user.getUsername())));
        model.addAttribute("title", "Ваши записи:");

        historyService.createRecord(userService.getIdByLogin(user.getUsername()), action, "delete");
        return "my-resources";
    }

    @GetMapping(value = {"/resources/find-resources", "/resources/find-resources/find"})
    public String showFindResources(Model model)
    {
        model.addAttribute("resources", resourceService.loadAllFreeResources());
        model.addAttribute("title", "Найти записи:");
        return "find-resources";
    }

    @RequestMapping("/resource/find-resources")
    public String bookingFindResources(@AuthenticationPrincipal User user,
                                   @RequestParam(value = "action") Long action, Model model)
    {
        resourceService.bookingResource(action, userService.getIdByLogin(user.getUsername()));
        model.addAttribute("resources", resourceService.loadAllFreeResources());
        model.addAttribute("title", "Найти записи:");
        return "find-resources";
    }


    @RequestMapping("/resources/find-resources/find")
    public String findResources(@RequestParam(value = "first_name", required = false) String first_name,
                                @RequestParam(value = "second_name", required = false) String second_name,
                                @RequestParam(value = "specialty", required = false) String specialty,
                                Model model) throws ParseException {

        if(first_name.equals(""))
            first_name = "%%";
        if(second_name.equals(""))
            second_name = "%%";
        if(specialty.equals(""))
            specialty = "%%";

            model.addAttribute("resources", resourceService.findResource(first_name, second_name, specialty));
        model.addAttribute("title", "Ваши записи:");
        return "find-resources";
    }
}

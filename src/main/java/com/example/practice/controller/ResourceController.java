package com.example.practice.controller;

import com.example.practice.dao.ResourceDao;
import com.example.practice.service.ResourceService;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ResourceController{
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

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
        return "my-resources";
    }
}

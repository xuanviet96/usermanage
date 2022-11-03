package com.demo.usermanage.controller;

import com.demo.usermanage.entity.User;
import com.demo.usermanage.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("hello");
        model.addAttribute("message", "hello world");
        return "welcome";
    }

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("users", userService.findAll());
        System.out.println("Inside of block");
        return "list";
    }

//    @GetMapping("/list/search")
//    public String search(@RequestParam("term") String term, Model model) {
//        if (StringUtils.isEmpty(term)) {
//            return "redirect:/users/list";
//        }
//
//        model.addAttribute("user", userService.search(term));
//        return "list";
//    }

    @GetMapping("/list/add")
    public String add(Model model) {
        User user = new User();
        System.out.println(user);
        model.addAttribute("user", user);
        return "form";
    }

    @GetMapping("/list/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "form";
    }

    @PostMapping("/list/save")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirect) {
        System.out.println(user);
        System.out.println(result);
        System.out.println(result.hasErrors());
        if (result.hasErrors()) {
            System.out.println("Has error  !! ");
            return "form";
        }
//        User newUser = userService.save(user);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/users/list";
    }

    @GetMapping("/list/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        userService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/users/list";
    }



}
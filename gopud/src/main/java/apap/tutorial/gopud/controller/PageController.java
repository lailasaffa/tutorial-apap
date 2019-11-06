package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title","Tutorial APAP");
        model.addAttribute("listRole",roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

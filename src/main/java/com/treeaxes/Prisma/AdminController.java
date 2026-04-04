package com.treeaxes.Prisma;

import com.treeaxes.Prisma.Repository.UserRep;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private UserRep userRep;

    @GetMapping("/adminpanel")
    public String adminpanel(@RequestParam("username") String username, HttpSession session) {
        return "adminpanel";
    }

    @PostMapping("/makeadmin")
    public String makeadmin(@RequestParam("username") String username, HttpSession session) {
        return "index";
    }

}

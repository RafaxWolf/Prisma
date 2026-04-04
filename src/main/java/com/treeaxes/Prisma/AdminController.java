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

    @PostMapping("/getadmin")
    public String getAdmin() {
        return "redirect:/adminpanel";
    }

    @GetMapping("/adminpanel")
    public String getAdminPanel() {
        return "adminpanel";
    }

}

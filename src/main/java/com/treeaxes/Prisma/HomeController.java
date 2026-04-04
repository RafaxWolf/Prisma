package com.treeaxes.Prisma;

import com.treeaxes.Prisma.Repository.UserRep;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserRep userRep;

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("username") != null) {
            session.invalidate();
            System.out.println("Sesion cerrada por un error.");
        }

        return "index";
    }

}

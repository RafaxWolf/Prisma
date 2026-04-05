package com.treeaxes.Prisma;

import com.treeaxes.Prisma.Model.User;
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

    @PostMapping("/getadmin")
    public String getAdmin(HttpSession session) {

        User user = new User();

        if (session.getAttribute("username") == null) {
            System.out.println("[!] No se ha iniciado sesión. Redirigiendo al inicio.");
            return "redirect:/";
        }

        if (session.getAttribute("isAdmin") == "0") {
            System.out.println("el usuario " +  session.getAttribute("username") + " se convertira en administrador.");
            user.setIsAdmin(1);
            userRep.save(user);

            session.setAttribute("isAdmin", 1);

            /*System.out.println("[!] El usuario no tiene permisos de administrador. Redirigiendo al inicio.");
            return "redirect:/";*/
        }

        return "redirect:/adminpanel";
    }

    @GetMapping("/adminpanel")
    public String getAdminPanel(HttpSession session) {

        if (session.getAttribute("username") == null) {
            return "redirect:/";
        } else if (session.getAttribute("isAdmin") == "0"){
            System.out.println("[!] El usuario no tiene permisos de administrador. Redirigiendo al inicio.");
            return "redirect:/dashboard";
        }

        return "adminpanel";
    }

}

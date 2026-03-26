package com.treeaxes.Prisma;

import com.treeaxes.Prisma.Model.User;
import com.treeaxes.Prisma.Repository.UserRep;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserRep userRep;

    @PostMapping("/auth")
    public String auth(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        System.out.println();
        System.out.println("[Debug] Password: " + password);
        if (!userRep.existsByUsername(username)) {
            User user = new User();
            user.setUsername(username);
            userRep.save(user);
            System.out.println();

        } else {
            System.out.println("usuario ya existe prosiga mi rey\n");
        }

        session.setAttribute("username", username);

        System.out.println("usuario logeado: " + username);

        return "redirect:/dashboard";

    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        if (session.getAttribute("username") == null) {
            return "redirect:/";
        }

        return "dashboard";

    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        System.out.println("Cerro sessión el usuario " + session.getAttribute("username"));
        session.invalidate();

        return "redirect:/";

    }
}

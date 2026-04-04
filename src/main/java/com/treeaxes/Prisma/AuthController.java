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

    /*
    * Endpoint para autenticar a un usuario. Si el usuario no existe, se crea uno nuevo con el nombre de usuario proporcionado.
    * Nota de Wolf: a esta mierda le falta aún el sistema de contraseñas. Cuando se lo agreguemos ya nos habremos titulado.
    * */
    @PostMapping("/auth")
    public String auth(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

        if(username.isEmpty()) {
            System.out.println("[!] El usuario no puede estar vacío\n");
            return "redirect:/";
        }

        if(password.isEmpty()) {
            System.out.println("[!] Contraseña vacia. asignando contraseña por defecto");
            password = "Password";
        }


        User user = new User();

        System.out.println();
        System.out.println("[Debug] Password: " + password); // Muestra la contraseña solamente para que el backend no explote.

        // Verificador de usuario existente y de admin
        if (!userRep.existsByUsername(username)) {
            user.setUsername(username);
            userRep.save(user);
            System.out.println();

        } else {
            System.out.println("usuario ya existe prosiga mi rey\n");
        }

        /*
         * Settea en la sesión del usuario su nombre de usuario y si es admin o no.
         * (0 usuario normal / 1 usuario admin)
         *
         * Nota: el sistema de admins puede cambiar asi que esto no es definitivo
         * */
        int is_admin = user.getIsAdmin();
        session.setAttribute("username", username);
        session.setAttribute("isAdmin", is_admin);

        if (is_admin == 1) {
            System.out.println("administrador logueado: " + username);
        } else {
            System.out.println("usuario logueado: " + username);
        }

        return "redirect:/dashboard";

    }

    // Endpoint de la Dashboard / Menu principal
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        if (session.getAttribute("username") == null) {
            return "redirect:/";
        }

        return "dashboard";

    }

    // Endpoint de los errores
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    // Endpoint del logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        if (session.getAttribute("username") != null) {
            System.out.println("Cerro sessión el usuario " + session.getAttribute("username"));
            session.invalidate();
        }

        return "redirect:/";

    }
}

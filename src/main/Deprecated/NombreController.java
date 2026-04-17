package com.treeaxes.Prisma;


import com.treeaxes.Prisma.Utils.GetTimeNow;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NombreController {

    @PostMapping("/mandar_nombre")
    public String nombre(@RequestParam("nombre") String nombre){
        System.out.println("-------------");
        System.out.println("[" + GetTimeNow.getTime() + "] " + "recibido: " + nombre);
        System.out.println("--------------");
        return "redirect:/";
    }


}

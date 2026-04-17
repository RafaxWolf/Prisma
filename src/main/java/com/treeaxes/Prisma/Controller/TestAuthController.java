package com.treeaxes.prisma.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {


    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "hello - GET";
    }

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('POST') or hasAuthority('READ')")
    public String helloPost(){
        return "hello - POST";
    }

    @PutMapping("/update")
    public String helloUpdate(){
        return "hello - UPDATE";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "hello - DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch(){
        return "hello - PATCH";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ADMIN','DEVELOPER')")
    public String helloAdmin(){
        return "hello - ADMIN OR DEVELOPER";
    }

}

package com.example.Ejercicio5;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {
    @GetMapping("/user/{name}")
    public String getUsiario(@PathVariable String name){
        return "Hola "+name;
    }

    @PostMapping("/greeting")
    public Bienvenida getBienvenida(@RequestBody Bienvenida bien){
        return bien;
    }

    @PutMapping("/post")
    public String parametros(@RequestParam Map<String,String> parametros){
        return parametros.get("var1")+" "+parametros.get("var2");
    }

}

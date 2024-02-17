package br.com.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.models.Pessoa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;





@RestController // uma rota
public class Controller {

    
    @GetMapping("")
    public String mensagem(){

        return "Hello Wolrd";
    }
    
    @GetMapping("/bemVindo")
    public String boasVindas(){
        return "Seja bem vindo ";
    }
    
    
    @GetMapping("/bemVindo/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo " +  nome;
    }
    

    @PostMapping("/pessoa")
    
    public Pessoa pessoa(@RequestBody Pessoa p){
            return p;
    }
}

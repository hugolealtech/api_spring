package br.com.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.models.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class Controller {

    private final Repositorio repositorio;

    @Autowired
    public Controller(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("")
    public String mensagem() {
        return "Hello World";
    }

    @GetMapping("/bemVindo")
    public String boasVindas() {
        return "Seja bem-vindo ";
    }

    @GetMapping("/bemVindo/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem-vindo " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return repositorio.save(p);
    }
}

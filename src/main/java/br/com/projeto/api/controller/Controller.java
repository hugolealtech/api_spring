package br.com.projeto.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.models.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;
import br.com.projeto.api.servico.Servico;
import io.micrometer.common.lang.NonNull;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class Controller {



   @Autowired
   private Repositorio injetaDependencia;

   @Autowired
   private Servico servico;
    
   @PostMapping ("/api") 
   public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    @GetMapping ("/api")
    public List<Pessoa> Selecionar (){
       return injetaDependencia.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo (@PathVariable int codigo) {//SELECT * FROM PESSOA WHERE CODIGO = 1 POR EXEMPLO
        return injetaDependencia.findByCodigo(codigo);
    }
    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj){
    
        return injetaDependencia.save(obj);
    }

    @DeleteMapping ("/api/{codigo}")
    public void removerDado (@PathVariable int codigo){
        Pessoa obj = selecionarPeloCodigo (codigo);

        injetaDependencia.delete(obj);
    }

    @GetMapping("/api/contador")
    public long contador (){
        return injetaDependencia.count();
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNome(){
        return injetaDependencia.findByOrderByNomeDesc();
    }

     @GetMapping("/api/ordenaNomes2")
    public List<Pessoa> ordenaNomes2(){
        return injetaDependencia.findByNomeOrderByIdadeDesc("Hugo");

    }
    
    @GetMapping("/api/nomeContem")
    public List <Pessoa>  nomeContem() {
        return injetaDependencia.findByNomeContaining("hugo");//funciona como LIKE no mysql
    }

    @GetMapping("/api/iniciaCom")
    public List <Pessoa> iniciaCom() {
        return injetaDependencia.findByNomeStartsWith("Luz");
    }

    @GetMapping("/api/terminaCom")
    public List <Pessoa> terminaCom() {
        return injetaDependencia.findByNomeEndsWith("Oliveira");
    }

    @GetMapping("/api/somaIdades")
    public int somaIdades() {
        return injetaDependencia.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List <Pessoa> idadeMaiorIgual() {
        return injetaDependencia.idadeMaiorIgual(18);
    }
    /*@GetMapping("/statusAtual")
    public String statusAtual() {
        return "Configurando Status";//Mapping só para testes   
    }*/
    

    @GetMapping("/status")
    public ResponseEntity <String> status () {

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    

    
    
    
    
    
    


    //-----------------Teste API------------//

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

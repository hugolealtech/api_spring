package br.com.projeto.api.servico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.models.Mensagem;
import br.com.projeto.api.models.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio injetaDependencia;
//Método para cadastrar pessoas

    public ResponseEntity<?> cadastrar(Pessoa obj) {
        if (obj.getNome().isEmpty()) {
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

            } else if (obj.getSobrenome().isEmpty()) {
                mensagem.setMensagem("Por favor, informe seu sobrenome");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

            } else if (obj.getNumTelefone().isEmpty()){
                mensagem.setMensagem("Por favor, Informe seu Telefone");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

            } else if (obj.getIdade() <= 0 || obj.getIdade() >= 100) {
                mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

        } else {
            injetaDependencia.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        }
    }

    //Método para selecionar pessoas

    public ResponseEntity<?> selecionar (){
        return new ResponseEntity<>(injetaDependencia.findAll(),HttpStatus.OK);
    }

    //Metodo para selecionar pessoas pelo codigo

    public ResponseEntity<?> selecionarPeloCodigo (int codigo){
        if (injetaDependencia.countByCodigo(codigo) == 0){
            mensagem.setMensagem("Não foi encontrada nenhuma pessoa com esses parâmetros");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(injetaDependencia.findByCodigo(codigo),HttpStatus.OK);
        }
    }

    //Metodo para editar dados

    public ResponseEntity <?> editar (Pessoa obj){

        if(injetaDependencia.countByCodigo(obj.getCodigo()) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<> (mensagem, HttpStatus.NOT_FOUND);
        
        
            }else if (obj.getNome().equals("")){
                mensagem.setMensagem("É necessário informar um nome");
                return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);

            }else if(obj.getIdade() < 0 ||  obj.getIdade() > 130){
                mensagem.setMensagem("Por favor, forneça idade válida");
                return new ResponseEntity<> (mensagem,HttpStatus.BAD_REQUEST);

            }else if(obj.getSobrenome().equals("")){
                mensagem.setMensagem("Por favor insira seu sobrenome");
                return new ResponseEntity<> (mensagem,HttpStatus.BAD_REQUEST);

            }else if(obj.getCpf().isEmpty()){
                mensagem.setMensagem("Por favor, fornecer seu CPF");
                return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);

            } else if (obj.getNumTelefone().isEmpty()) {
                mensagem.setMensagem("Por favor, fornecer seu telefone");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            } else if (obj.getDataNascimento().isEmpty() || !isValidDate(obj.getDataNascimento())) {
                mensagem.setMensagem("Por favor, forneça uma data de nascimento válida no formato yyyy-MM-dd");//Nao esta funcionando ainda
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            } else {
                // Lógica de salvamento se todas as validações passarem
                injetaDependencia.save(obj);
                return new ResponseEntity<>(obj, HttpStatus.CREATED);
            }  
    }

    // Método para remover registros

    public ResponseEntity<?> remover (int codigo){
        if (injetaDependencia.countByCodigo(codigo) ==0){
            mensagem.setMensagem("O codigo informado não existe na base de dados");
            return new ResponseEntity<>(mensagem,HttpStatus.NOT_FOUND);
        }else{

            Pessoa obj = injetaDependencia.findByCodigo(codigo);
            injetaDependencia.delete(obj);

            mensagem.setMensagem("Cadastro removido com sucesso!");
            return new ResponseEntity<>(mensagem,HttpStatus.OK);
        }
        
    }
}
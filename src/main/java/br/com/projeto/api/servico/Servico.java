package br.com.projeto.api.servico;

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
}

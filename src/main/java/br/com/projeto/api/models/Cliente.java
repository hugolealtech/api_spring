package br.com.projeto.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


    @Entity
    @Table (name = "clientes")

    public class Cliente {


    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)


    private int codigo;
    @NotEmpty(message = "informe um nome")
    private String nome;
    @Email(message = "informe um e-mail válido")
    private String email;
   
   
    //Get e Set
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

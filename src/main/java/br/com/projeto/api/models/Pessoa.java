package br.com.projeto.api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    //Atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    private int codigo;
    private String nome;
    private String sobrenome;
    private int idade;
    private String cpf;
    private LocalDate dataNascimento;
    private String numTelefone;
   
    //-------------------------------------//
    //Get-Set codigo

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //-------------------------------------//
    //Get-Set  nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    //-------------------------------------//
    //Get-Set sobrenome
    
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    //-------------------------------------//
    //Get-Set idade

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
 //-------------------------------------//
    //Get-Set CFP

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    
    } 
    //-------------------------------------//
    //Get-Set Data de Nascimento

    public LocalDate getDataNascimento() {
            return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    //-------------------------------------//
    //Get-Set Numero de Telefone
    
     public String getNumTelefone() {
        return numTelefone;
    }
    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }
}

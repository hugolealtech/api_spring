
//Pacote
package br.com.projeto.api.repositorio;


//import org.hibernate.mapping.List;


//Importar CrudRepository e a anotation @Repository

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Importar o modelo
import br.com.projeto.api.models.Pessoa;

@Repository
public interface Repositorio  extends CrudRepository < Pessoa, Integer> {  //primeiro modelo Pessoa e o tipo de dado da chave primaria que tem que ser uma classe, ou integer

   @SuppressWarnings("null")
    java.util.List<Pessoa>findAll();
    Pessoa findByCodigo(int codigo);
    Pessoa findByNome (String nome);
    java.util.List<Pessoa> findByOrderByNomeDesc();
    java.util.List<Pessoa> findByNomeOrderByIdadeDesc(String idade);
   // int coucountByCodigo (int codigo);


}

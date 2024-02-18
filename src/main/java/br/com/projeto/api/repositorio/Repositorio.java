
//Pacote
package br.com.projeto.api.repositorio;


//Importar CrudRepository e a anotation @Repository

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Importar o modelo
import br.com.projeto.api.models.Pessoa;

@Repository
public interface Repositorio  extends CrudRepository < Pessoa, Integer> {

    
    
}

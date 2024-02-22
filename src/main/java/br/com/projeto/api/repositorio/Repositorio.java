package br.com.projeto.api.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.models.Pessoa;
import java.util.List;


@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {

    @SuppressWarnings("null")
   java.util.List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);

    Pessoa findByNome(String nome);

    java.util.List<Pessoa> findByOrderByNomeDesc();

    java.util.List<Pessoa> findByNomeOrderByIdadeDesc(String idade);

    java.util.List<Pessoa> findByNomeContaining(String termo);

    java.util.List<Pessoa> findByNomeStartsWith(String termo);

    java.util.List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM pessoa", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true)
java.util.List<Pessoa> idadeMaiorIgual(@Param("idade") int idade);

//int countByCodigo(findByCodigo(int codigo);)

    
}

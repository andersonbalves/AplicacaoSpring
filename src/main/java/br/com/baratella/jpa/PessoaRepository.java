package br.com.baratella.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.baratella.entity.Planta;

/**
 * 
 * Interface de repositório JPA para Pessoa
 * 
 * @author Anderson
 *
 */
@Transactional
@Repository
public interface PessoaRepository extends JpaRepository<Planta, Long> {
	@Query("SELECT p.id FROM Planta p WHERE p.nome = :nome")
	Long findIdByNome(@Param("nome") String nome);

	@Query("SELECT p.nome FROM Planta p WHERE p.id = :id")
	String findNomeById(@Param("id") Long id);
	
	@Query("SELECT COUNT(p)>0 FROM Planta p WHERE p.nome = :nome")
	boolean existByNome(@Param("nome") String nome);
	
	@Query("SELECT p FROM Planta p WHERE p.nome = :nome")
	Planta findByNome(@Param("nome") String nome);
}

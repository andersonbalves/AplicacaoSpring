/*
 * 
 */
package br.com.baratella.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.baratella.entity.Planta;

/**
 * Interface de repositório JPA para Planta.
 *
 * @author Anderson
 */
@Transactional
@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
	
	/**
	 * Retorna o id pelo nome.
	 *
	 * @param nome nome
	 * @return o id
	 */
	@Query("SELECT p.id FROM Planta p WHERE p.nome = :nome")
	Long findIdByNome(@Param("nome") String nome);

	/**
	 * Retorna o nome pelo id.
	 *
	 * @param id id
	 * @return  nome
	 */
	@Query("SELECT p.nome FROM Planta p WHERE p.id = :id")
	String findNomeById(@Param("id") Long id);
	
	/**
	 * Verifica se existe pelo nome.
	 *
	 * @param nome nome
	 * @return true, caso encontrado
	 */
	@Query("SELECT COUNT(p)>0 FROM Planta p WHERE p.nome = :nome")
	boolean existByNome(@Param("nome") String nome);
	
	/**
	 * Busca pelo nome.
	 *
	 * @param nome  nome
	 * @return  planta
	 */
	@Query("SELECT p FROM Planta p WHERE p.nome = :nome")
	Planta findByNome(@Param("nome") String nome);
}

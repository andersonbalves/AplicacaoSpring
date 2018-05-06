package br.com.baratella.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.baratella.entity.Pessoa;


/**
 * 
 * Interface de repositório JPA para Pessoa
 * 
 * @author Anderson
 *
 */
@Transactional
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

}

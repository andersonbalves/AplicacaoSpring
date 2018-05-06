package br.com.baratella.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.baratella.entity.Planta;
import br.com.baratella.jpa.PlantaRepository;

/**
 * Classe de test para o serviço planta
 * 
 * @author Anderson
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("junit")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PlantaServiceJPAImplTest {

	@Autowired
	private PlantaRepository repository;
	
	@Autowired
    private TestEntityManager entityManager;

	/**
	 * Método Construtor da Classe 
	 */
	public PlantaServiceJPAImplTest() {
	}
	
	/**
	 * Método: Teste para listar pessoas
	 * 
	 * @param pessoa
	 * @return
	 * @see IPlantaService
	 */
	@Test
	public void listarPlanta() {
		
		Planta planta = new Planta("Orquidea","Orchidaceae", new Date());
		entityManager.persist(planta);
		entityManager.flush();
		
		List<Planta> encontradas = repository.findAll();
		
		assertThat(encontradas.size() > 0);
		
	}

	/**
	 * Método: teste para buscar plantas
	 * 
	 * @param pessoa
	 * @return
	 * @see IPlantaService
	 */
	@Test
	public void buscarPlanta() {
		
		Planta planta = new Planta("Orquidea","Orchidaceae", new Date());
		entityManager.persist(planta);
		entityManager.flush();
		
		Planta encontrada = repository.findByNome(planta.getNome());
		
		assertThat(encontrada.getNome()).isEqualTo(planta.getNome());
		
	}
	

	/**
	 * Método: excluirPlanta
	 * Propósito: TEste para excluir plantas
	 */
	@Test
	public void excluirPlanta() {
		Planta planta = new Planta("Orquidea","Orchidaceae", new Date());
		entityManager.persist(planta);
		entityManager.flush();
		
		Planta encontrada = repository.findByNome(planta.getNome());
		assertThat(encontrada.getNome()).isEqualTo(planta.getNome());
		
		repository.deleteById(encontrada.getId());
		
		encontrada = repository.findByNome(planta.getNome());
		assertThat(encontrada == null);
	}

	/**
	 * Método: adicionarPlanta
	 * Propósito: Teste para adicionar plantas
	 */
	@Test
	public void adicionarPlanta() {
		Planta planta = new Planta("Orquidea","Orchidaceae", new Date());
		entityManager.persist(planta);
		entityManager.flush();
		
		Planta encontrada = repository.findByNome(planta.getNome());
		
		assertThat(encontrada.getNome()).isEqualTo(planta.getNome());
	}
	
	/**
	 * Método: adicionarPlantas
	 * Propósito: Teste para adicionar plantas
	 */
	@Test
	public void adicionarPlantas() {
		Planta[] plantas = {
				new Planta("Orquidea","Orchidaceae", new Date()),
				new Planta("Pinheiro","Pinus", new Date())};
		
		for (Planta planta : plantas) {
			entityManager.persist(planta);
			entityManager.flush();
			
			Planta encontrada = repository.findByNome(planta.getNome());
			
			assertThat(encontrada.getNome()).isEqualTo(planta.getNome());
		}
	}

}

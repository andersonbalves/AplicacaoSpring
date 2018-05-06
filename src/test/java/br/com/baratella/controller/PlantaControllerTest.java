package br.com.baratella.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.baratella.entity.Planta;
import br.com.baratella.service.IPlantaService;
import br.com.baratella.util.TestUtil;

/**
 * 
 * Classe de teste para o controller de planta
 * 
 * @author Anderson
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PlantaControllerTest {
	
	@MockBean
	private IPlantaService plantaService;
	
	@Autowired
    private MockMvc mockMvc;

	/**
	 * Método: adicionarPlanta
	 * Propósito: Controlador REST para adiciona uma planta
	 * @param planta
	 * @return
	 */
	@Test
	public void adicionarPlantaTest() throws Exception {
		Planta planta = new Planta("Orquidea","Orchidaceae", new Date());
		String json = TestUtil.objectToJson(planta);
		mockMvc.perform(post("/planta")
			.content(json)
			.contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
	}
	
	/**
	 * Método: adicionarPlantas
	 * Propósito: Controlador REST para adiciona plantas
	 * @param planta
	 * @return
	 */
	@Test
	public void adicionarPlantasTest() throws Exception {
		Planta[] plantas = {
				new Planta("Orquidea","Orchidaceae", new Date()),
				new Planta("Pinheiro","Pinus", new Date())};
		
		String json = TestUtil.objectToJson(plantas);
		mockMvc.perform(post("/plantas")
			.content(json)
			.contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
	}

	/**
	 * Método: listarPlantas Propósito: Conrolador REST para o verbo GET, Retorna as
	 * plantas cadastradas
	 * 
	 * @return
	 */
	@Test
	public void listarPlantasTest() throws Exception {
		mockMvc.perform(get("/plantas")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
	}

	/**
	 * Método: listarPlantas
	 * Propósito: Conrolador REST para o verbo GET, Retorna
	 * uma planta cadastrada
	 * 
	 * @return
	 */
	@Test
	public void buscarPlantaTest() throws Exception {
		mockMvc.perform(get("/planta/" + "Pinheiro")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
	}

	/**
	 * Método: excluirPlanta
	 * Propósito: Controlador REST para o verbo DELETE, deleta uma planta
	 * @param id
	 * @return
	 */
	@Test
	public void excluirPlantaTest() throws Exception {
		mockMvc.perform(delete("/planta/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));
	}
	
}

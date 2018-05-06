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
	
	Planta planta;

	@PostConstruct
	private void init() {
		planta = new Planta("Orquidea","Orchidaceae", new Date());
	}
	
	/**
	 * Método: adicionarPlanta
	 * Propósito: Controlador REST para adiciona uma planta
	 * @param planta
	 * @return
	 */
	@Test
	public void adicionarPlantaTest() throws Exception {
		mockMvc.perform(post("/planta")
			.content(getPlantaAsJson())
			.contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
	}

	/**
	 * Método: getPlantaAsJson
	 * Propósito: Retorna a planta em formato JSON
	 * @return
	 * @throws JsonProcessingException
	 */
	private String getPlantaAsJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(planta);
		return json;
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
		mockMvc.perform(get("/planta/" + planta.getNome())
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
                .andExpect(status().isOk())
                .andExpect(content().string(""));
	}
	
}

package br.com.baratella.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	/**
	 * Método: objectToJson
	 * Propósito: retorna um json de um objeto
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objectToJson(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(obj);
		return json;
	}
	
	/**
	 * Método: jsonToObject
	 * Propósito: Retorna um objeto de um json
	 * @param json
	 * @param classe
	 * @return
	 * @throws IOException
	 */
	public static <T> Object jsonToObject(String json, Class<T> classe) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Object obj = mapper.readValue(json, classe);
		return obj;
	}
	
}

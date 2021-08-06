package br.com.devschool.sistemaDocumentacao.aplication.controller.tela;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class TelaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void retorna200SeFizerBuscaCorretamenteERetornarConteudo() throws Exception {
		URI uri = new URI("/telas");
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.get(uri)
			).andExpect(
				MockMvcResultMatchers
				.status().is(200)
			);
	}
	
	@Test
	void retorna204SeFizerBuscaCorretamenteERetornarVazio() throws Exception {
		URI uri = new URI("/telas?idVersao=10");
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.get(uri)
			).andExpect(
				MockMvcResultMatchers
				.status().is(204)
			)
			.andDo(handler -> System.out.println(handler.getResponse()))
		;
	}
	
	
	@Test
	void retorna200SeAcaoDeleteExcutarCorretamente() throws Exception {
		// Tela 2 não tem eventos, entao delete deve funcionar
		URI uri = new URI("/telas/2");
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.delete(uri)
			).andExpect(
				MockMvcResultMatchers
				.status().is(200)
			);
	}
	
	@Test
	void retorna400SeAcaoDeleteFalha() throws Exception {
		// Tela 1 tem eventos relacionados a ela, entao delete deve falhar
		URI uri = new URI("/telas/1");
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.delete(uri)
			).andExpect(
				MockMvcResultMatchers
				.status().is(400)
			);
	}
	
	@Test
	void retorna500SeAcaoPostFalha() throws Exception {
		URI uri = new URI("/telas");
		// Não foi informado o nome da tela, espera-se um erro
		String json = "{\n    \"versao\": 1,\n    \"ordem\": 1,\n    \"dataCadastro\": \"2021-08-01\",\n    \"urlLog\": \"htto:urllog.com\",\n    \"situacao\": true,\n    \"imagem\": \"imagem da tela\"\n}";
		
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
			).andExpect(
				MockMvcResultMatchers
				.status().is(500)
			);
	}
	
	@Test
	void retorna200SeAcaoPutFuncionaCorretamente() throws Exception {
		URI uri = new URI("/telas/1");
		String json = "{\n    \"nomeTela\": \"Tela alterada\",\n    \"imagem\": \"imagem alterada\",\n    \"situacao\": false,\n    \"ordem\": 2,\n    \"urlLog\": \"url alterado\",\n    \"dataCadastro\": \"2021-08-03\"}";
		
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
			).andExpect(
				MockMvcResultMatchers
				.status().is(200)
			);
	}
	
	@Test
	void testaInserirUmaTelaComPai() throws Exception {
		URI uri = new URI("/telas");

		String json = "{\n    \"versao\": 1,\n    \"nomeTela\": \"tela A\",\n    \"ordem\": 1,\n    \"dataCadastro\": \"2021-08-01\",\n    \"urlLog\": \"htto:urllog.com\",\n    \"situacao\": true,\n    \"telaPai\": 1,\n    \"imagem\": \"imagem da tela\"\n}";
		
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
			).andExpect(
				MockMvcResultMatchers
				.status().is(200)
			);
	}
	
	@Test
	void testaInserirUmaTelaSemPai() throws Exception {
		URI uri = new URI("/telas");

		String json = "{\n    \"versao\": 1,\n    \"nomeTela\": \"tela A\",\n    \"ordem\": 1,\n    \"dataCadastro\": \"2021-08-01\",\n    \"urlLog\": \"htto:urllog.com\",\n    \"situacao\": true,\n    \"telaPai\": null,\n    \"imagem\": \"imagem da tela\"\n}";
		
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
			).andExpect(
				MockMvcResultMatchers
				.status().is(200)
			);
	}

}

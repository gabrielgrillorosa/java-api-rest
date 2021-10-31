package com.gabriel.lancamentos.api.integracao;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.test.annotation.DirtiesContext;

import com.gabriel.lancamentos.api.model.Pessoa;
import com.gabriel.lancamentos.api.repository.PessoaRepository;
import com.gabriel.lancamentos.api.utils.PessoaCreator;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class  PessoaResourceTestIT {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private PessoaRepository  pessoaRepository;

	final Logger logger = LoggerFactory.getLogger(PessoaResourceTestIT.class);	
	
	
	@Test
	@DisplayName("Salva uma pessoa")
	void lista_RetornaListaPessoas_CasoSucesso()
	{
		
		Pessoa pessoaSalvaPessoa = this.pessoaRepository.save(PessoaCreator.pessoaValidaParaSerSalva());		
		List<Pessoa> pessoas = testRestTemplate.exchange("/pessoas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Pessoa>>() {			
				}
		).getBody();
		
		Assertions.assertNotNull(pessoas);
		Assertions.assertTrue(!pessoas.isEmpty());
		Assertions.assertTrue(pessoas.size()>0);
		Assertions.assertTrue(pessoas.get(0).getCodigo() == pessoaSalvaPessoa.getCodigo());
			
	}
	

}

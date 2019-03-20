package test;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Cadeira;
import com.stefanini.projeto.model.Mesa;
import com.stefanini.projeto.resposta.Resposta;
import com.stefanini.projeto.service.CadeiraService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = CadeiraService.class)
@EnableAutoConfiguration
@ComponentScan({ "com.stefanini" })
@EnableJpaRepositories("com.stefanini.projeto.repository")
public class CadeiraRepositoryTest {

	@Autowired
	private CadeiraService cadeiraService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void salvarCadeira() throws TreinaException {
		Mesa mesa = new Mesa(null, "Romário Macedo");
		mesa.setCadeiras(new ArrayList<Cadeira>());
		Cadeira cadeira = new Cadeira(1L, "Teste Cadeira", mesa);

		// Criação com sucesso
		Resposta resposta = cadeiraService.save(cadeira);
		Assertions.assertThat(resposta.getCodigo()).isEqualTo(HttpStatus.CREATED.value());
		Assertions.assertThat(cadeira.getIdCadeira()).isNotNull();
		Assertions.assertThat(cadeira.getNome()).isEqualTo("Teste Cadeira");

		cadeira = cadeiraService.findById(1L);
		Assertions.assertThat(cadeira.getIdCadeira()).isNotNull();
		Assertions.assertThat(cadeira.getNome()).isEqualTo("Teste Cadeira");
	}

}

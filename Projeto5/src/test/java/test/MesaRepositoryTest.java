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
import com.stefanini.projeto.service.MesaService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = MesaService.class)
@EnableAutoConfiguration
@ComponentScan({ "com.stefanini" })
@EnableJpaRepositories("com.stefanini.projeto.repository")
public class MesaRepositoryTest {

	@Autowired
	private MesaService mesaService;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void saveMesa() throws TreinaException {
		Mesa mesa = new Mesa(null, "Romário Macedo");
		mesa.setCadeiras(new ArrayList<Cadeira>());

		Resposta resposta = mesaService.save(mesa);
		Assertions.assertThat(resposta.getCodigo()).isEqualTo(HttpStatus.CREATED.value());
		Assertions.assertThat(mesa.getIdMesa()).isNotNull();
		Assertions.assertThat(mesa.getNome()).isEqualTo("Romário Macedo");

		// Teste de update
		mesa.setNome("Teste Update");
		resposta = mesaService.save(mesa);
		Assertions.assertThat(resposta.getCodigo()).isEqualTo(HttpStatus.CREATED.value());

		mesa = mesaService.findById(1L);
		Assertions.assertThat(mesa.getIdMesa()).isNotNull();
		Assertions.assertThat(mesa.getNome()).isEqualTo("Teste Update");

		// Teste de veirificação do nome
		Mesa mesa1 = new Mesa(null, "Teste Update");
		mesa1.setCadeiras(new ArrayList<Cadeira>());
		resposta = mesaService.save(mesa1);
		Assertions.assertThat(resposta.getCodigo()).isEqualTo(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value());

	}

}

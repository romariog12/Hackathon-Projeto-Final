package test;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stefanini.projeto.controller.MesaController;
import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Cadeira;
import com.stefanini.projeto.model.Mesa;
import com.stefanini.projeto.resposta.Resposta;
import com.stefanini.projeto.resposta.RespostaEnum;
import com.stefanini.projeto.resposta.RespostaUtil;
import com.stefanini.projeto.service.MesaService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=MesaController.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class MesaControllerTest {
	
	@Autowired
	TestRestTemplate testeRestTemplate;
	@MockBean
	private MesaService mesaService;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	public static Mesa mockMesa() {
		Mesa mesa = new Mesa(null, "Romário Macedo");
		mesa.setCadeiras(new ArrayList<Cadeira>());
		return mesa;
	}
	@Test
	public void save() throws TreinaException {
		
		BDDMockito.when(mesaService.save(mockMesa())).thenReturn(RespostaUtil.mensagem(RespostaEnum.SAVE));
		ResponseEntity<Resposta> r = testeRestTemplate.exchange("/mesa", HttpMethod.POST, new HttpEntity<Mesa>(mockMesa()), Resposta.class);
		Assertions.assertThat(r.getStatusCode().value()).isEqualTo(201);
	}

	@Test
	public void edit() throws TreinaException {
		Mesa mesa = new Mesa(1L, "Romário Macedo Update");
		mesa.setCadeiras(new ArrayList<Cadeira>());
		
		BDDMockito.when(mesaService.save(mesa)).thenReturn(RespostaUtil.mensagem(RespostaEnum.SAVE));
		ResponseEntity<Resposta> r = testeRestTemplate.exchange("/mesa", HttpMethod.PUT, new HttpEntity<Mesa>(mesa), Resposta.class);
		Assertions.assertThat(r.getStatusCode().value()).isEqualTo(201);
	}
	
}

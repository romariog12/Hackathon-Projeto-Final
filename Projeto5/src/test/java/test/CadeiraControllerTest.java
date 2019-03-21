package test;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stefanini.projeto.controller.CadeiraController;
import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Cadeira;
import com.stefanini.projeto.resposta.Resposta;
import com.stefanini.projeto.resposta.RespostaEnum;
import com.stefanini.projeto.resposta.RespostaUtil;
import com.stefanini.projeto.service.CadeiraService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes=CadeiraController.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class CadeiraControllerTest {

	@Autowired
	TestRestTemplate testeRestTemplate;
	@MockBean
	CadeiraService cadeiraService;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	public static Cadeira mockCadeira() {
		MesaControllerTest.mockMesa().setIdMesa(1L);
		Cadeira cadeira = new Cadeira(null,"Teste",MesaControllerTest.mockMesa());
		return cadeira;
	}
	@Test
	public void save() throws TreinaException {
		BDDMockito.when(cadeiraService.save(mockCadeira())).thenReturn(RespostaUtil.mensagem(RespostaEnum.SAVE));
		ResponseEntity<Resposta> r = testeRestTemplate.exchange("/mesa/cadeira",HttpMethod.POST, new HttpEntity<Cadeira>(mockCadeira()), Resposta.class);
		Assertions.assertThat(r.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
}

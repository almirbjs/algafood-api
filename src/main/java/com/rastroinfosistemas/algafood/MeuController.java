package com.rastroinfosistemas.algafood;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rastroinfosistemas.algafood.di.modelo.Cliente;
import com.rastroinfosistemas.algafood.di.services.AtivacaoClienteService;
import org.springframework.stereotype.Controller;

/*TODO @Controller responsavel por receber requisicoes Web
 @getMapping informa o caminho pra chegar na resposta
@ ResponseBody solicita a devolução da resposta para uma requisição
Para acessar a pagina na maquina local utilizamos: http://localhost:8080/hello
@Primary é utilizado para desambiguação de bean
@Qualifier(SMS) é usado para desambiguação de bean por nomeanção de Bean
*/

@Controller
public class MeuController {
	

	private AtivacaoClienteService ativacaoClienteService;

	public MeuController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888",true);

		ativacaoClienteService.ativar(joao);

		return "Hello!";
	}

}

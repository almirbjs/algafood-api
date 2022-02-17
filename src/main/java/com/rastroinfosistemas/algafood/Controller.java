package com.rastroinfosistemas.algafood;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rastroinfosistemas.algafood.di.modelo.Cliente;
import com.rastroinfosistemas.algafood.di.services.AtivacaoClienteService;


//TODO @Controller responsavel por receber requisicoes Web
@org.springframework.stereotype.Controller
public class Controller {
	private AtivacaoClienteService ativacaoClienteService;
	
	
	public Controller(AtivacaoClienteService ativacaoClienteService) {
		super();
		this.ativacaoClienteService = ativacaoClienteService;
		System.out.println("Controller" + ativacaoClienteService);
	}


	/*@getMapping informa o caminho pra chegar na resposta
	@ ResponseBody solicita a devolução da resposta para uma requisição
	Para acessar a pagina na maquina local utilizamos: http://localhost:8080/hello
	*/
	@GetMapping("/hello")
	@ResponseBody
	private String hello() {
		Cliente maria = new Cliente("Maria", "jo@gmail.com", "32356487", true);
		ativacaoClienteService.ativar(maria);
		return "Hello";
		

	}

}

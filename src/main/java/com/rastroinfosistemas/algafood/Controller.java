package com.rastroinfosistemas.algafood;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller responsavel por receber requisicoes Web
@org.springframework.stereotype.Controller
public class Controller {
	
	/*@getMapping informa o caminho pra chegar na resposta
	@ ResponseBody solicita a devolução da resposta para uma requisição
	Para acessar a pagina na maquina local utilizamos: http://localhost:8080/hello
	*/
	@GetMapping("/hello")
	@ResponseBody
	private String hello() {
		return "Hello";
		

	}

}

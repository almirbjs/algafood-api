package com.rastroinfosistemas.algafood.di.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rastroinfosistemas.algafood.di.modelo.Cliente;
import com.rastroinfosistemas.algafood.di.nodificador.Notificador;
import com.rastroinfosistemas.algafood.di.nodificador.NotificadorEmail;

/*TODO @Component informa que é uma classe Bean e que deve ser gerenciada pelo Spring
 * Ficar um Notificador é bem mais facil do que ter NotificarEmail ou
 * NotificadorSMS ou seja xriar uma interface para diminuir o acoplamento
 * Uma das maneiras de fazer injeção de depencias é pelo construtor
 * @Autowired usamos quando á mais de um construtor e para indentificar qual é o cosntrutor principal
 * @Autowired(required = false) caso tenha uma dependencia obrigatoria.

 */
@Component
public class AtivacaoClienteService {

	@Autowired(required = false)
	private List<Notificador> notificadores;

	public void ativar(Cliente cliente) {
		cliente.isAtivo();
		
		for (Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Cadastro Ativado!");
			
		}
	}

}

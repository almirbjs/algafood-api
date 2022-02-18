package com.rastroinfosistemas.algafood.di.services;

import org.springframework.stereotype.Component;

import com.rastroinfosistemas.algafood.di.modelo.Cliente;
import com.rastroinfosistemas.algafood.di.nodificador.Notificador;
import com.rastroinfosistemas.algafood.di.nodificador.NotificadorEmail;

//TODO @Component informa que é uma classe Bean e que deve ser gerenciada pelo Spring
@Component
public class AtivacaoClienteService {
	/*
	 * Ficar um Notificador é bem mais facil do que ter NotificarEmail ou
	 * NotificadorSMS ou seja xriar uma interface para diminuir o acoplamento
	 */
	Notificador notificador;

//TODO Uma das maneiras de fazer injeção de depencias é pelo construtor;
	public AtivacaoClienteService(NotificadorEmail notificador) {
		this.notificador = notificador;

		System.out.println("Ativação do Servico: " + notificador);
	}

	public void ativar(Cliente cliente) {
		cliente.isAtivo();
		notificador.notificar(cliente, "Seu Cadastro esta ativo!'");
	}

}

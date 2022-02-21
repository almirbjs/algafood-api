package com.rastroinfosistemas.algafood.di.services;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.rastroinfosistemas.algafood.di.modelo.Cliente;
import com.rastroinfosistemas.algafood.di.notificador.NivelUrgencia;
import com.rastroinfosistemas.algafood.di.notificador.Notificador;
import com.rastroinfosistemas.algafood.di.notificador.NotificadorEmail;
import com.rastroinfosistemas.algafood.di.notificador.TipoDoNotificador;

/*TODO @Component informa que é uma classe Bean e que deve ser gerenciada pelo Spring
 * Ficar um Notificador é bem mais facil do que ter NotificarEmail ou
 * NotificadorSMS ou seja criar uma interface para diminuir o acoplamento
 * Uma das maneiras de fazer injeção de depencias é pelo construtor
 * @Autowired usamos quando á mais de um construtor e para indentificar qual é o cosntrutor principal
 * @Autowired(required = false) caso tenha uma dependencia obrigatoria.
 * @Primary é utilizado para desambiguação de bean
 * @PostConstruct fase inicial do Bean
 * @PreDestroy -mostra o destroy quando a aplicação e parada.
 * private ApplicationEventPublisher publica um evento 
 */

@Component
public class AtivacaoClienteService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Qualifier
	private Notificador notificador=new Notificador() {
		
		@Override
		public void notificar(Cliente cliente, String mensagem) {
			// TODO Auto-generated method stub
			
		}
	};

	@PostConstruct
	public void init() {
		System.out.println("INIT" + notificador);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	public void ativar(Cliente cliente) {
		cliente.isAtivo();

		// Dizer para o container que o cliente está ativo neste momento
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
	}
}
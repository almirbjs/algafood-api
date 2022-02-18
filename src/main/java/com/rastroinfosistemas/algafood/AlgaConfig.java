package com.rastroinfosistemas.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rastroinfosistemas.algafood.di.nodificador.NotificadorEmail;
import com.rastroinfosistemas.algafood.di.services.AtivacaoClienteService;

/*TODO @Configuration define os beans
 * @Bean configura e estancia um novo objeto pelo contrains Spring */

@Configuration
public class AlgaConfig {

	@Bean
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificadorEmail = new NotificadorEmail();
		notificadorEmail.setCaixaAlta(true);
		return notificadorEmail;
	}

	
}

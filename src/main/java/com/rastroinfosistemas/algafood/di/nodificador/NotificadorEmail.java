package com.rastroinfosistemas.algafood.di.nodificador;

import org.springframework.beans.factory.annotation.Qualifier;

import com.rastroinfosistemas.algafood.di.modelo.Cliente;

/*TODO @Component informa que é uma classe Bean e que deve ser gerenciada pelo Spring*/

@Qualifier("urgente")
public class NotificadorEmail implements Notificador {

	private boolean caixaAlta;

	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.printf("notificado %s atraves do email %s: %s \n", cliente.getNome(), cliente.getEmail(),
				mensagem);
	}

	

	public boolean isCaixaAlta() {
		return caixaAlta;
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

}

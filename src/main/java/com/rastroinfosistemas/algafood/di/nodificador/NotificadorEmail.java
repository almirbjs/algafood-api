package com.rastroinfosistemas.algafood.di.nodificador;

import com.rastroinfosistemas.algafood.di.modelo.Cliente;

//TODO @Component informa que é uma classe Bean e que deve ser gerenciada pelo Spring

public class NotificadorEmail implements Notificador {

	private boolean caixaAlta;
	private String hostServidorSmtp="Smtp";

	public NotificadorEmail(String hostServidorSmtp) {
		System.out.println("Notificador Email");
	}

	

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if (this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		System.out.printf("notificado %s atraves do email %s: %s %s \n", cliente.getNome(), cliente.getEmail(),
				this.hostServidorSmtp, mensagem);
	}

	
	
	public boolean isCaixaAlta() {
		return caixaAlta;
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}

}

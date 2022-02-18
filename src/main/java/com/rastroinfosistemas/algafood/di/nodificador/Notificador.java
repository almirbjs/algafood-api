package com.rastroinfosistemas.algafood.di.nodificador;

import com.rastroinfosistemas.algafood.di.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);
	
}

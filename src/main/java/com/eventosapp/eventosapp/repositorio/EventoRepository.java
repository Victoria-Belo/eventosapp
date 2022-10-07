package com.eventosapp.eventosapp.repositorio;
import org.springframework.data.repository.CrudRepository;

import com.eventosapp.eventosapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {

	
	//Esta Interface salva dados no BD criado! Aqui ficam as interfaces do repositório de evento
	
	Evento findByCod(long cod);
	
}

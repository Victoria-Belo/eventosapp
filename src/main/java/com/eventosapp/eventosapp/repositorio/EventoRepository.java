package com.eventosapp.eventosapp.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eventosapp.eventosapp.models.Convidado;
import com.eventosapp.eventosapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {

	
	//Esta Interface salva dados no BD criado! Aqui ficam as interfaces do repositório de evento
	
	Evento findByCod(long cod);	
	
	
	
	

}

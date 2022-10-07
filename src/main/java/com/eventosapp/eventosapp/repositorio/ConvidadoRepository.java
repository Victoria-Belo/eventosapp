package com.eventosapp.eventosapp.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.eventosapp.eventosapp.models.Convidado;
import  com.eventosapp.eventosapp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	
	Iterable<Convidado> findByEvento(Evento evento);

	Convidado findByRg(String rg);

	Convidado findById(long id);
}

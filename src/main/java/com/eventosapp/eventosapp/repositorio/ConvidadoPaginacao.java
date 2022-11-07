package com.eventosapp.eventosapp.repositorio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eventosapp.eventosapp.models.Convidado;
import com.eventosapp.eventosapp.models.Evento;


public interface ConvidadoPaginacao extends JpaRepository<Convidado, Long>{
		
	
	Page<Convidado> findByEvento(Evento evento, Pageable pageable);

	Convidado findByRg(String rg);

	Convidado findById(long id);		
	
	
}
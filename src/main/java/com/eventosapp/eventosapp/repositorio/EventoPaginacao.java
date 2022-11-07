package com.eventosapp.eventosapp.repositorio;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eventosapp.eventosapp.models.Evento;

public interface EventoPaginacao extends JpaRepository<Evento, Long>{
	
	Evento findByNome(String nome);	
	
}
package com.eventosapp.eventosapp.repositorio;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eventosapp.eventosapp.models.Convidado;
import com.eventosapp.eventosapp.models.Evento;
=======

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventosapp.eventosapp.models.Convidado;
>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6


public interface ConvidadoPaginacao extends JpaRepository<Convidado, Long>{
		
	
<<<<<<< HEAD
	Page<Convidado> findByEvento(Evento evento, Pageable pageable);

	Convidado findByRg(String rg);

	Convidado findById(long id);		
	
=======
	


>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
	
}
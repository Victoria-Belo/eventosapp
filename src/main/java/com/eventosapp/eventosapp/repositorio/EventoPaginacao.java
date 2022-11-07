package com.eventosapp.eventosapp.repositorio;

<<<<<<< HEAD
import org.springframework.data.domain.PageRequest;
=======
>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
import org.springframework.data.jpa.repository.JpaRepository;
import com.eventosapp.eventosapp.models.Evento;

public interface EventoPaginacao extends JpaRepository<Evento, Long>{
	
<<<<<<< HEAD
	Evento findByNome(String nome);	
=======
	Evento findByNome(String nome);
>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
	
}
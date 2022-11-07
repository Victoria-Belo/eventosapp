package com.eventosapp.eventosapp.repositorio;
<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eventosapp.eventosapp.models.Convidado;
=======
import org.springframework.data.repository.CrudRepository;

>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
import com.eventosapp.eventosapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String> {

	
	//Esta Interface salva dados no BD criado! Aqui ficam as interfaces do repositório de evento
	
<<<<<<< HEAD
	Evento findByCod(long cod);	
	
	
	
	

=======
	Evento findByCod(long cod);
	
>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
}

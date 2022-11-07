package com.eventosapp.eventosapp.repositorio;

<<<<<<< HEAD
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

=======
import org.springframework.data.repository.CrudRepository;
>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
import com.eventosapp.eventosapp.models.Convidado;
import  com.eventosapp.eventosapp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	
	Iterable<Convidado> findByEvento(Evento evento);

<<<<<<< HEAD
	Convidado findByRg(String rg);	

	Convidado findById(long id);		
	
	

	

	

	
	
=======
	Convidado findByRg(String rg);

	Convidado findById(long id);
>>>>>>> acf81d209420b7b96300f3b06547106dbf2780c6
}

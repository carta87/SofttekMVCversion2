
package Persistencia;

import java.util.List;
import Entities.Profesores;

public interface FachadaPersistenciaProfesorLocal {

	void create(Profesores profesor);
	void edit(Profesores profesor);
	void find(Object object); //no implementado
	List<Profesores> findAll();
	Profesores findByIdProfesor(String idProfesor);
	void remove(Profesores profesor); 
}


package Persistencia;

import java.util.List;

import Entities.Grupo;


public interface FachadaPersistenciaGrupoLocal {
	void create(Grupo grupo);
	void edit(Grupo grupo);
	void find(Object object);
	List<Grupo > findAll();
	Grupo findIdByGrupo(String  idGrupo);
	void remove(Grupo grupo); 

}

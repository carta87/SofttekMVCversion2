
package Persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Grupo;
import Entities.Profesores;

public class FachadaPersistenciaGrupo implements FachadaPersistenciaGrupoLocal {

	private static EntityManagerFactory emf;
	Grupo grupo;

	EntityManager entity = getEntityManagerFactory().createEntityManager();

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("Persistencia");
		}
		return emf;
	}

	@Override
	public void create(Grupo grupo) {
		entity.getTransaction().begin();
		entity.persist(grupo);
		entity.getTransaction().commit();
	}

	@Override
	public void edit(Grupo grupo) {
		Grupo grupoRecover = entity.find(Grupo.class, grupo.getId());
		if (grupoRecover != null) { // Encontro
			entity.getTransaction().begin();
			entity.merge(grupo);
			entity.getTransaction().commit();
			System.out.println(grupoRecover.toString());
			System.out.println("actualizo");
		} else {
			System.out.println("grupo no encontrado");
		}

	}

	@Override
	public void find(Object object) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findAll() {
		System.out.println("entra al findAll");
		List<Grupo> grupoRecover = (List<Grupo>) entity.createQuery("FROM Grupo").getResultList();
		System.out.println("despues del findAll");
		return grupoRecover;
	}

	@Override
	public Grupo findIdByGrupo(String idGrupo) {
		grupo = entity.find(Grupo.class, idGrupo);
		System.out.println("datos Grupo" + grupo);
		return grupo;
	}

	@Override
	public void remove(Grupo grupo) {
		Grupo grupoRecover = entity.find(Grupo.class, grupo.getId());
		System.out.println("dentro de Eliminar");
		if (grupoRecover != null) {
			System.out.println(grupo.toString());
			entity.getTransaction().begin();
			entity.remove(grupoRecover);
			entity.getTransaction().commit();
			System.out.println("grupo  eliminado...");
		} else {
			System.out.println("grupo no encontrado...");
		}
	}
	public static void main(String[] args) {
		FachadaPersistenciaGrupo uso = new FachadaPersistenciaGrupo();
		 
		 Grupo grupo1 = new Grupo();
		 grupo1.setAsignatura("historia");
		// grupo1.setId("1");
		// grupo1.setIdEstudiante("1");
		// grupo1.setIdProfesor("1");
		 
		 
	
		System.out.println(grupo1.toString());
		 
		//uso.create(grupo1); 
		//uso.edit(grupo1); 

		 /*
		 List<Grupo> lista = uso.findAll(); 
		 for (Grupo e : lista ) {
			 System.out.println(e);
		 }*/
		 
		//uso.findIdByGrupo("2");
	    //uso.remove(grupo1);
		 
		//System.out.println("Estudiante a actualizar " + esttudiante1.getId()   ); 
		 //uso.edit(esttudiante1);
		 
		
			
	}

}


package Persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import Entities.Estudiantes;
import Entities.Profesores;

public class FachadaPersistenciaProfesor implements FachadaPersistenciaProfesorLocal {
	
	//@PersistenceUnit(unitName = "Persistencia")
	private static EntityManagerFactory emf; 
	Profesores profesor;
	
	EntityManager entity = getEntityManagerFactory().createEntityManager();
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf==null) {
			emf=Persistence.createEntityManagerFactory("Persistencia");
		}
		return emf;				
	} 
	
	@Override
	public void create(Profesores profesor) {
		entity.getTransaction().begin();
		entity.persist(profesor);
		entity.getTransaction().commit();			
	}

	@Override
	public void edit(Profesores profesor) {
		Profesores profesorRecover = entity.find(Profesores.class, profesor.getId());
		if (profesorRecover != null) {  //Encontro
			entity.getTransaction().begin();
			entity.merge(profesor);
			entity.getTransaction().commit();
			System.out.println(profesorRecover.toString());
			System.out.println("actualizo");
		} else {  
			System.out.println("Profesor no encontrado");
		}
	}


	@Override
	public void find(Object object) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesores> findAll() {
		System.out.println("entra al findAll");
		List<Profesores> profesoresRecover= (List<Profesores>) entity.createQuery("FROM Profesores").getResultList();
		System.out.println("despues del findAll");
		return profesoresRecover;
	}

	@Override
	public Profesores findByIdProfesor(String idProfesor) {
		profesor = entity.find(Profesores.class, idProfesor);
		System.out.println("datos Estudiante" + profesor);
		return profesor;
	}

	@Override
	public void remove(Profesores profesor) {
		Profesores profesorRecover = entity.find(Profesores.class, profesor.getId());
		System.out.println("dentro de Eliminar");
		if (profesorRecover != null) {
			System.out.println(profesor.toString());
			entity.getTransaction().begin();
			entity.remove(profesorRecover);
			entity.getTransaction().commit(); 
			System.out.println("estudiante  eliminado...");
		} else {
			System.out.println("Estudiante no encontrado...");
		}
	}
	
	public static void main(String[] args) {
		FachadaPersistenciaProfesor uso = new FachadaPersistenciaProfesor();
		 
		 Profesores profesor1 = new Profesores();
		 profesor1.setId("23");
		// profesor1.setGrupo(66);
		 profesor1.setNivel(33);
	
		 System.out.println(profesor1.toString());
		 
		//uso.create( profesor1); 
		//uso.edit(profesor1);

		 /*
		 List<Profesores> lista = uso.findAll();
		 for (Profesores e : lista ) {
			 System.out.println(e);
		 }*/
		 
		//uso.findByIdProfesor("3");
		uso.remove(profesor1);
		 
		//System.out.println("Estudiante a actualizar " + esttudiante1.getId()   ); 
		 //uso.edit(esttudiante1);
		 
		
			
	}

}


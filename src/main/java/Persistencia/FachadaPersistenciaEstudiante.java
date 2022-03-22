package Persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlTransient;

import Entities.Estudiantes;
import Entities.Usuarios;

public class FachadaPersistenciaEstudiante implements FachadaPersistenciaEstudianteLocal {
	
	//@PersistenceContext(unitName = "Persistencia")	
	private static EntityManagerFactory emf;
	Estudiantes estudiantes;
	 
	EntityManager entity = getEntityManagerFactory().createEntityManager();
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf==null) {
			emf=Persistence.createEntityManagerFactory("Persistencia");
		}
		return emf;				
	}  
	
	public static void shutdown() {
		if (emf!=null) {
			emf.close();
		}		
	}

	@Override
	public void create(Estudiantes estudiante) {
		entity.getTransaction().begin();
		entity.persist(estudiante);
		entity.getTransaction().commit();			
	}

	@Override
	public void edit(Estudiantes estudiante) {
		Estudiantes estudianteRecover = entity.find(Estudiantes.class, estudiante.getId());
		if (estudianteRecover != null) {  //Encontro
			entity.getTransaction().begin();
			entity.merge(estudiante);
			entity.getTransaction().commit();
			System.out.println(estudianteRecover.toString());
			System.out.println("actualizo");
		} else { //no lo encontro
			System.out.println("Estudiante no encontrado");
		}
    				
	}

	@SuppressWarnings("unchecked")
	@Override
	public void find(Object object) {		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiantes> findAll() { 
		System.out.println("entra al findAll");
		List<Estudiantes> estudiantesRecover= (List<Estudiantes> ) entity.createQuery("FROM Estudiantes").getResultList();
		System.out.println("despues del findAll"); 
		return estudiantesRecover;
	}

	@Override
	public Estudiantes findByIdEstudiante(String idEstudiante) {
		estudiantes = entity.find(Estudiantes.class, idEstudiante);
		System.out.println("datos Estudiante" + estudiantes);
		return estudiantes;
	}

	@Override
	public void remove(Estudiantes estudiante) {
		Estudiantes estudianteRecover = entity.find(Estudiantes.class, estudiante.getId());
		System.out.println("dentro de Eliminar");
		if (estudianteRecover != null) {
			System.out.println(estudiante.toString());
			entity.getTransaction().begin();
			entity.remove(estudianteRecover);
			entity.getTransaction().commit(); 
			System.out.println("estudiante  eliminado...");
		} else {
			System.out.println("Estudiante no encontrado...");
		}
	}
	
	
	public static void main(String[] args) {
		
		 FachadaPersistenciaEstudiante uso = new FachadaPersistenciaEstudiante();
		 
		 Estudiantes estudiante1 = new Estudiantes();
		// esttudiante1.setId("23");
		 //esttudiante1.setCodigo(2999900);
		 //esttudiante1.setGrupo(2);
		 
		 //System.out.println(esttudiante1.toString());
		 
		
		//uso.create(esttudiante1);
		
		//uso.findByIdEstudiante("");
		//uso.remove(esttudiante1);
		 
		//System.out.println("Estudiante a actualizar " + esttudiante1.getId()   ); 
		 //uso.edit(esttudiante1);
		 
		 List<Estudiantes> lista = uso.findAll();
		 for (Estudiantes e : lista ) {
			 System.out.println(e);
			
		}

		 
	
		
	}

}
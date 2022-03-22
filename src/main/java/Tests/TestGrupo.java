package Tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Grupo;
import Entities.Profesores;


public class TestGrupo {
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();

		imprimir();
	} 
	
	@SuppressWarnings("unchecked")
	private static void imprimir() {
		List<Grupo> listGrupos = (List<Grupo>) manager.createQuery("from Grupo").getResultList();
		System.out.println("En esta base de datos hay "+ listGrupos.size()+ " grupos");
		
		for (Grupo grupo : listGrupos) {
			System.out.println(grupo);
		}
	}


}

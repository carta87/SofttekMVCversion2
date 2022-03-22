package Tests;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Estudiantes;

public class TestEstudiante {
	
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
		List<Estudiantes> listEstudiante = (List<Estudiantes>) manager.createQuery("from Estudiantes").getResultList();
		System.out.println("En esta base de datos hay "+ listEstudiante.size()+ " estudiantes");
		
		for (Estudiantes estudiantes : listEstudiante) {
			System.out.println(estudiantes.toString());   
		}
	}
}

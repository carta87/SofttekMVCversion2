package Tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Estudiantes;
import Entities.Profesores;

public class TestProfesores {

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
			List<Profesores> ListProfesores = (List<Profesores>) manager.createQuery("from Profesores").getResultList();
			System.out.println("En esta base de datos hay "+ ListProfesores.size()+ " profesores");
			
			for (Profesores profesores : ListProfesores) {
				System.out.println(profesores);
			}
		}

}

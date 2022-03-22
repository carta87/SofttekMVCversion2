package Tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.Profesores;
import Entities.Usuarios;


public class TestUsuarios {
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
		List<Usuarios> listUsuarios = (List<Usuarios>) manager.createQuery("from Usuarios").getResultList();
		System.out.println("En esta base de datos hay "+ listUsuarios.size()+ " usuarios");
		
		for (Usuarios usuario : listUsuarios) {
			System.out.println(usuario);
		}
	}

}

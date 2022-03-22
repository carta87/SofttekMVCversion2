package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Entities.Profesores;
import Persistencia.FachadaPersistenciaEstudiante;

public class MainProfesores {
 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Profesores profesores;
		

		//EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		EntityManager entity = FachadaPersistenciaEstudiante.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear profesor");
			System.out.println("2. Buscar profesor");
			System.out.println("3. Actualizar profesor");
			System.out.println("4. Eliminar profesor");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			profesores = new Profesores();
			
			switch (opcion) {
			case 1:
				scanner.nextLine();
				System.out.println("Digite el ID del profesor:");
				profesores.setId(scanner.nextLine());
				
				System.out.println("Digite el grupo del profesor:");
				//profesores.setGrupo(scanner.nextInt());
				
				System.out.println("Digite el nivel del profesor:");
				profesores.setNivel(scanner.nextInt());
								
				System.out.println(profesores.toString());
				
				entity.getTransaction().begin();
				entity.persist(profesores);
				entity.getTransaction().commit();
				System.out.println("profesor registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del profesores a buscar:");
				profesores = entity.find(Profesores.class, scanner.next());
				if (profesores != null) {
					System.out.println(profesores.toString());
					System.out.println();
				} else {
					System.out.println();
					System.out.println("profesores no encontrado... Esta es la lista completa de profesores");
					
					
					List<Profesores> profesoresRecover= (List<Profesores> ) entity.createQuery("FROM Profesores").getResultList();
					for (Profesores e : profesoresRecover) {
						System.out.println(e);
					}
					
					System.out.println();
				}
				break;
				
			case 3:
				System.out.println("Digite el id del profesor a actualizar:");

				profesores = entity.find(Profesores.class, scanner.next());
				if (profesores != null) {  //Encontro
										
					scanner.nextLine();						
					System.out.println("Digite el grupo del profesor:");
					//profesores.setGrupo(scanner.nextInt());
					
					System.out.println("Digite el nivel del profesor:");
					profesores.setNivel(scanner.nextInt());
										
					System.out.println(profesores.toString());
										
					entity.getTransaction().begin();
					entity.merge(profesores);
					entity.getTransaction().commit();
					
					System.out.println("Profesor actualizado..");
					System.out.println();
				} else { //no lo encontro
					
					System.out.println("Profesor no encontrado... Esta es la lista completa de profesores");
										
					List<Profesores> profesoresRecover= (List<Profesores> ) entity.createQuery("FROM Profesores").getResultList();
					for (Profesores e : profesoresRecover) {
						System.out.println(e);
					}			
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del Profesor a eliminar:");

				profesores = entity.find(Profesores.class, scanner.next());
				if (profesores != null) {
					System.out.println(profesores);
					
					entity.getTransaction().begin();
					entity.remove(profesores);
					entity.getTransaction().commit();
					System.out.println("profesor eliminado...");
				} else {
					System.out.println("profesor no encontrado...");
				}
				break;
			case 5://entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}
}

package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Entities.Estudiantes;
import Persistencia.FachadaPersistenciaEstudiante;

public class MainEstudiantes {

	@SuppressWarnings("unchecked") 
	public static void main(String[] args) {

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Estudiantes estudiantes;

		//EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		EntityManager entity = FachadaPersistenciaEstudiante.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear estudiante");
			System.out.println("2. Buscar estudiante");
			System.out.println("3. Actualizar estudiante");
			System.out.println("4. Eliminar estudiante");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			estudiantes = new Estudiantes();
			
			switch (opcion) {
			case 1:
				scanner.nextLine();
				System.out.println("Digite el ID del estudiante:");
				estudiantes.setId(scanner.nextLine());
				
				System.out.println("Digite el codigo del estudiante:");
				estudiantes.setCodigo(scanner.nextInt());
				
				System.out.println("Digite el grupo del estudiante:");
			//	estudiantes.setGrupo(scanner.nextInt());
				
				
				System.out.println(estudiantes.toString());
				
				entity.getTransaction().begin();
				entity.persist(estudiantes);
				entity.getTransaction().commit();
				System.out.println("estudiante registrado..");
				System.out.println();
				break; 

			case 2:
				System.out.println("Digite el id del estudiante a buscar:");
				estudiantes = entity.find(Estudiantes.class, scanner.next());
				if (estudiantes != null) {
					System.out.println(estudiantes.toString());
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Estudiante no encontrado... Esta es la lista completa de estudiantes");
					
					
					List<Estudiantes> estudiantesRecover= (List<Estudiantes> ) entity.createQuery("FROM Estudiantes").getResultList();
					for (Estudiantes e : estudiantesRecover) {
						System.out.println(e);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del estudiante a actualizar:");

			     estudiantes = entity.find(Estudiantes.class, scanner.next());
				if (estudiantes != null) {  //Encontro
					
					
					scanner.nextLine();
					
					System.out.println("Digite el codigo del estudiante:");
					estudiantes.setCodigo(scanner.nextInt());
					
					System.out.println("Digite el grupo del estudiante:");
				//	estudiantes.setGrupo(scanner.nextInt());
					
					
					System.out.println(estudiantes.toString());
					
					
					entity.getTransaction().begin();
					entity.merge(estudiantes);
					entity.getTransaction().commit();
					
					System.out.println("Estudiante actualizado..");
					System.out.println();
				} else { //no lo encontro
					
					System.out.println("Estudiante no encontrado... Esta es la lista completa de estudiantes");
					
					
					List<Estudiantes> estudiantesRecover= (List<Estudiantes> ) entity.createQuery("FROM Estudiantes").getResultList();
					for (Estudiantes e : estudiantesRecover) {
						System.out.println(e);
					}
					
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del estuadiante a eliminar:");

			    estudiantes = entity.find(Estudiantes.class, scanner.next());
				if (estudiantes != null) {
					System.out.println(estudiantes);
					
					entity.getTransaction().begin();
					entity.remove(estudiantes);
					entity.getTransaction().commit();
					System.out.println("estudiante eliminado...");
				} else {
					System.out.println("estudiante no encontrado...");
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

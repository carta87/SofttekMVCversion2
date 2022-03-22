package Tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Entities.Estudiantes;
import Entities.Usuarios;
import Persistencia.FachadaPersistenciaEstudiante;

public class MainUsuarios {

	@SuppressWarnings("unchecked") 
	public static void main(String[] args) {

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Usuarios usuarios;

		//EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		EntityManager entity = FachadaPersistenciaEstudiante.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear Usuario");
			System.out.println("2. Buscar Usuario");
			System.out.println("3. Actualizar Usuario");
			System.out.println("4. Eliminar Usuario");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
		    usuarios =  new Usuarios();
			
			switch (opcion) {
			case 1:
				System.out.println("Digite el id del usuario:");
				usuarios.setId(scanner.next());
				
				System.out.println("Digite el nombre del usuario:");
				usuarios.setNombre(scanner.next()); 
				
				System.out.println("Digite el password del usuario:");
				usuarios.setPassword(scanner.next());
				
				
				System.out.println(usuarios.toString());
				
				entity.getTransaction().begin();
				entity.persist(usuarios);
				entity.getTransaction().commit();
				System.out.println("Usuario registrado..");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del Usuario a buscar:");
				usuarios = entity.find(Usuarios.class, scanner.next());
				if (usuarios != null) {
					System.out.println(usuarios.toString());
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Usuarios no encontrado... Esta es la lista completa de estudiantes");
					
					
					List<Usuarios> usuariosRecover= (List<Usuarios> ) entity.createQuery("FROM Usuarios").getResultList();
					for (Usuarios e : usuariosRecover) {
						System.out.println(e);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del usuario a actualizar:");
				
				usuarios = entity.find(Usuarios.class, scanner.next());
				if (usuarios != null) {  //Encontro
					
					scanner.nextLine();

					System.out.println("Digite el nombre del usuario:");
					usuarios.setNombre(scanner.next()); 
					
					System.out.println("Digite el password del usuario:");
					usuarios.setPassword(scanner.next());
					
					System.out.println(usuarios.toString());
					
					
					entity.getTransaction().begin();
					entity.merge(usuarios);
					entity.getTransaction().commit();
					
					System.out.println("usuario actualizado..");
					System.out.println();
				} else { //no lo encontro
					
					System.out.println("usuario no encontrado... Esta es la lista completa de Usuarios");
					
					List<Usuarios> usuariosRecover= (List<Usuarios> ) entity.createQuery("FROM Usuarios").getResultList();
					for (Usuarios e : usuariosRecover) {
						System.out.println(e);
					}
					
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del Usuario a eliminar:");

				usuarios = entity.find(Usuarios.class, scanner.next());
				if (usuarios != null) {
					System.out.println(usuarios);
					
					entity.getTransaction().begin();
					entity.remove(usuarios);
					entity.getTransaction().commit();
					System.out.println("Usuario eliminado...");
				} else {
					System.out.println("Usuario no encontrado...");
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

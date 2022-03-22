package DataBase;

import java.util.ArrayList;
import java.util.List;

import Entities.Estudiantes;
import Entities.Grupo;

import Entities.Profesores;

public class TablaGeneral {

	Grupo grado1 = new Grupo();
	Grupo grado2 = new Grupo();
	Grupo grado3 = new Grupo();
	Grupo grado4 = new Grupo();
	Grupo grado5 = new Grupo();

	Estudiantes estudiante1 = new Estudiantes("1", "Laura", "laura001", 1, grado1);
	Estudiantes estudiante2 = new Estudiantes("2", "Pedro", "pedro002", 2, grado2);
	Estudiantes estudiante3 = new Estudiantes("3", "Martin", "Martin003", 3, grado3);
	Estudiantes estudiante4 = new Estudiantes("4", "Paula", "paula004", 4, grado4);
	Estudiantes estudiante5 = new Estudiantes("5", "Lucia", "Lucia005", 5, grado5);
	
	Profesores profesor1 = new Profesores("1", "Fernado", "fernando1", grado1, 2);
	Profesores profesor2 = new Profesores("2", "Marcos", "Marcos2", grado2, 2);
	Profesores profesor3 = new Profesores("3", "Maria", "Maria3", grado3, 3);
	Profesores profesor4 = new Profesores("4", "Ivan", "ivan4", grado1, 4);
	Profesores profesor5 = new Profesores("5", "Andrea", "andrea5", grado1, 5);
	

	public List<Estudiantes> tablaEstudiantes() {

		List<Estudiantes> listaEstudiante = new ArrayList<Estudiantes>();

		listaEstudiante.add(estudiante1);
		listaEstudiante.add(estudiante2);
		listaEstudiante.add(estudiante3);
		listaEstudiante.add(estudiante4);
		listaEstudiante.add(estudiante5);

		return listaEstudiante;
	}

	public List<Profesores> listaProfesores() {

		List<Profesores> listaProfesores = new ArrayList<>();
		listaProfesores.add(profesor1);
		listaProfesores.add(profesor2);
		listaProfesores.add(profesor3);
		listaProfesores.add(profesor4);
		listaProfesores.add(profesor5);
		
		return listaProfesores;
	}
	
	

}

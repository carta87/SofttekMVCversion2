
package Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo")
public class Grupo  {
   
	
	//@OneToOne(cascade = {CascadeType.ALL})
	//@JoinColumn(name = "id")
	//private List<Estudiantes> estudiantes;
	//@OneToOne(cascade = {CascadeType.ALL})
	//@JoinColumn(name = "id")
	//@Column(name="idProfesor")
	//private Profesores profesor;
	
	@Id
	private String id;
	private String asignatura;
	@OneToMany(mappedBy = "grupo")
	private List<Estudiantes> estudiantes;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "idprofesor")
	private Profesores idProfesor;
	
	
	public Grupo() {
		
	}
	


	

	public Grupo(String id, String asignatura, List<Estudiantes> estudiantes, Profesores idProfesor) {
		
		this.id = id;
		this.asignatura = asignatura;
		this.estudiantes = estudiantes;
		this.idProfesor = idProfesor;
	}





	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	

	



	



	public List<Estudiantes> getIdEstudiante() {
		return estudiantes;
	}





	public void setIdEstudiante(List<Estudiantes> estudiantes) {
		this.estudiantes = estudiantes;
	}





	public Profesores getIdProfesor() {
		return idProfesor;
	}



	public void setIdProfesor(Profesores estudiantes) {
		this.idProfesor = estudiantes;
	}










	@Override
	public int hashCode() {
		return Objects.hash(asignatura, estudiantes, id, idProfesor);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(estudiantes, other.estudiantes)
				&& Objects.equals(id, other.id) && Objects.equals(idProfesor, other.idProfesor);
	}





	@Override
	public String toString() {
		return "Grupo [id=" + id + ", asignatura=" + asignatura + ", estudiantes=" + estudiantes + ", idProfesor="
				+ idProfesor + "]";
	}








	
	

	
}

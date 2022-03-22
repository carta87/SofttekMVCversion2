
package Entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Profesores")
public class Profesores extends Usuarios {

	//@OneToOne(mappedBy = "id", fetch = FetchType.LAZY )
	private Grupo grupo;
	private Integer nivel;
	  
	public Profesores() {
		
	}
	
	
	

	public Profesores(String id, String nombre, String password, Grupo grupo, Integer nivel) {
		super.setId(id);
		super.setNombre(nombre);
		super.setPassword(password);
		this.grupo = grupo;
		this.nivel = nivel;
	}




	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Profesores [nombre = "+ super.getNombre()+ " password = "+super.getPassword() + " grupo=" + grupo + ", nivel=" + nivel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(grupo, nivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesores other = (Profesores) obj;
		return Objects.equals(grupo, other.grupo) && Objects.equals(nivel, other.nivel);
	}
	


}




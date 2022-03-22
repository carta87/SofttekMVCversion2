package Entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Estudiantes")
public class Estudiantes extends Usuarios  {
	
	private static final long serialVersionUID = 1L;
	

	private Integer codigo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", insertable = false , updatable = false)
	private Grupo grupo;

	public Estudiantes() {
		 
	}
	
	public Estudiantes( String id, String nombre, String password, Integer codigo, Grupo grupo) {
		super.setId(id);
		super.setNombre(nombre);
		super.setPassword(password);
		
		this.codigo = codigo;
		this.grupo = grupo;
	}



	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	

	@Override
	public String toString() {
		return "Estudiantes [nombre=  "+ super.getNombre() + "id=" +super.getId()+ "password " + super.getPassword()+"  codigo=" + codigo + ", grupo=" + grupo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, grupo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiantes other = (Estudiantes) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(grupo, other.grupo);
	}
	
	



	
/*
	@Override
	public int hashCode() {
		return Objects.hash(codigo, grupo, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiantes other = (Estudiantes) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(grupo, other.grupo)
				&& Objects.equals(id, other.id);
	}*/

/*
   public static void main(String[] args) {
	   Estudiantes estudiantes = new Estudiantes();
	   estudiantes.setNombre("juliana");
	 System.out.println(estudiantes.getNombre());
}*/
	

}

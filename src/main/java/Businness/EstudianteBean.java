package Businness;

import javax.faces.bean.ApplicationScoped;

import javax.inject.Inject;
import javax.inject.Named;

import Entities.Estudiantes;
import Persistencia.FachadaPersistenciaEstudiante;
import Persistencia.FachadaPersistenciaEstudianteLocal;

import java.util.List;
import java.util.ArrayList;


@Named
@ApplicationScoped
public class EstudianteBean  {
	
	boolean flag = false;
	private static List<Estudiantes> listRecover = new ArrayList<>();
	/*public EstudianteBean(FachadaPersistenciaEstudianteLocal fPEL) {
		this.fachadaPersistenciaEstudiante =fPEL;
	}*/
	private String prueba="nada por aca";
	
	@Inject
	public FachadaPersistenciaEstudianteLocal fachadaPersistenciaEstudianteLocal;

	public EstudianteBean(FachadaPersistenciaEstudianteLocal fpel) {
		this.fachadaPersistenciaEstudianteLocal= fpel;
	}
	
	public String getPrueba() {
		return prueba; 
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}	
	
	public List<Estudiantes> getListRecover() {
		return listRecover;
	}

	public void setListRecover(List<Estudiantes> listRecover) {
		this.listRecover = listRecover;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<Estudiantes> consultarEstudiantes(){
		
		System.out.println("por aca pasa");
		this.listRecover = this.fachadaPersistenciaEstudianteLocal.findAll();
		
		for (Estudiantes estudiantes : listRecover) {
			System.out.println(estudiantes);
		}
		this.flag = true;
		return this.listRecover;
	} 
	
	
	public void eliminarEstudiante(Estudiantes estudiantes) {
		this.fachadaPersistenciaEstudianteLocal.remove(estudiantes);;
	}
	
	public static void main(String[] args) {
		
		
		FachadaPersistenciaEstudianteLocal Ifpel = new FachadaPersistenciaEstudiante();
		
		EstudianteBean estudianteBean = new EstudianteBean(Ifpel);
		List<Estudiantes> studentsRecover = new ArrayList<>();
		  
		studentsRecover = estudianteBean.consultarEstudiantes();
				
		System.out.println("por aca sale");
		for(Estudiantes e : studentsRecover) {
			System.out.println(e);
		}

	}
}

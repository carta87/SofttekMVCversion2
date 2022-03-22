package Businness;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import Entities.Profesores;
import Persistencia.FachadaPersistenciaProfesor;
import Persistencia.FachadaPersistenciaProfesorLocal;

import java.util.List;
import java.util.ArrayList;

@Named  
@ApplicationScoped
public class ProfesorBean  {
	
	private static List<Profesores> listRecover = new ArrayList<>();
	/*public EstudianteBean(FachadaPersistenciaEstudianteLocal fPEL) {
		this.fachadaPersistenciaEstudiante =fPEL;
	}*/
	private String prueba="nada por aca en profesores";
	
	@Inject
	public FachadaPersistenciaProfesorLocal fachadaPersistenciaProfesorLocal;
/*
	public ProfesorBean(FachadaPersistenciaProfesorLocal fppl) {
		this.fachadaPersistenciaProfesorLocal= fppl;
	}*/
	
	public String getPrueba() {
		return prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}	
	
	public List<Profesores> getListRecover() {
		return listRecover;
	}

	public void setListRecover(List<Profesores> listRecover) {
		this.listRecover = listRecover;
	}


	public List<Profesores> consultarProfesores(){
		System.out.println("por aca pasa");
		this.listRecover = this.fachadaPersistenciaProfesorLocal.findAll();
		
		for (Profesores profesores : listRecover) {
			System.out.println(profesores);
		}
		return this.listRecover;
	}
	/*
	public static void main(String[] args) {
		
		
		FachadaPersistenciaProfesorLocal Ifppl = new FachadaPersistenciaProfesor();
		
		ProfesorBean profesorBean = new ProfesorBean(Ifppl);
		List<Profesores> profesorsRecover = new ArrayList<>();
		 
		profesorsRecover = profesorBean.consultarProfesores();
				
		System.out.println("por aca sale");
		for(Profesores e : profesorsRecover) {
			System.out.println(e);
		}

	}*/
}

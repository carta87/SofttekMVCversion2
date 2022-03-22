package Businness;

import javax.faces.bean.ApplicationScoped;

import javax.inject.Inject;
import javax.inject.Named;

import Entities.Grupo;

import Persistencia.FachadaPersistenciaGrupo;
import Persistencia.FachadaPersistenciaGrupoLocal;


import java.util.List;
import java.util.ArrayList;

@Named
@ApplicationScoped
public class GrupoBean  { 
	
	private static List<Grupo> listRecover = new ArrayList<>();
	/*public GrupoBean(FachadaPersistenciaGrupoLocal fPEL) {
		this.fachadaPersistenciaGrupoLocal =fPEL;
	}*/
	private String prueba="nada por aca en gupossssss";
	
	@Inject
	public FachadaPersistenciaGrupoLocal fachadaPersistenciaGrupoLocal;
/*
	public GrupoBean(FachadaPersistenciaGrupoLocal fgpl) {
		this.fachadaPersistenciaGrupoLocal= fgpl;
	}*/
	
	public String getPrueba() {
		return prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}	
	
	public List<Grupo> getListRecover() {
		return listRecover;
	}

	public void setListRecover(List<Grupo> listRecover) {
		this.listRecover = listRecover;
	}


	public List<Grupo> consultarGrupo(){
		System.out.println("por aca pasa");
		this.listRecover = this.fachadaPersistenciaGrupoLocal.findAll();
		
		for (Grupo grupo : listRecover) {
			System.out.println(grupo);
		}
		return this.listRecover;
	}
	/*
	public static void main(String[] args) {
		
		
		FachadaPersistenciaGrupoLocal Ifgpl = new FachadaPersistenciaGrupo();
		
		GrupoBean grupoBean = new GrupoBean(Ifgpl);
		List<Grupo> grupoRecover = new ArrayList<>();
		 
		grupoRecover = grupoBean.consultarGrupo();
				
		System.out.println("por aca sale");
		for(Grupo e : grupoRecover) {
			System.out.println(e);
		}

	}*/
}

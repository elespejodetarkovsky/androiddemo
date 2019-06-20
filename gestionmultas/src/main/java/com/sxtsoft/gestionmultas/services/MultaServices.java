package com.sxtsoft.gestionmultas.services;

import com.sxtsoft.gestionmultas.model.Agente;
import com.sxtsoft.gestionmultas.model.Multa;

import java.util.List;


public interface MultaServices {

	/**
	 * 
	 * Se crea una multa con un nuevo c�digo
	 * 
	 * @param multa
	 * @return
	 */
	public Multa create(Multa multa);
	
	public Multa read(Long codigo);
	
	public void delete(Long codigo);
	
	public List<Multa> getAll();
	public List<Multa> getByAgente(Agente agente);
	
	
}

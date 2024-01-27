package br.com.rehab.services;

import java.util.List;

import br.com.rehab.entities.Vaga;


public interface VagaService {
List<Vaga> getAllVagas();
	
	Vaga getVagaById(Long id);
	
	Vaga saveVaga(Vaga vaga);
	
	Vaga updateVaga(Long id, Vaga vagaAtualizada);
	
	void deleteVaga(Long id);
}


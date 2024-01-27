package br.com.rehab.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rehab.entities.Vaga;

import br.com.rehab.repository.VagaRepository;

import br.com.rehab.services.VagaService;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaRepository vagaRepository;

	@Override
	public List<Vaga> getAllVagas() {
		return vagaRepository.findAll();
		}
	
	@Override
	@Transactional(readOnly = true)
	public Vaga getVagaById(Long id) {
		return vagaRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Vaga saveVaga(Vaga vaga) {
		return vagaRepository.save(vaga);
	}
	
	@Override
	public Vaga updateVaga (Long id, Vaga vagaAtualizada) {
		Vaga vagaExistente = vagaRepository.findById(id).orElse(null);
		if (vagaExistente != null) { 
			vagaExistente.setProfissao(vagaAtualizada.getProfissao());
			vagaExistente.setDescricao(vagaAtualizada.getDescricao());
			vagaExistente.setLink(vagaAtualizada.getLink());
			return vagaRepository.save(vagaExistente);
		} else { 
			throw new RuntimeException("vaga com o ID" + id + "não encontrada.");
		}
	}
	
	@Override
	public void deleteVaga(Long id) {
		vagaRepository.deleteById(id);
	}

}

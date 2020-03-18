package br.com.impacta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.models.Despesa;
import br.com.impacta.repositories.DespesaRepository;

@Service
public class DespesasServiceImpl implements DespesasService {

	@Autowired
	private DespesaRepository despesaRepository;
	
	@Override
	public void salvar(Despesa despesa) {
		despesaRepository.save(despesa);
	}

	@Override
	public List<Despesa> listarDespesas() {
		return despesaRepository.findAll();
	}

	@Override
	public void deletarPorCodigo(Long codigo) {
		despesaRepository.deleteById(codigo);
	}
}

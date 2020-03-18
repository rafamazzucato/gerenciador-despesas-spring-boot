package br.com.impacta.services;

import java.util.List;

import br.com.impacta.models.Despesa;

public interface DespesasService {
	public void salvar(Despesa despesa);
	public List<Despesa> listarDespesas();
	public void deletarPorCodigo(Long codigo);
}
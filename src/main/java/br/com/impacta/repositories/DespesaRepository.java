package br.com.impacta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.models.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}

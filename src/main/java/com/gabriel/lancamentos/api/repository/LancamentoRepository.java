package com.gabriel.lancamentos.api.repository;

import com.gabriel.lancamentos.api.model.Lancamento;
import com.gabriel.lancamentos.api.repository.lancamento.LancamentoRepositoryQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
    
}

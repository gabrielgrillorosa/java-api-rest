package com.gabriel.lancamentos.api.repository.lancamento;

import com.gabriel.lancamentos.api.model.Lancamento;
import com.gabriel.lancamentos.api.repository.filter.LancamentoFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LancamentoRepositoryQuery {

	//Alterado primeito parametro do construtor de LancamentoRepository para LancamentoFilter
	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}

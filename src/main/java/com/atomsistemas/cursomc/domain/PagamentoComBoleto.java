package com.atomsistemas.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.atomsistemas.cursomc.domain.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity//herança
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy ")//mascara
	private Date dataVencimento;
	@JsonFormat(pattern = "dd/MM/yyyy ")//mascara
	private Date dataPagamento;
	
	 public PagamentoComBoleto() {
		 
	 }

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido); 
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

   
}


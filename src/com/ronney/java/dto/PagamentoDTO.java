package com.ronney.java.dto;

import java.math.BigDecimal;

public class PagamentoDTO {

	private Integer numero;
	private String descricao;
	private BigDecimal valor;
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "PagamentoDTO [numero=" + getNumero() + 
				", descricao=" + getDescricao() + 
				", valor=" + getValor() + "]";
	}
}

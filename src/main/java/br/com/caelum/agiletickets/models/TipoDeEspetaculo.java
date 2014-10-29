package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		@Override
		public BigDecimal calculaPreco(Sessao sessao) {
			return precoEspetaculo(sessao, 0.05, 0.10);
		}
		
	}, SHOW {
		@Override
		public BigDecimal calculaPreco(Sessao sessao) {
			return precoEspetaculo(sessao, 0.05, 0.10);
		}
		
	}, TEATRO {
		@Override
		public BigDecimal calculaPreco(Sessao sessao) {
			return sessao.getPreco();
		}

	}, BALLET {
		@Override
		public BigDecimal calculaPreco(Sessao sessao) {
			
			BigDecimal preco = precoEspetaculo(sessao, 0.50, 0.20);
			preco = acrescentaValorEspetaculoLongo(sessao, preco);
			
			return preco;
		}
		
	}, ORQUESTRA {
		@Override
		public BigDecimal calculaPreco(Sessao sessao) {

			BigDecimal preco = precoEspetaculo(sessao, 0.50, 0.20);
			preco = acrescentaValorEspetaculoLongo(sessao, preco);
			
			return preco;
		}
		
	};
	
	public abstract BigDecimal calculaPreco(Sessao sessao);
	
	private static BigDecimal precoEspetaculo(Sessao sessao, double percentual, double taxa) {
		if ((sessao.getTotalIngressos() - sessao.getIngressosReservados())
				/ sessao.getTotalIngressos().doubleValue() <= percentual) {
			return sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(taxa)));
		} else {
			return sessao.getPreco();
		}
	}
	
	private static BigDecimal acrescentaValorEspetaculoLongo(Sessao sessao, BigDecimal preco) {
				
		if (sessao.getDuracaoEmMinutos() > 60) {
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		
		return preco;
	}
}

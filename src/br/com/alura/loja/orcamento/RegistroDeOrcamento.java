package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {
	
	private HttpAdapter http;
	
	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}
	
	public void registrar(Orcamento orcamento) {
		if (!orcamento.isFinalizado())
		{
			throw new DomainException("Orcamento n�o finalizado.");
		}

		String url = "http://api.external/orcamento";
		Map<String, Object> dados = Map.of(
				"valor", orcamento.getValor(),
				"quantidadeItens", orcamento.getQuantidadeItens()
				);
		http.post(url, dados);
	}
}

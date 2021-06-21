import java.util.ArrayList;

public class Diretorio {
	
	String nome;
	int tamanho;
	String nomeDoBloco;
	ArrayList<Arquivo> arquivo = new ArrayList<Arquivo>();
	
	public Diretorio(String nome) {
		this.nome = nome;
		this.tamanho = 1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getNomeDoBloco() {
		return nomeDoBloco;
	}

	public void setNomeDoBloco(String nomeDoBloco) {
		this.nomeDoBloco = nomeDoBloco;
	}

	public ArrayList<Arquivo> getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo.add(arquivo);
	};
	
	
}

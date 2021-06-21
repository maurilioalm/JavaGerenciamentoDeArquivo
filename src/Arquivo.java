
public class Arquivo {
	
	String nome;
	int tamanho;
	String nomeDiretorio;
	
	public Arquivo(String nome, int tamanho, String nomeDiretorio) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.nomeDiretorio = nomeDiretorio;
	}
	
	public Arquivo(String nome, int tamanho) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.nomeDiretorio = "RAIZ";
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

	public String getNomeDiretorio() {
		return nomeDiretorio;
	}

	public void setNomeDiretorio(String nomeDiretorio) {
		this.nomeDiretorio = nomeDiretorio;
	}

}

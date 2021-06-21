import java.util.ArrayList;

public class Bloco {
	String nome;
	int espacoTotal = 10;
	int espacoRestante = 10;
	byte ocupado = 0;
	ArrayList<Diretorio> listaDeDiretorios = new ArrayList<Diretorio>();
	ArrayList<Arquivo> listaDeArquivos = new ArrayList<Arquivo>();

	public Bloco() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEspacoTotal() {
		return espacoTotal;
	}

	public void setEspacoTotal(int espacoTotal) {
		this.espacoTotal = espacoTotal;
	}

	public int getEspacoRestante() {
		return espacoRestante;
	}

	public void setEspacoRestante(int espacoRestante) {
		this.espacoRestante = espacoRestante;
	}

	public byte getOcupado() {
		return ocupado;
	}

	public void setOcupado(byte ocupado) {
		this.ocupado = ocupado;
	}

	public ArrayList<Diretorio> getListaDeDiretorios() {
		return listaDeDiretorios;
	}

	public void setDiretorio(Diretorio diretorio) {
		this.listaDeDiretorios.add(diretorio);
	}

	public ArrayList<Arquivo> getListaDeArquivos() {
		return listaDeArquivos;
	}

	public void setArquivos(Arquivo arquivo) {
		this.listaDeArquivos.add(arquivo);
	}
	
	



}


public class Programa {

	public static void main(String[] args) {
		
		DiscoRigido hd = new DiscoRigido();
		
		//ADICIONAR/CRIAR DIRET�RIOS
		hd.adicionarDiretorio("PASTA 1");
		hd.adicionarDiretorio("PASTA 2");
		hd.adicionarDiretorio("PASTA 3");
		
		//REMOVER DIRETORIO N�O EXISTENTE
		hd.removerDiretorio("testes");
		hd.removerDiretorio("PASTA 1");
		
		
		//CRIAR ARQUIVOS EM DIRET�RIOS
		hd.criarArquivo("FOTOS JOAO", 2, "PASTA 1");
		hd.removerDiretorio("PASTA 1");
		hd.criarArquivo("FOTOS MARIA", 5, "PASTA 2");
		hd.criarArquivo("FOTOS MARIA", 5, "PASTA 2");
		

		
		//LISTAR DIRET�RIOS E ARQUIVOS
		hd.listarDiretoriosEArquivos();
		
		//REMOVER ARQUIVO
		hd.removerArquivo("FOTOS JOAO");
		hd.removerArquivo("FOTOS JOAO");
		
		
		
		hd.listarDiretoriosEArquivos();
		
		hd.adicionarDiretorio("PASTA 1");

	}

}

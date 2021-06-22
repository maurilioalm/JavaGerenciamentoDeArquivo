
public class Programa {

	public static void main(String[] args) {
		
		DiscoRigido hd = new DiscoRigido();
		
		//ADICIONAR/CRIAR DIRETÓRIOS
		hd.adicionarDiretorio("PASTA 1");
		hd.adicionarDiretorio("PASTA 2");
		hd.adicionarDiretorio("PASTA 3");
		hd.adicionarDiretorio("PASTA 4");
		
		//CRIAR DIRETORIO COM MESMO NOME
		hd.adicionarDiretorio("PASTA 3");
		
		//REMOVER DIRETORIO QUE NÃO EXISTE
		hd.removerDiretorio("testes");
		//REMOVER DIRETORIO QUE EXISTE
		hd.removerDiretorio("PASTA 1");
		
		
		//CRIAR ARQUIVOS EM DIRETÓRIO QUE NÃO EXITE
		hd.criarArquivo("FOTOS JOAO", 2, "PASTA 1");
		//CRIAR ARQUIVO EM DIRETÓRIO QUE EXISTE
		hd.criarArquivo("FOTOS MARIA", 5, "PASTA 2");
		hd.criarArquivo("FOTOS CARLOS", 7, "PASTA 3");
		hd.criarArquivo("FOTOS ROBERTO", 2, "PASTA 4");
		
		//TENTAR CRIAR ARQUIVO COM MESMO NOME
		hd.criarArquivo("FOTOS MARIA", 5, "PASTA 3");
		
		//REMOVER DIRETORIO COM ARQUIVO
		hd.removerDiretorio("PASTA 4");
		
		//REMOVER SOMENTE ARQUIVO
		hd.removerArquivo("FOTOS CARLOS");
		
		//LISTAR DIRETÓRIOS E ARQUIVOS
		hd.listarDiretoriosEArquivos();


	}

}

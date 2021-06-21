
public class Programa {

	public static void main(String[] args) {
		
		DiscoRigido hd = new DiscoRigido();
		
		//ADICIONAR/CRIAR DIRETÓRIOS
		hd.adicionarDiretorio("PASTA 1");
		hd.adicionarDiretorio("PASTA 2");
		
		//REMOVER DIRETORIO NÃO EXISTENTE
		hd.removerDiretorio("testes");
		
		
		//CRIAR ARQUIVOS EM DIRETÓRIOS
		hd.criarArquivo("FOTOS JOAO", 2, "PASTA 1");
		hd.criarArquivo("FOTOS MARIA", 5, "PASTA 2");
		
		//LISTAR DIRETÓRIOS E ARQUIVOS
		hd.listarDiretoriosEArquivos();
		
		//REMOVER ARQUIVO
		hd.removerArquivo("FOTOS JOAO");
		hd.listarDiretoriosEArquivos();

	}

}

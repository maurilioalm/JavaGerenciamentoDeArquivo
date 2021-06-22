// SISTEMA DE ARQUIVOS COM ALOCAÇÂO CONTÍGUA.
//ESTRATÉGIA DE ALOCAÇÂO FIRST-FIT.
public class DiscoRigido {

	static int tamanhoDoDiscoDisponivel = 40; // TAMANHO TOTAL 40MB.
	static Bloco[] blocos = new Bloco[4];// DIVIDIDOS EM 4 BLOCOS DE 10MB.

	// CONTRUTOR.
	public DiscoRigido() {
		criarBlocos();
	}

	// INSTANCIA BLOCOS.
	private void criarBlocos() {
		for (int i = 0; i < 4; i++) {
			Bloco b = new Bloco();
			b.setNome("BLOCO 0" + (i + 1));
			blocos[i] = b;
		}
	}

	// CRIA UM DIRETÓRIO E ADICIONA A UM BLOCO VAZIO.
	public static void adicionarDiretorio(String nome) {
		Diretorio d = new Diretorio(nome);
		adicionarDiretorioAoBloco(d);

	}

	// REMOVE O DIRETÓRIO RECEBENDO O NOME.
	public void removerDiretorio(String nome) {
		if (removerDiretorioNoBloco(nome)) {
			System.out.println("DIRETÓRIO " + nome + " REMOVIDO COM SUCESSO!");
			imprimeEspacoDisponivelNoDisco();
		} else {
			System.out
					.println("DIRETÓRIO NÃO EXISTE, VERIFIQUE O NOME DIGITADO: " + nome + ", CONSULTE A LISTA ABAIXO:");
			listarDiretorios();
		}
	}

	// ADICIONAR DIRETÓRIO DENTRO DE UM BLOCO VAZIO.
	private static void adicionarDiretorioAoBloco(Diretorio diretorio) {
		if (verificarNoDiretorio(diretorio)) {
			for (int i = 0; i < 4; i++) {
				if (blocos[i].espacoRestante >= 10) {
					diretorio.setNomeDoBloco(blocos[i].getNome());
					blocos[i].setDiretorio(diretorio);
					blocos[i].setEspacoRestante(blocos[i].getEspacoRestante() - diretorio.getTamanho());
					tamanhoDoDiscoDisponivel -= diretorio.getTamanho();
					System.out.println("DIRETÓRIO CRIADO NOME: " + diretorio.getNome() + " INCLUIDO NA RAIZ, "
							+ blocos[i].getNome());
					imprimeEspacoDisponivelNoDisco();
					break;
				}
			}
		} else
			System.out.println("FALHA AO TENTAR CRIAR O DIRETÓRIO: " + diretorio.getNome() + ", DIRETÓRIO JÁ EXISTE.");
		listarDiretoriosEArquivos();
	}

	// REMOVE O DIRETÓRIO NO BLOCO ONDE FOR ENCONTRADO.
	private boolean removerDiretorioNoBloco(String nome) {
		for (int i = 0; i < 4; i++) {
			if (blocos[i].getEspacoRestante() != 10) {
				if (blocos[i].getListaDeDiretorios() != null) {
					for (Diretorio d : blocos[i].getListaDeDiretorios()) {
						if (d.getNome().equals(nome)) {
							blocos[i].getListaDeDiretorios().remove(d);

							tamanhoDoDiscoDisponivel += d.getTamanho();
							blocos[i].setEspacoRestante(blocos[i].getEspacoTotal());
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	// LISTA TODOS OS DIRETÓRIOS DENTRO DOS BLOCOS.
	public static void listarDiretorios() {
		for (int i = 0; i < 4; i++) {
			if (blocos[i].getListaDeDiretorios() != null) {
				for (Diretorio d : blocos[i].getListaDeDiretorios()) {
					System.out.println("DIRETORIO: " + d.getNome() + " LOCALIZADO NA RAIZ, TAMANHO:  " + d.getTamanho()
							+ "MB, LOCAL NO DISCO: " + blocos[i].getNome());

				}
			}
		}
		imprimeEspacoDisponivelNoDisco();
	}

	// IMPRIME O ESPAÇO DISPONÍVEL EM DISCO.
	public static void imprimeEspacoDisponivelNoDisco() {
		fragmentacao();
		System.out.println("ESPAÇO DISPONÍVEL NO DISCO: " + tamanhoDoDiscoDisponivel + "MB.\n");
	}

	// CRIAR ARQUIVO E ALOCAR EM UM DIRETÓRIO.
	public static void criarArquivo(String nome, int tamanho, String nomeDiretorio) {
		Arquivo arquivo = new Arquivo(nome, tamanho, nomeDiretorio);
		if (arquivo.getTamanho() > 9 || arquivo.getTamanho() <= 0) {
			System.out.println("TAMANHO INVÁLIDO, ESCOLHA UM TAMANHO ENTRE 1 E 9");
		} else
			armazenarArquivo(arquivo);
	}

	// ARMAZENAR UM ARQUIVO NO DIRETÓRIO.
	private static boolean armazenarArquivo(Arquivo arquivo) {

		for (int i = 0; i < 4; i++) {
			if (blocos[1].getListaDeDiretorios() != null) {
				for (Diretorio d : blocos[i].getListaDeDiretorios()) {
					if (d.getNome().equals(arquivo.getNomeDiretorio())) {
						if (verificarNomeArquivo(arquivo)) {
							d.setArquivo(arquivo);
							d.setTamanho(d.getTamanho() + arquivo.getTamanho());
							blocos[i].setArquivos(arquivo);
							blocos[i].setEspacoRestante(blocos[i].getEspacoRestante() - arquivo.getTamanho());
							tamanhoDoDiscoDisponivel -= arquivo.getTamanho();
							System.out.println("ADICIONADO O ARQUIVO: " + arquivo.getNome() + ", DE TAMANHO: "
									+ arquivo.getTamanho() + "MB, ADICIONADO COM SUCESSO NO DIRETÓRIO: " + d.getNome()
									+ ", LOCALIZADO NA RAIZ, " + blocos[i].getNome());
							imprimeEspacoDisponivelNoDisco();
							return true;
						}
						System.out.println(
								"ARQUIVO NÃO FOI CRIADO/COPIADO, NOME INVÁLIDO, JÁ EXISTE UM ARQUIVO COM MESMO NOME.");
						return false;
					}

				}
			}

		}

		System.out.println("ARQUIVO NÃO FOI CRIADO/COPIADO, DIRETÓRIO INVALIDO,"
				+ " SE NÃO SOUBER O DIRETÓRIO DIGITE CONFIRA A LISTA DE DIRETÓRIOS DISPONÍVEIS.");
		listarDiretorios();
		return false;
	}

	// REMOVER ARQUIVO DENTRO DO DIRETÓRIO ONDE FOR ENCONTRADO.
	public static boolean removerArquivo(String nome) {
		for (int i = 0; i < 4; i++) {
			if (blocos[i].getListaDeDiretorios() != null) {
				for (Diretorio d : blocos[i].getListaDeDiretorios()) {
					for (Arquivo a : d.getArquivo()) {
						if (a.getNome().equals(nome)) {
							tamanhoDoDiscoDisponivel += a.getTamanho();
							blocos[i].getListaDeArquivos().remove(a);
							d.getArquivo().remove(a);
							d.setTamanho(d.getTamanho() - a.getTamanho());
							blocos[i].setEspacoRestante(blocos[i].getEspacoRestante() + a.getTamanho());
							System.out.println("ARQUIVO REMOVIDO COM SUCESSO!");
							imprimeEspacoDisponivelNoDisco();
							return true;
						}
					}
				}
			}
		}
		System.out.println("ARQUIVO NÂO ENCONTRADO, VERIFIQUE SE O NOME DO ARQUIVO ESTA CORRETO.");

		return false;
	}

	// LISTAR TODOS OS DIRETORIOS E ARQUIVOS.
	public static void listarDiretoriosEArquivos() {
		System.out.println("LISTA DE DIRETÓRIOS E ARQUIVOS:");
		for (int i = 0; i < 4; i++) {
			if (blocos[i].getListaDeDiretorios() != null) {
				for (Diretorio d : blocos[i].getListaDeDiretorios()) {
					if (!d.getArquivo().isEmpty()) {
						for (Arquivo a : d.getArquivo()) {
							System.out.println("RAIZ->" + d.getNome() + "->" + a.getNome() + " TAMANHO: "
									+ a.getTamanho() + "MB " + blocos[i].getNome());
						}

					} else {
						System.out.println(
								"RAIZ->" + d.getNome() + " TAMANHO:  " + d.getTamanho() + "MB " + blocos[i].getNome());
					}

				}
			}
		}
		imprimeEspacoDisponivelNoDisco();
	}

	// VERIFICAR FRAGMENTAÇÃO NOS BLOCOS.
	public static void fragmentacao() {
		int aux = 0;
		for (int i = 0; i < 4; i++) {
			if (blocos[i].getEspacoRestante() < 9) {
				aux += blocos[i].getEspacoRestante();
			}
		}
		System.out.println("FRAGMENTAÇÃO INTERNA: " + aux);
	}

	// VERIFICAR SE O DIRETÓRIO TEM O NOME IGUAL.
	private static boolean verificarNoDiretorio(Diretorio diretorio) {
		for (int i = 0; i < 4; i++) {
			for (Diretorio d : blocos[i].getListaDeDiretorios()) {
				if (d.getNome().equals(diretorio.getNome())) {
					return false;
				}
			}
		}
		return true;
	}

	// VERIFICAR SE EXISTE ARQUIVO COM NOME IGUAL.
	private static boolean verificarNomeArquivo(Arquivo arquivo) {
		for (int i = 0; i < 4; i++) {
			for (Diretorio d : blocos[i].getListaDeDiretorios()) {
				for (Arquivo a : blocos[i].listaDeArquivos) {
					if (a.getNome().equals(arquivo.getNome())) {
						return false;
					}
				}
			}
		}
		return true;
	}

}

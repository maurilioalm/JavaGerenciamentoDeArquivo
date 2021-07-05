public class Raid1 {
	
	static int tamanhoDoDiscoDisponivel = 40; // TAMANHO TOTAL 40MB.
	static Bloco[] blocos = new Bloco[4];// DIVIDIDOS EM 4 BLOCOS DE 10MB.

	// CONTRUTOR.
	public Raid1() {
		criarBlocos();
	}

	// INSTANCIA BLOCOS.
	private void criarBlocos() {
		for (int i = 0; i < 4; i++) {
			Bloco b = new Bloco();
			b.setNome("RAID BLOCO 0" + (i + 1));
			blocos[i] = b;
		}
	}
}

package topic;

public class Pass {
	
	private String nome;
	private int idade;
	
	public Pass(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	
	@Override
	public String toString() {
		return this.nome + ":" + this.idade;
	}
}

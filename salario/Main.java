package salario;

public class Main {

	public static void main(String[] args) {
		Universidade universidade = new Universidade();
		Professor david = new Professor("David", 'C');
		
		universidade.addFuncionario(david);
		universidade.addFuncionario(new Professor("Elvis", 'D'));
		STA gilmario = new STA("Gilmario", 3);
		universidade.addFuncionario(gilmario);
		Terceirizado helder = new Terceirizado("Helder", 40, true);
		universidade.addFuncionario(helder);
		System.out.println(universidade);
		
		universidade.removerFuncionario("elvis");
		System.out.println(universidade);
		
		david.adicionarDiaria();
		david.adicionarDiaria();
		david.adicionarDiaria();
		
		System.out.println(david);
		
		gilmario.adicionarDiaria();
		gilmario.adicionarDiaria();
		System.out.println(gilmario);
		
		helder.adicionarDiaria();
		
		universidade.distribuirBonus(600.0f);
		System.out.println(gilmario);	
	}
}

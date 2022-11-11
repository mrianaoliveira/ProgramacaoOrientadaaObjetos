package salario;

import java.util.ArrayList;

public class Universidade {
	private ArrayList<Funcionario> funcionarios;
	
	Universidade() {
		funcionarios = new ArrayList<>(); //criando o array
	}
	
	public void addFuncionario(Funcionario funcionario) { //metodo adicionando funcionario 
		funcionarios.add(funcionario);//adicionando no array 
	}
	
	public void removerFuncionario(String nome) {//metodo removendo funcionario
		for(Funcionario f : funcionarios) {//percorrendo todo o array
			if(f.getNome() == null) {//se o nome q procura for igual a nulo
				System.out.println("Funcionario nao existe");//significa q o funcionario nao existe
				return;
			}// se nao
			else if(f.getNome().equals(nome)){//e novamente procurado o nome que desejas no vetor
				funcionarios.remove(f);//e eh removido
				return;
			}
		}
	}
	
	public void distribuirBonus(float valor) {//metodo distribuir bonos 
		double total = valor/(funcionarios.size()); //atribuindo um novo atributo, q ira pegar o valor do bonus
		// e dividir com todos os funcionarios
		for(Funcionario f : funcionarios) {//percorrendo todo o array
			f.adicionarBonus(total);//e adicionando o valor
		}
	}

	public String toString() {//to string
		String s = "";
		for(Funcionario f: funcionarios) { //percorrendo todo o array
			s += f.toString() + "\n";//e pegando cada funcionario, atribuindo os toString das outras classe e pulando uma linha
		}
		return s;//retornando o que foi citado acima
	}
	
	//set e get
	public ArrayList<Funcionario> getFuncionario() {
		return funcionarios;
	}

	public void setFuncionario(ArrayList<Funcionario> funcionario) {
		this.funcionarios = funcionario;
	}
}

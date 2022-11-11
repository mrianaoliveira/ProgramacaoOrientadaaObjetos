package salario;

public class Professor extends Funcionario {
	private char classe;
	
	Professor(String nome, char classe) {//construtor
		super(nome, 2);//sobrepondo o contsturor do funcincionario
		this.classe = classe;
 	}
	
	@Override
	public double calcSalario() {//calculando o salario
		double valor = getQtd_diarias() * 100 + getBonus();//adicionaod as diarias e o bonus
		valor += ((classe - 'A') * 2000) + 3000;//calculando o salario:
		//o - 'A' significa que ira diminuir - 1, caso nao encontre a classe q deseja, até achar
		//achado é multiplicado ppor 2000 (ex: classe A: 0 * 2000) e adicionando a 3000 no valor;
		return this.salario = valor;// e o salario vai receber esse valor
	}
	
	public void adicionarDiaria() {//adicionando diarias 
		//vendo se a quantidade maxima de diras eh maior que a quantidade de diaria do caba
		if(this.getQtd_diarias() <= this.getMax_diarias()) { //senao for, então pode ter diaira
			this.setSalario(this.getSalario() + 100); //adicionando 100 ao salario
			qtd_diarias++; //e aumetando a quantidade de diarias
		}
		else {//senao, significa que a diaria eh maior que a permitida 
			System.out.println("Limite de diarias atigindas");
		}
	}
	
	public void adicionarBonus(double bonus) {//metodo adicioanr bonus
		this.setSalario(this.getSalario() + bonus );//pega o salario e adiciona ao bonus
	}
	
	//set e get
	@Override
	public String toString() {//metodo tostring
		this.salario = calcSalario() + getBonus();//dizendo que o salario eh igual ao calculo do salario + os bonus
		return "Professor " +this.getNome() + ", classe " + this.classe + ", salario: " + this.getSalario();
	}
	
	public char getClasse() {
		return classe;
	}

	public void setClasse(char classe) {
		this.classe = classe;
	}
}

package salario;

public abstract class Funcionario {
	protected String nome;
	protected int max_diarias; //maximo de dias q pode receber
	protected int qtd_diarias; //maximo de dirias q ja recebeu
	protected double bonus; //qnt de bonu recebeu
	protected double salario;
	
	Funcionario(String nome, int max_diarias) { //metodo contrutor 
		this.nome = nome;
		this.max_diarias = max_diarias;
		this.qtd_diarias = 0;
		this.bonus = 0;
		this.salario = 0;
	}

	public void adicionarDiaria() { //metodo adicionar diaria 
		//vendo se a quantidade maxima de diras eh maior que a quantidade de diaria do caba
		if(this.getQtd_diarias() <= this.getMax_diarias()) { //senao for, então pode ter diaira
			this.setSalario(this.getSalario() + 100); //adicionando 100 ao salario
			qtd_diarias++; //e aumetando a quantidade de diarias
		}
		else {//senao, significa que a diaria eh maior que a permitida 
			System.out.println("Limite de diarias atigindas");
		}
	}
	
	public void adicionarBonus(double bonus) {//metodo para adicionar bonus
		this.setSalario(this.getSalario() + bonus ); //adicionando o bonus ao salario
	}
	
	abstract double calcSalario(); //metodo abstrato para calcular o salario
	
	//set e get
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMax_diarias() {
		return max_diarias;
	}
	public void setMax_diarias(int max_diarias) {
		this.max_diarias = max_diarias;
	}
	public int getQtd_diarias() {
		return qtd_diarias;
	}
	public void setQtd_diarias(int qtd_diarias) {
		this.qtd_diarias = qtd_diarias;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}

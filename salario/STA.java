package salario;

public class STA extends Funcionario {
private int nivel;
	
	STA(String nome, int nivel) {
		super(nome, 1);
		this.nivel = nivel;
	}
	
	@Override
	public double calcSalario() {//metodo calculando o salario
		double valor = getQtd_diarias() * 100 + getBonus();//somano as diarias + o bonus
		valor += (3000 + (300 * nivel)); //adicionado 3000 e somando com 300 * nivel do caba
		return valor;//retornando o valor real e oficial 
	}
	
	public void adicionarDiaria() {//metodo adicionar diaria
		//vendo se a quantidade maxima de diras eh maior que a quantidade de diaria do caba
		if(this.getQtd_diarias() <= this.getMax_diarias()) { //senao for, então pode ter diaira
			this.setSalario(this.getSalario() + 100); //adicionando 100 ao salario
			qtd_diarias++; //e aumetando a quantidade de diarias
		}
		else {//senao, significa que a diaria eh maior que a permitida 
			System.out.println("Limite de diarias atigindas");
		}
	}
	
	public void adicionarBonus(double bonus) {//metodo adicionar bonus
		this.setSalario(this.getSalario() + bonus ); //adicioando ao salario o bonus
	}
	
	@Override
	public String toString() {
		this.salario = calcSalario() + getBonus(); //dizendo que o salario eh igual ao calculo do salario + os bonus
		return "\nSTA " + this.getNome() + ", nivel " + this.getNivel() + ", salario: " + this.getSalario();
	}
	
	//set e get
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}

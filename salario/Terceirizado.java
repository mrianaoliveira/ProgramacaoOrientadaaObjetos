package salario;

public class Terceirizado  extends Funcionario{
	private int horas_trab;
	private boolean insalubre;
	
	Terceirizado(String nome, int horas_trab, boolean insalubre) {//construtor
		super(nome, 0);//sobrepondo o construtor do funcionario
		this.horas_trab = horas_trab;
		this.insalubre = insalubre;
	}
	
	@Override
	public double calcSalario() {//metodo calculando salario
		//o salario de terceirizado eh calculo multiplicado as horas por 4
		this.setSalario(4 * this.getHoras_trab());
		if(this.insalubre == true) {// se for insalubre
			this.setSalario(this.getSalario() + 500 + this.getBonus());//significa que sera adicionado 500 na conta do homi
			//ps: nao entendi o que siginifica esse insalubre
		}
		return this.getSalario();//retornando o salario 
	}
	
	public void adicionarDiaria() {//meotod adicionando diaria
		System.out.println("\nfail: terceirizado nao pode receber diaria");//tercerizado nao pode receber diaria :(
	}
	
	public void adicionarBonus(double bonus) {//adicioanr bonus
		this.setSalario(this.getSalario() + bonus );//adicioando ao salario o bonus
	}
	
	public String toString() {
		this.salario = calcSalario() + getBonus();//dizendo que o salario eh igual ao calculo do salario + os bonus
		return "\nTerceirizado " + this.getNome() + ", horas trabalhadas " + this.getHoras_trab() + ", insalubre? "
			+ this.isInsalubre() + ", salario: " + this.getSalario();
	}
	
	//get e set
	public int getHoras_trab() {
		return horas_trab;
	}
	public void setHoras_trab(int horas_trab) {
		this.horas_trab = horas_trab;
	}
	public boolean isInsalubre() {
		return insalubre;
	}
	public void setInsalubre(boolean insalubre) {
		this.insalubre = insalubre;
	}
}

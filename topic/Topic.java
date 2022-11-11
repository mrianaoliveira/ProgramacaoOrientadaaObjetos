package topic;

import java.util.ArrayList;

public class Topic {
	ArrayList<Pass> passageiros;
	int capacidade, preferenciais;
	
	public Topic(int capacidade, int preferenciais) {
		passageiros = new ArrayList<Pass>();
		this.capacidade = capacidade;
		this.preferenciais = preferenciais;
		for (int i = 0; i < capacidade; i++) { 
			passageiros.add(null);
		}
	}

	public boolean verificarCheio() { 
		for (Pass cheio : passageiros) { 
			if (cheio == null)  
				return false;
		}
		return true;  
	}

	public boolean verificarNome(String nome, Pass passageiro) { 
		for (int d = 0; d < capacidade; d++) {
			if (passageiros.get(d) != null && passageiros.get(d).getNome().contentEquals(passageiro.getNome()))
				return true; 
		}
		return false;
	}

	public void subir(Pass passageiro) {
		if (verificarNome(passageiro.getNome(), passageiro)) { 
			System.out.println("\nO homi já existe\n");
		} else { 
			if (verificarCheio()) { 
				System.out.println("\nA topic está cheia bb");
			} else {
				if (passageiro.getIdade() >= 60) { 
					for (int i = 0; i < capacidade; i++) {
						if (i < preferenciais) { 
							if (passageiros.get(i) == null) {
								passageiros.set(i, passageiro);  
								break;
							}
						} else if (i >= preferenciais) { 
							if (passageiros.get(i) == null) { 
								passageiros.set(i, passageiro); 
								break;
							}
						}
					}
				} else if (passageiro.getIdade() < 60) {
					for (int i = 0; i < capacidade; i++) { 
						if (i >= preferenciais) { 
							if (passageiros.get(i) == null) { 
								passageiros.set(i, passageiro);
								break;
							}
						} else if (passageiros.get(capacidade - 1) != null) { 
							for (int x = 0; x < preferenciais; x++) { 
								if (passageiros.get(x) == null) { 
									passageiros.set(x, passageiro); 
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	public void descer(String nome) {
		for (int i = 0; i < passageiros.size(); i++) {
			if (passageiros.get(i) != null && passageiros.get(i).getNome().contentEquals(nome)) { 
				System.out.println("\nO caba desceu"); 
				passageiros.set(i, null); 
				break;
			} else if (i == capacidade - 1) {
				if (passageiros.get(i) == null  || passageiros.get(i)!= null && passageiros.get(i).getNome().contentEquals(nome) == false ) { //e se não for igual {
					System.out.println("\nMeu patão, esse caba ta aqui nao "); 

				}
			}
		}
	}

	@Override
	public String toString() {
		String out = "[ ";
		for (int i = 0; i < capacidade; i++) {
			if (i < preferenciais) { 
				if (passageiros.get(i) != null) { 
					out += passageiros.get(i) + " "; 
				} else {
					out += "@ "; 				}
			} else {
				if (passageiros.get(i) != null) { 
					out += passageiros.get(i) + " "; 
				} else { 
					out += "= "; 
				}
			}
		}
		out += "]";
		return out;
	}
}	

package agenda2;

import java.util.ArrayList;

public class Contact {
	private String name;
	private ArrayList<Fone> fones;
	
	public Contact(String name) {
		this.name = name;
		this.fones = new ArrayList<Fone>();
	}

	public void addFone(String label, String number) {//meotodo adicionando o fone
		if(Fone.validate(number) == false) { //vendo se o numero eh numero pra ser telefonado
			System.out.println("fone invalido"); //se nao, não eh um numero telefonável
			return;
		} //caso o contrario
		fones.add(new Fone(label, name));//sera adicionando o nome e a operadora no array de fones
	}
	
	public void rmFone(String name, int index) {
		for(int i =0; i < fones.size(); i++) {
			if(i == index) {
				fones.remove(index);
			}
		}
	}

	@Override
	public String toString() { //printar do jeito que pede
		String resultado ="- " + this.name;
		if(fones.size() > 0) {
			resultado += " ";
			for(int i = 0; i < fones.size(); i++) {
				resultado += "[" + i + ":" + this.fones + "] ";
			}
		}
		return resultado + "\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Fone> getFone() {
		return fones;
	}

	public void setFone(ArrayList<Fone> fone) {
		this.fones = fone;
	}

}
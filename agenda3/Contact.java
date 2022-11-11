package agenda3;

import agenda3.Fone;
import java.util.ArrayList;
import java.util.List;

public class Contact {
	private String name;
	private boolean starred;
	private ArrayList<Fone> fones;
	
	
	public Contact(String name) { //metodo construtor 
		this.name = name;
		this.starred = false; //o favorito
		this.fones = new ArrayList<Fone>(); //inicalizando o array
	}
	
	public void addFone(String label, String number) { 
		//meotodo para adioconar o fone
		Fone f = new Fone(label, number); //criando um novo fone
		if(Fone.validate(number) == false) { //vendo se eh validado
			System.out.println("numero invalido"); //vendo que eh invalio o numero
		}
		else {//se nao, eh valido o numero 
			this.fones.add(f); //adicionando esse fone
		}
	}
	
	public void rmFone(int index) { //meotodo para remover o fone
		for(int i =0; i < fones.size(); i++) { //o i irá percorrer todo os numeros
			if(i == index) { // se o i for igual ao numero que quero remover
				this.fones.remove(index);//ira remover do fone
			}
			else { //se nao
				System.out.println("esse fone nao exitse"); //significa que o fone nao existe
			}
		}
	}
	
	public void setBookmark(boolean value) {
		//metodo para favoritar
		this.starred = value;
		//se o que quero for igual ao valor{no caso true}, era favoritar
	}
	
	@Override
	public String toString() {
		String resul = ""; //definindo uma strin para poder printar
		if(this.isStarred()) { //se os isStarred for true, signifca que é favorito o numero
			resul += "@ " +this.name;//então adicionara o @ na frente do nome
		}
		else {// senoa
			resul += "- " + this.name;//siginifca que não eh favorito e ira printar "-" na frente
		}
		if(fones.size() > 0) { //olhando todo o fone
			for(int i = 0; i < fones.size(); i++) {//pecorrendo o fone, pra ver se não tem o mesmo fone da mesma pessoa
				resul += "["+ i + ":" +this.fones.get(i).toString() + "]";
				//se sim, ira aparecer 0 e 1 na frente {caso tenha dois fones}
			}
		}
		return resul; //imprindo tudo lindo do jieto q pede o exercicio
	}
	
	//metodo get e sets
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean isStarred() {
		//aqui é o get, porque retorna, no caso, o true, definido lá em cima
		return starred;
		//pra poder ser favorito 
	}
	
	public void setStarred(boolean starred) {
		this.starred = starred;
	}
	
	public ArrayList<Fone> getFone() {
		return fones;
	}
	
	public void setFone(List<Fone> fone) {
		for(Fone f : fone  ){
			this.fones.add(f);
		}
		
	}
}
package anotacoes;

public class Note {
	
	private String title, contenet;
	
	Note(String title, String contenet) {
		this.title = title;
		this.contenet = contenet;
		//construtor
	}
	
	public String toString() {//a toString pra sair lindo
		return this.getTitle() + ":" + this.getContenet();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContenet() {
		return contenet;
	}

	public void setContenet(String contenet) {
		this.contenet = contenet;
	}
}

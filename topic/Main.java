package topic;

public class Main {

	public static void main(String[] args) {
		Topic topic = new Topic(5, 2);
		System.out.println(topic);
	
		topic.subir(new Pass("davi", 17));
		System.out.println(topic);
		topic.subir(new Pass("joao", 103));
		System.out.println(topic);
		topic.subir(new Pass("ana", 35));
		System.out.println(topic);
		topic.subir(new Pass("rex", 20));
		topic.subir(new Pass("bia", 16));
		System.out.println(topic);
			
		topic.descer("davi");
		System.out.println(topic);
		topic.subir(new Pass("aragao", 96));
		System.out.println(topic);
			
		topic.subir(new Pass("lucas", 23));	
		topic.descer("marcelo");
		topic.descer("ana");
		topic.subir(new Pass("bia", 16));	
		System.out.println(topic);
			
	}

}


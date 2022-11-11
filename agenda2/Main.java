package agenda2;

import java.util.ArrayList;
import java.util.Arrays;
import agenda2.Fone;

public class Main {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		agenda.addContact("eva", Arrays.asList(new Fone("oio", 8585), new Fone("cla", 9999)));
		agenda.addContact("ana", Arrays.asList(new Fone("Tim", 3434)));
		agenda.addContact("bia", Arrays.asList(new Fone("viv", 5454)));
		agenda.addContact("ana", Arrays.asList(new Fone("cas", 4567), new Fone("oio", 8754)));
		System.out.println(agenda);
		/*
		- ana [0:tim:3434] [1:cas:4567] [2:oio:8754]
		- bia [0:viv:5454]
		- eva [0:oio:8585] [1:cla:9999]
		*/
		System.out.println();
		//case removendo telefone
		agenda.rmFone("ana", 0);
		System.out.println(agenda);
		/*
		- ana [0:cas:4567] [1:oio:8754]
		- bia [0:viv:5454]
		- eva [0:oio:8585] [1:cla:9999]
		*/
		System.out.println();
		//case removendo contato
		agenda.rmContact("bia");
		System.out.println(agenda);
		/*
		- ana [0:cas:4567] [1:oio:8754]
		- eva [0:oio:8585] [1:cla:9999]
		*/
		System.out.println();
		agenda.addContact("ava", Arrays.asList(new Fone("viv", 5454)));
		agenda.addContact("rui", Arrays.asList(new Fone("viv", 2222),new Fone("oio", 9991)));
		agenda.addContact("zac", Arrays.asList(new Fone("rec", 3131)));
		System.out.println(agenda);
		/*
		- ana [0:cas:4567] [1:oio:8754]
		- ava [0:tim:5454]
		- eva [0:oio:8585] [1:cla:9999]
		- rui [0:viv:2222] [1:oio:9991]
		- zac [0:rec:3131]
		*/
		System.out.println();
		//case busca por padrao
		for(Contact contato : agenda.search("va")){
		    System.out.println(contato);
		}
		System.out.println();
		
		/*
		- ava [0:tim:5454]
		- eva [0:oio:8585] [1:cla:9999]
		*/
		for(Contact contato : agenda.search("999")){
		    System.out.println(contato);
		}
		System.out.println();
		/*
		- eva [0:oio:8585] [1:cla:9999]
		- rui [0:viv:2222] [1:oio:9991]
		*/

	}

}
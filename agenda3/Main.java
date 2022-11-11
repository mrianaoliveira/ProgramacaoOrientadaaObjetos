package agenda3;

import agenda3.Agenda;
import agenda3.Contact;
import agenda3.Fone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		agenda.addContact("eva", Arrays.asList(new Fone("oio", 8585), new Fone("cla", 9999)));
		agenda.addContact("ana", Arrays.asList(new Fone("Tim", 3434)));
		agenda.addContact("bia", Arrays.asList(new Fone("viv", 5454)));
		agenda.addContact("ana", Arrays.asList(new Fone("cas", 4567), new Fone("oio", 8754)));
		agenda.addContact("rui", Arrays.asList(new Fone("casa", 3233))); //adicionado esse, porque na original não tinha
		agenda.addContact("zac", Arrays.asList(new Fone("fixo", 3131))); //nme esse

		System.out.println(agenda);
		
		/*
		- ana [0:casa:4567][1:oi:8754]
		- bia [0:vivo:5454]
		- eva [0:oi:8585][1:claro:9999]
		- rui [0:casa:3233]
		- zac [0:fixo:3131]
		*/

		//case favoritando
		agenda.star("eva");
		agenda.star("ana");
		agenda.star("ana");
		agenda.star("zac");
		agenda.star("rex");
		//fail: contato rex nao existe
		System.out.println(agenda);
		/*
		@ ana [0:casa:4567][1:oi:8754]
		- bia [0:vivo:5454]
		@ eva [0:oi:8585][1:claro:9999]
		- rui [0:casa:3233]
		@ zac [0:fixo:3131]
		*/

		//case lista de favoritos
		for(Contact fav : agenda.getStarred()){
		    System.out.println(fav);
		}
		/*
		@ ana [0:casa:4567][1:oi:8754]
		@ eva [0:oi:8585][1:claro:9999]
		@ zac [0:fixo:3131]
		*/
        System.out.println("");

		//case removendo contato
		agenda.rmContact("zac");
		System.out.println(agenda);
		/*
		@ ana [0:casa:4567][1:oi:8754]
		- bia [0:vivo:5454]
		@ eva [0:oi:8585][1:claro:9999]
		- rui [0:casa:3233]
		*/
		for(Contact fav : agenda.getStarred()){
		    System.out.println(fav);
		}
		/*
		@ ana [0:casa:4567][1:oi:8754]
		@ eva [0:oi:8585][1:claro:9999]
		*/

		//case desfavoritando
		agenda.unstar("ana");
		for(Contact fav : agenda.getStarred()){
		    System.out.println(fav);
		}
		//@ eva [0:oi:8585][1:claro:9999]
		System.out.println(agenda);
		/*
		- ana [0:casa:4567][1:oi:8754]
		- bia [0:vivo:5454]
		@ eva [0:oi:8585][1:claro:9999]
		- rui [0:casa:3233]
		*/
	}

}
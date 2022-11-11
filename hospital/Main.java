package hospital;

public class Main {

	public static void main(String[] args) {
		
		Hospital hospital = new Hospital();
		hospital.addPaciente(new Paciente("Alvis", "avc"));
		hospital.addPaciente(new Paciente("Fred", "fratura"));
		hospital.addPaciente(new Paciente("Goku", "hemorragia"));
		hospital.addPaciente(new Paciente("Silva", "sinusite"));
		System.out.println(hospital);
		
		hospital.addMedico(new Medico("Dr. Bisturi", "Cirurgia"));
		hospital.addMedico(new Medico("Dr. Facada", "Cirurgia"));
		hospital.addMedico(new Medico("Dr. Snif", "Alergologia"));
		System.out.println(hospital);
		
		hospital.vincular("Dr. Bisturi", "Alvis");
		hospital.vincular("Dr. Bisturir", "Fred");
		hospital.vincular("Dr.Bisturi", "Goku");
		hospital.vincular("Dr. Snif", "Alvis");
		hospital.vincular("Dr. Snif", "Silva");
		hospital.vincular("Dr. Facada", "goku");
		System.out.println(hospital);
		
		//brincando com a main
		System.out.println("***");
		hospital.removerPaciente("Alvis");
		hospital.addPaciente(new Paciente("Bee Gees", "Nao para de dancar musicas dos anos 70"));
		hospital.addMedico(new Medico("Stayin Alive", "Bee Gees"));
		System.out.println(hospital);
	}

}

package hospital;

import java.util.Collection;

public interface IMedico {
	//do jeito q tem la na uml
	String getId();
	void addPaciente(IPaciente paciente);
	void removerPaciente(String idPaciente);
	String getClasse();
	Collection<IPaciente> getPaciente();	
}

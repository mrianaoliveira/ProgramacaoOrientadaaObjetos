package hospital;

import java.util.Collection;

public interface IPaciente {
	//do jeito lá da uml
	String getId();
	void addMedico(IMedico medico);
	void removerMedico(String idMedico);
	String getDiagnostico();
	Collection<IMedico> getMedicos();
}

package models;

public class Pajaro extends Animal {

	public Pajaro(String codigoDeIdentificacion, String especie, String paisDeProcedencia, String observaciones,
			Sexo sexo, String alimentacionBasica) {
		super(codigoDeIdentificacion, especie, paisDeProcedencia, observaciones, sexo, alimentacionBasica);
		tipo = Tipo.PAJARO;
	}

}

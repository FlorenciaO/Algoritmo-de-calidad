package grupo8;

public enum Resultado {
	
	Mala, Buena, Excelente, RazonablementeAceptable;
	
	public String toString() {
		switch(this) {
		case Mala:
			return "Mala";
		case Buena:
			return "Buena";
		case Excelente:
			return "Excelente";
		case RazonablementeAceptable:
			return "Razonablemente Aceptable";
		default:
			return null;
		}
	}
}

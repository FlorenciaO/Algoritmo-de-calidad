package grupo8;

public class Evaluacion {
	private static Evaluacion INSTANCE = new Evaluacion();
	
	public Resultado rFuncionabilidad;
	public Resultado rFiabilidad;
	public Resultado rEficiencia;
	public Resultado rPortabilidad;
	public Resultado rUsabilidad;
	public Resultado rMantenibilidad;
	public Resultado rFinal;

    private Evaluacion(){}

    public static Evaluacion getInstance() {
        return INSTANCE;
    }
    
    public Resultado calcularPuntajeFinal() {
    	if(rFuncionabilidad == Resultado.Mala || rFiabilidad == Resultado.Mala || rEficiencia == Resultado.Mala 
    			|| rPortabilidad == Resultado.Mala || rUsabilidad == Resultado.Mala || rMantenibilidad == Resultado.Mala) {
    		rFinal = Resultado.Mala;
    	} else if(cantidadExcelente() >= 4){
    		rFinal = Resultado.Excelente;
    	} else {
    		rFinal = Resultado.RazonablementeAceptable;
    	}
    	return rFinal;
    }
    
    private int cantidadExcelente() {
    	int cant = 0;
    	
    	cant = rFuncionabilidad == Resultado.Excelente ? cant + 1: cant;
    	cant = rFiabilidad == Resultado.Excelente ? cant + 1: cant;
    	cant = rEficiencia == Resultado.Excelente ? cant + 1: cant;
    	cant = rPortabilidad == Resultado.Excelente ? cant + 1: cant;
    	cant = rUsabilidad == Resultado.Excelente ? cant + 1: cant;
    	cant = rMantenibilidad == Resultado.Excelente ? cant + 1: cant;
    	
    	return cant;
    }
}

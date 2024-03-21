/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public abstract class Dinero {
   	//inserta código aquí
	
	protected double dinero;
	protected String description;
	
	
	public double getDinero() { // Getter
		
        return dinero;
    }

    public void setDinero(double dinero) { // Setter
    	
        this.dinero = dinero;
    }

    public String getDescription() { // Getter
    	
        return description;
    }

    public void setDescription(String description) { // Setter
    	
        this.description = description;
    }
}

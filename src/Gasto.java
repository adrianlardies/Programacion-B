/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Gasto extends Dinero {
   	//inserta código aquí
	
	public Gasto(double gasto, String description){
		
        setDinero(gasto);
        setDescription(description);
    }

    public String toString() {
    	
        String monedaFormateada = Main.formatearMoneda(getDinero());
        return "Gasto: "+getDescription()+", cantidad: "+monedaFormateada;
    }
}

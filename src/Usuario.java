/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Usuario {
   	//inserta código aquí
	
	private String nombre;
    private int edad;
    private String DNI;
    
    
    public Usuario() {
    }
    
    public String getNombre() {
    	
        return nombre;
    }

    public void setNombre(String nombre) {
    	
        this.nombre = nombre;
    }
    
    public int getEdad() {
    	
        return edad;
    }

    public void setEdad(int edad) {
    	
        this.edad = edad;
    }
    
    public String getDNI() {
    	
        return DNI;
    }
    
    public boolean setDNI(String DNI) {
    	
    	String regex="^\\d{8}-?[a-z]$";
    	if(DNI.matches(regex)) {
    		
    		this.DNI=DNI;
    		return true;
    	} else {
    		
    		return false;
    	}
    }
    
    public String toString() {
        return "Datos del usuario" +
                "\n\tNombre: " + nombre +
                "\n\tEdad: " + edad +
                "\n\tDNI: " + DNI;
    }
}


import java.util.ArrayList;
import java.util.List;
/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Cuenta {

   	//inserta código aquí
	
	private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos = new ArrayList<>();
    private List<Ingreso> ingresos = new ArrayList<>();
    
    
    public Cuenta(Usuario usuario){
 
        this.setSaldo(0);
        this.setUsuario(usuario);
    }
    
    public double getSaldo() {
    	
        return saldo;
    }

    public void setSaldo(double saldo) {
    	
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
    	
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
    	
        this.usuario = usuario;
    }
    
    public double addIngresos(String description, double cantidad) {
    	
        ingresos.add(new Ingreso(cantidad, description));
        saldo += cantidad;
        return saldo;
    }

    public double addGastos(String description, double cantidad) throws GastoException {
        if(cantidad > saldo){
            throw new GastoException();
        }
        gastos.add(new Gasto(cantidad, description));
        saldo -= cantidad;
        return saldo;
    }

    public List<Ingreso> getIngresos() {
    	
        return ingresos;
    }

    public List<Gasto> getGastos() {
    	
        return gastos;
    }

    public String toString() {
    	
        return "Informaciones de la cuenta." +
                "\n\t" + usuario +
                "\n\tSaldo: " + saldo;
    }
}

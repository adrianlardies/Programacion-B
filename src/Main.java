import java.util.*;
import java.text.*;
/** PAC DESARROLLO M03B 1S2324
 *  Sigue las especificaciones del enunciado de la pac de Desarrollo
 *  No se puede importar ninguna otra clase, dentro de esta clase.
 *  Obligatorio utilizar esta plantilla
 *  
 */
public class Main {

		public static void main(String[] args) {
    	//inserta código aquí
    	
    	Scanner scanner = new Scanner(System.in);
        scanner.useLocale(new Locale("es", "ES"));
        Usuario usuario = LeerUsuario(scanner);

        Cuenta cuenta = new Cuenta(usuario);
        boolean terminar = false;
        while(!terminar){
        	
        	/**** Mostrar las distintas opciones validas del Menu de Opciones ****/
            System.out.println("Realizar una nueva acción:");
            System.out.println("(1) Introducir un nuevo gasto");
            System.out.println("(2) Introducir un nuevo ingreso");
            System.out.println("(3) Mostrar gastos");
            System.out.println("(4) Mostrar ingresos");
            System.out.println("(5) Mostrar saldo");
            System.out.println("(0) Salir");
            terminar = mostrarMenu(scanner, cuenta);
        }
        scanner.close();
    }
    
    	private static void finPrograma() {
    	
        System.out.println("Fin del programa.");
        System.out.print("Gracias por utilizar la aplicación M03B en el curso 2s2223.");
    }

    	private static boolean mostrarMenu(Scanner scanner, Cuenta cuenta) {
    	//inserta código aquí
        	
        	int eleccionMenu = Integer.parseInt(scanner.nextLine());

            switch (eleccionMenu){
                case 0:
                    finPrograma();
                    return true;
                case 1:
                    addGastos(cuenta, scanner);
                    break;
                case 2:
                    addIngresos(cuenta, scanner);
                    break;
                case 3:
                    imprimirGastos(cuenta);
                    break;
                case 4:
                    imprimirIngresos(cuenta);
                    break;
                case 5:
                    mostrarSaldo(cuenta);
                    break;
                default:
                    System.out.println("Elección incorrecta.");
            }
            return false;
    }
        
/**** Función que lee por teclado los datos del usuario y los devuelve como un objeto de tipo Usuario. ****/
        
    	private static Usuario LeerUsuario(Scanner scanner){
    	
    	Usuario usuario = new Usuario();
    	
    	//inserta código aquí
    	
    	System.out.print("Introduzca un nombre : ");
        String nombre = scanner.nextLine();
        usuario.setNombre(nombre);

        System.out.print("Introduzca la edad : ");
        int edad = Integer.parseInt(scanner.nextLine());
        usuario.setEdad(edad);

        boolean esDNIValido;
        do{
            System.out.print("Introduzca su DNI : ");
            String DNI = scanner.nextLine();
            esDNIValido = usuario.setDNI(DNI);
            if(!esDNIValido){
                System.out.println("DNI introducido incorrecto");
            }
        }while(!esDNIValido);

        System.out.println("Usuario Creado correctamente");
        System.out.println(usuario);

        return usuario;
    }

    
/**** Funcion que lee por teclado un ingreso, lo agrega a la lista de ingresos y muestra mensaje ****/
    	
    	private static void addIngresos(Cuenta cuenta, Scanner scanner) {
        
    	System.out.println("Introduzca la descripción del ingreso: ");
        String descripcion = scanner.nextLine();
        System.out.println("Introduce la cantidad del ingreso: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        double saldoRestante = cuenta.addIngresos(descripcion, cantidad);
        System.out.println("Saldo: " + formatearMoneda(saldoRestante));
    }

    
/**** Muestra por pantalla el listado de ingresos ****/
    
    	private static void imprimirIngresos(Cuenta cuenta){
    	List<Ingreso> ingresos = cuenta.getIngresos();
        for(Ingreso ingreso : ingresos){
            System.out.println(ingreso);
        } 
    }

/**** Funcion que lee por teclado un Gasto y lo agrega a la lista de gastos  y muestra mensaje ****/
    
    	private static void addGastos(Cuenta cuenta, Scanner scanner) {
        try {
            System.out.println("Introduzca la descripción del gasto: ");
            String descripcion = scanner.nextLine();
            System.out.println("Introduzca la cantidad del gasto: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();
            double saldoRestante = cuenta.addGastos(descripcion, cantidad);
            System.out.println("Saldo: " + formatearMoneda(saldoRestante));
        } catch (GastoException e) {
            System.err.println(e.getMessage());
        }
    }

/**** Muestra por pantalla el listado de gastos ****/
    
    	private static void imprimirGastos(Cuenta cuenta){
    	List<Gasto> gastos = cuenta.getGastos();
        for(Gasto gasto : gastos){
            System.out.println(gasto);
        }
    }
    
    	public static String formatearMoneda(double monedaDouble){
        DecimalFormat df = new DecimalFormat("#,#00.00");
        String result = df.format(monedaDouble);
        return result.concat("€");
    }
    
        private static void mostrarSaldo(Cuenta cuenta) {
        System.out.println("Saldo restante: " + formatearMoneda(cuenta.getSaldo()));
        }
}

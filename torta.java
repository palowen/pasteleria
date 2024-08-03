import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class torta {
    Scanner grinch= new Scanner(System.in);
    String[] credenciales = {"paul owen","p","1"};

    String [] tortas={"TORTA TRES LECHE","TORTA SELVA NEGRA", "TORTA DE CHOCOLAYR", "TORTA DE CHOLATE Y VAINILLA"};
    String [] extras={"pan de leche", "pan sarnitas", "pan chachitos", "pan carioca"};


    double[] preciosTortas = {50, 60, 55, 60};
    double[] preciosTamanos = {0.0, 10.0, 20.0};
    double[] preciosExtras = {0.5, 0.5, 0.5, 0.5};
    String[] nombresTortas = {"TORTA TRES LECHES s/50", "TORTA SELVA NEGRA s/60", "TORTA DE CHOCOLATE s/55", "TORTA DE CHOLATE Y VAINILLA s/60"};
    String[] nombresTamanos = {"pequeño + s/00", "mediano + s/10", "grande + s/20"};

    Random random = new Random();

    int s= random.nextInt(extras.length);
    double [] precio={10,0.18};
    double[] subtotal_extra={0,0,0,0};
    double igv, subtotal,totalpagar;
    int [] carrito =new int[tortas.length];
    int[] carritoTamano = new int[tortas.length];
    int [] carrito_extra=new int[extras.length];
    int[] cantidadPorTorta = new int[tortas.length];
    String respuesta;
    int opcion, cantidad;

    public String MenuPrincipal(){

        System.out.println("Ingrese su usuario");
        String usuario=grinch.nextLine();
        System.out.println("Ingrese su contraseña");
        String contraseña= grinch.nextLine();
        if(usuario.equals(credenciales[1])&&contraseña.equals(credenciales[2])){
            System.out.println("---------Bienvenido a la pasteleria-----------");
            System.out.println("Marque alguna de las siguientes opciones");
            System.out.println(" 1.- TORTA Y PASTELES");
            System.out.println(" 2.- panaderia");
            System.out.println(" 3.- Libro de reclamaciones");
            opcion=grinch.nextInt();
            grinch.nextLine();
            switch (opcion){
                case 1:
                    this.Comprartorta();
                    break;

                case 2:
                    this.ComprarExtra();
                    break;

                case 3:

                    break;

                default:
                    System.out.println("Opcion no válida");
                    this.MenuPrincipal();
                    break;

            }
        }
        else {
            System.out.println("Usuario/Contraseña no válidos");}




        return null;
    }






    public void Comprartorta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------- TORTAS -------");
        System.out.println("Las Tortas disponibles el día de hoy:");
        for (int i = 0; i < nombresTortas.length; i++) {
            System.out.println("Opción " + (i + 1) + ": " + nombresTortas[i]);
        }
        System.out.print("Seleccione su menú a comprar: ");
        int opcionTorta = sc.nextInt() - 1;

        System.out.println("Seleccione el tamaño:");
        for (int i = 0; i < nombresTamanos.length; i++) {
            System.out.println("Opción " + (i + 1) + ": " + nombresTamanos[i]);
        }
        int opcionTamano = sc.nextInt() - 1;

        System.out.print("¿Cuántos comprará? Ingrese la cantidad: ");
        int cantidad = sc.nextInt();

        double precioTotal = (preciosTortas[opcionTorta] + preciosTamanos[opcionTamano]) * cantidad;
        subtotal += precioTotal;
        carrito[opcionTorta] += cantidad;
        carritoTamano[opcionTorta] = opcionTamano;
        cantidadPorTorta[opcionTorta] = cantidad;

        System.out.println("Ud ha pedido " + cantidad + " torta de " + nombresTortas[opcionTorta] + " (" + nombresTamanos[opcionTamano] + ")");
        System.out.println("Desea elegir otro menú más? 1 SI/ 2 NO/ 3 Menu Principal");
        int respuesta = sc.nextInt();

        if (respuesta == 1) {
            Comprartorta();
        } else if (respuesta == 2) {
            PagoMenus();
        } else {
            MenuPrincipal();
        }


    }

    public void PagoMenus() {
        System.out.println("----BOLETA DE VENTA---------");
        System.out.println("Detalles de su compra:");
        for (int i = 0; i < tortas.length; i++) {
            if (carrito[i] > 0) {
                double precioItem = (preciosTortas[i] + preciosTamanos[carritoTamano[i]]) * carrito[i];
                System.out.println("Torta: " + nombresTortas[i]);

                System.out.println("Tamaño: " + nombresTamanos[carritoTamano[i]]);

                System.out.println("Cantidad: " + carrito[i]);
                System.out.println("subtotal: " + precioItem);
                System.out.println(" " +
                        "       ,   ,   ,\n" +
                        "      /|  /|  /|\n" +
                        "     / | / | / |\n" +
                        "    *--|--*--|--*   \n" +
                        "    |  |  |  |  |  \n" +
                        "    |  |  |  |  |  \n" +
                        "    *--*--*--*--*\n");
            }
        }
        for (int i = 0; i < extras.length; i++) {
            if (carrito_extra[i] > 0) {
                double precioItem = carrito_extra[i] * preciosExtras[i];
                System.out.println("Extra: " + extras[i]);
                System.out.println("Cantidad: " + carrito_extra[i]);
                System.out.println("Precio: " + precioItem);
            }
        }
        subtotal = Arrays.stream(carrito).mapToDouble(i -> (preciosTortas[i] + preciosTamanos[carritoTamano[i]]) * i).sum() +
                Arrays.stream(subtotal_extra).sum();

        igv = subtotal * precio[1];
        totalpagar = subtotal + igv;
        System.out.println("SUBTOTAL: " + subtotal);
        System.out.println("IGV: " + igv);
        System.out.println("TOTAL: " + totalpagar);

        System.out.println("Seleccione su método de pago");
        System.out.println("Opción 1: Efectivo");
        System.out.println("Opción 2: Tarjeta");
        int opcpago = grinch.nextInt();
        grinch.nextLine();

        switch (opcpago) {
            case 1:
                System.out.println("Ingrese el monto a pagar:");
                double montopagar = grinch.nextDouble();
                if (montopagar >= totalpagar) {
                    double vuelto = montopagar - totalpagar;
                    System.out.println("Pago exitoso. Su vuelto es: " + vuelto);
                } else {
                    System.out.println("Monto insuficiente. Falta: " + (totalpagar - montopagar));
                }
                break;

            case 2:
                grinch.nextLine();
                System.out.println("Ingrese los 16 dígitos de su tarjeta XXXX XXXX XXXX XXXX ");
                String tarjeta= grinch.nextLine().trim();
                if(tarjeta.length()==19||tarjeta.matches("[4-5]\\d{3}\\d{4}\\d{4}\\d{4}")){
                    System.out.println("Tarjeta valida");
                    System.out.println("Ingrese los 3 dígitos del CVV");
                    String cvv=grinch.nextLine().trim();
                    if(cvv.length()==3||cvv.matches("\\d{3}")){
                        System.out.println("CVV Válido, pago realizado exitosamente");
                        System.out.println("Usted ya compro :"+tortas);
                    }
                }
                else{
                    System.out.println("Tarjeta no válida");
                }

                break;
            default:
        }

        ExportarBoleta();
    }
    public String ComprarExtra(){
        System.out.println("------ MENÚS DEL DÍA------------");
        System.out.println( "Seleccione su extra a comprar");
        for (int i=0; i<extras.length;i++){
            System.out.println("Opcion "+(i+1)+ " : " +extras[i]);
        }
        opcion= grinch.nextInt();
        grinch.nextLine();
        if (opcion > 0 && opcion <= extras.length) {
            System.out.println("¿Cuántos comprará? Ingrese la cantidad:");
            cantidad = grinch.nextInt();
            grinch.nextLine();

            carrito_extra[opcion - 1] += cantidad;
            subtotal_extra[opcion - 1] = carrito_extra[opcion - 1] * preciosExtras[opcion - 1];
            System.out.println("Ud ha pedido " + carrito_extra[opcion - 1] + " " + extras[opcion - 1]);

            System.out.println("¿Desea elegir otro menú más? 1 SI/ 2 NO / 3 Menu Principal");
            opcion = grinch.nextInt();
            grinch.nextLine();
            if (opcion == 1) {
                System.out.println("Volviendo a la opción de compra");
                this.ComprarExtra();
            } else if (opcion == 2) {
                this.PagoMenus();
            } else if (opcion == 3) {
                this.MenuPrincipal();
            } else {
                System.out.println("Opción no válida");
            }
        } else {
            System.out.println("Opción no válida");
            this.MenuPrincipal();
        }







        return null;
    }

    public void ExportarBoleta() {
        try {
            FileWriter writer = new FileWriter("boleta.txt");
            writer.write("----BOLETA DE VENTA---------\n");
            writer.write("Detalles de su compra:\n");
            for (int i = 0; i < tortas.length; i++) {
                if (carrito[i] > 0) {
                    double precioItem = (preciosTortas[i] + preciosTamanos[carritoTamano[i]]) * carrito[i];
                    writer.write("Torta: " + tortas[i] + "\n");
                    writer.write("Tamaño: " + nombresTamanos[carritoTamano[i]] + "\n");
                    writer.write("Cantidad: " + carrito[i] + "\n");
                    writer.write("Precio: " + precioItem + "\n");
                }
            }
            for (int i = 0; i < extras.length; i++) {
                if (carrito_extra[i] > 0) {
                    double precioItem = carrito_extra[i] * preciosExtras[i];
                    writer.write("Extra: " + extras[i] + "\n");
                    writer.write("Cantidad: " + carrito_extra[i] + "\n");
                    writer.write("Precio: " + precioItem + "\n");
                }
            }

            writer.write("SUBTOTAL: " + subtotal + "\n");
            writer.write("IGV: " + igv + "\n");
            writer.write("TOTAL: " + totalpagar + "\n");
            writer.close();
            System.out.println("Boleta exportada exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al exportar la boleta.");
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
        torta papanoel= new torta();
        papanoel.MenuPrincipal();




    }
}
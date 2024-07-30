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


    double[] preciosTortas = {30.0, 40.0, 35.0, 45.0};
    double[] preciosTamanos = {0.0, 10.0, 20.0};
    String[] nombresTortas = {"TORTA TRES LECHES s/50", "TORTA SELVA NEGRA s/60", "TORTA DE CHOCOLATE s/55", "TORTA DE CHOLATE Y VAINILLA s/60"};
    String[] nombresTamanos = {"pequeño", "mediano", "grande"};

    Random random = new Random();

    int s= random.nextInt(extras.length);
    double [] precio={10,0.18};
    double[] subtotal_extra={0,0,0,0};
    double igv, subtotal,totalpagar;
    int [] carrito =new int[tortas.length];
    int [] carrito_extra=new int[extras.length];
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
            System.out.println(" 2.- POSTRES");
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






        opcion= grinch.nextInt();
        grinch.nextLine();
        switch (opcion){

            case 1:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=grinch.nextInt();
                carrito[0]+=cantidad;
                System.out.println("Ud ha pedido "+carrito[0]+ "platos de "+tortas[0]);
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=grinch.nextInt();
                grinch.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                    this.ComprarExtra();
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }

                break;

            case 2:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=grinch.nextInt();
                carrito[1]+=cantidad;
                System.out.println("Ud ha pedido "+carrito[1]+ "torta de "+tortas[1]);

                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=grinch.nextInt();
                grinch.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                    this.ComprarExtra();
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }

                break;

            case 3:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=grinch.nextInt();

                carrito[2]+=cantidad;
                System.out.println("Ud ha pedido "+carrito[2]+ "tortas "+tortas[2]);

                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=grinch.nextInt();
                grinch.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                    this.ComprarExtra();
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }


                break;

            default:
                System.out.println("Opcion no válida");
                this.MenuPrincipal();
                break;


        }





        return ;

    }

    public double PagoMenus(){
        System.out.println("Elija las opcion:");
        System.out.println(" Marque 1 : Si esta seguro de comprar la torta");

        int opcion= grinch.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Ud eligio para el pago"+opcion);
                System.out.println("El monto a pagar es  soles");
                System.out.println("Seleccione su método de pago");
                System.out.println("Opcion 1 Efectivo");
                System.out.println("Opcion 2 Tarjeta");
                int opcpago= grinch.nextInt();
                switch(opcpago){
                    case 1:
                        System.out.println("Ingrese el monto a pagar");
                        double montopagar= grinch.nextDouble();
                        if(montopagar==preciosTortas [1] ){
                            System.out.println("Ud ya compro la torta: "+tortas);
                        }
                        else if(montopagar>1){
                            double vuelto=montopagar-50;
                            System.out.println("Ud ya compro la torta:"+tortas);
                            System.out.println("Su vuelto es: "+vuelto);
                        }
                        else if(montopagar<50&&montopagar>0){
                            double añadir= 50-montopagar;
                            System.out.println("Monto insuficiente, añadir "+añadir);
                        }
                        else {
                            System.out.println("Monto no válido");
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
                                System.out.println("Ud está torta al menus:"+tortas);
                            }
                        }
                        else{
                            System.out.println("Tarjeta no válida");
                        }

                        break;
                    default:
                }

                break;
        }
        double cantidadtotalmenus=Arrays.stream(carrito).sum();
        double subtotalextra=Arrays.stream(subtotal_extra).sum();

        double subtotal0= (cantidadtotalmenus*precio[0])+subtotalextra;
        igv= subtotal0*precio[1];
        subtotal=preciosTortas[1];
        subtotal=subtotal0-igv;


        totalpagar=subtotal+igv;
        System.out.println("----BOLETA DE VENTA---------");
        System.out.println(" SUBTOTAL :"+totalpagar);
        System.out.println(" IGV :"+igv);
        System.out.println(" TOTAL :"+totalpagar);
        this.ExportarBoleta();
        return totalpagar;
    }
    public String ComprarExtra(){
        System.out.println("------ MENÚS DEL DÍA------------");
        System.out.println( "Seleccione su extra a comprar");
        for (int i=0; i<extras.length;i++){
            System.out.println("Opcion "+(i+1)+ " : " +extras[i]);
        }
        opcion= grinch.nextInt();
        grinch.nextLine();
        switch (opcion){
            case 1:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=grinch.nextInt();
                carrito_extra[0]+=cantidad;
                System.out.println("Ud ha pedido "+carrito_extra[0]+ "platos de "+extras[0]);
                subtotal_extra[0]=carrito_extra[0]*precio[2];
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=grinch.nextInt();
                grinch.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                    this.Comprartorta();
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }

                break;

            case 2:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=grinch.nextInt();
                carrito_extra[1]+=cantidad;
                System.out.println("Ud ha pedido "+carrito_extra[1]+ "platos de "+extras[1]);
                subtotal_extra[1]=carrito_extra[1]*precio[3];
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=grinch.nextInt();
                grinch.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                    this.Comprartorta();
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }

                break;

            case 3:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=grinch.nextInt();

                carrito_extra[2]+=cantidad;
                System.out.println("Ud ha pedido "+carrito_extra[2]+ "platos de "+extras[2]);
                subtotal_extra[2]=carrito_extra[2]*precio[4];
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=grinch.nextInt();
                grinch.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                    this.Comprartorta();
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }


                break;
            case 4:
                System.out.println("¿Cuantos comprará? Ingrese la cantidad");
                cantidad=grinch.nextInt();

                carrito_extra[3]+=cantidad;
                System.out.println("Ud ha pedido "+carrito_extra[2]+ "platos de "+extras[3]);
                subtotal_extra[3]=carrito_extra[3]*precio[5];
                System.out.println("¿Desea elegir otro menú más?  1 SI/ 2 NO / 3 Menu Principal");
                opcion=grinch.nextInt();
                grinch.nextLine();
                if(opcion==1)
                {
                    System.out.println("Volviendo a la opción de compra");
                    this.Comprartorta();
                }
                else if (opcion==2){
                    this.PagoMenus();
                }
                else if (opcion==3){
                    this.MenuPrincipal();
                }
                else
                {
                    System.out.println("Opcion no válida");
                }


                break;


            default:
                System.out.println("Opcion no válida");
                this.MenuPrincipal();
                break;


        }





        return null;
    }

    public String ExportarBoleta() {
        try {
            File archivo = new File("boleta.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("----BOLETA DE VENTA---------\n");
            escritor.write(" SUBTOTAL : " + subtotal + "\n");
            escritor.write(" IGV : " + igv + "\n");
            escritor.write(" TOTAL : " + totalpagar + "\n");
            escritor.close();
            System.out.println("Boleta exportada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar la factura.");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String [] args){
        torta papanoel= new torta();
        papanoel.MenuPrincipal();




    }
}

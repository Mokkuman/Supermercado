import javax.swing.*;


public class TestSupermercado {
    public static void main(String[] args) {
        boolean salir = false;      //Bandera para salir del do while
        boolean bandera1 = false;   //Bandera para saber si hay o no productos en el sistema, al principio no hay
        //Inician variables para agregar productos
        float precio;
        String descripcion;
        float[] validar = new float[100];           //Creo el arreglo
        float[] mayor = new float[100];
        for (int i = 0; i < validar.length; i++) { //Limpio el arreglo
            validar[i] = 0;
        }
        int con=0;                                  //Saber cuantos precios unitarios hay
        int exist;
        int a=1;
        //Finalizan variables para agregar productos
        int unidadesVendidas;       //Para el metodo 2
        float ventas = 0;           //Variable para el metodo 3
        boolean bandera= false;
        int opcion,i=0,j,n=0,t=0,s=0;       //Variables para la tabla
        String datosMenu;                   //String para mostrar los datos del Menu
        Ciudad c1 = new Ciudad("Puebla");
        Ciudad c2 = new Ciudad("Guadalajara");
        Ciudad c3 = new Ciudad("Distrito Federal");     //Creamos nuestras ciudaded
        Ciudad c4 = new Ciudad("Monterrey");
        Supermercado s1 = new Supermercado();
        s1.setCiudad(c1, 0);
        s1.setCiudad(c2, 1);
        s1.setCiudad(c3, 2);
        s1.setCiudad(c4, 3);
        while(!salir) {
            datosMenu = "Sistema para administracion de ventas\n" +
                    "1.-Mostrar la lista de los precios unitarios de cada producto\n" +
                    "2.-Almacenar la informacion de las unidades vendidas en cada ciudad para cada producto\n" +
                    "3.-Mostrar las ventas totales en cada ciudad\n" +
                    "4.-Mostrar el producto mas vendido y menos vendido, la ciudad con mas ventas y menos ventas y promedio de ventas de cada ciudad por producto\n" +
                    "5.-Agregar producto\n" +
                    "6.-Salir\n";
            opcion = Integer.valueOf(JOptionPane.showInputDialog(datosMenu));
            switch (opcion) {
                case 1:
                    if(bandera == true) {
                        System.out.println("La tabla despues de las unidades vendidas es: \n");
                    }
                    System.out.print("Producto  | ");
                    System.out.print(s1.getCiudad(0).getNombre()+"          | ");
                    System.out.print(s1.getCiudad(1).getNombre()+"     | ");
                    System.out.print(s1.getCiudad(2).getNombre()+"| ");
                    System.out.print(s1.getCiudad(3).getNombre()+"       | ");
                    System.out.print("Total Unidades|\n");
                    System.out.println("______________________________________________________________________________________");
                    for (i=1; i<=s1.contador(); i++){
                        System.out.print("Producto " +i+"| ");
                        for ( j=0;j<4;j++){
                            if (s1.getCiudad(j).getProducto(i-1).getExistencias()<10){
                                System.out.print(s1.getCiudad(j).getProducto(i-1).getExistencias()+"               | ");
                            }
                            if (s1.getCiudad(j).getProducto(i-1).getExistencias()>=10&&s1.getCiudad(j).getProducto(i-1).getExistencias()<100){
                                System.out.print(s1.getCiudad(j).getProducto(i-1).getExistencias()+"              | ");
                            }
                            if (s1.getCiudad(j).getProducto(i-1).getExistencias()>=100&&s1.getCiudad(j).getProducto(i-1).getExistencias()<1000){
                                System.out.print(s1.getCiudad(j).getProducto(i-1).getExistencias()+"             | ");
                            }
                            if (s1.getCiudad(j).getProducto(i-1).getExistencias()>=1000&&s1.getCiudad(j).getProducto(i-1).getExistencias()<10000){
                                System.out.print(s1.getCiudad(j).getProducto(i-1).getExistencias()+"            | ");
                            }
                            n=n+s1.getCiudad(j).getProducto(i-1).getExistencias();
                        }
                        if (n<10){
                            System.out.print(n+"             |\n");
                        }
                        if (n>=10&&n<100){
                            System.out.print(n+"            |\n");
                        }
                        if (n>=100&&n<1000){
                            System.out.print(n+"           |\n");
                        }
                        if (n>=1000&&n<10000){
                            System.out.print(n+"          |\n");
                        }
                        t=t+n;
                        n=0;
                        System.out.println("______________________________________________________________________________________");
                    }
                    n=0;
                    System.out.print("Total     | ");
                    for ( j=0;j<4;j++){
                        for (i=1; i<=s1.contador(); i++){
                            n=n+s1.getCiudad(j).getProducto(i-1).getExistencias();
                        }
                        if (n<10){
                            System.out.print(n+"               | ");
                        }
                        if (n>=10&&n<100){
                            System.out.print(n+"              | ");
                        }
                        if (n>=100&&n<1000){
                            System.out.print(n+"             | ");
                        }
                        if (n>=1000&&n<10000){
                            System.out.print(n+"            | ");
                        }
                        n=0;
                    }
                    if (t<10){
                        System.out.print(t+"             |\n");
                    }
                    if (t>=10&&t<100){
                        System.out.print(t+"            |\n");
                    }
                    if (t>=100&&t<1000){
                        System.out.print(t+"           |\n");
                    }
                    if (t>=1000&&t<10000){
                        System.out.print(t+"          |\n");
                    }

                    t=0;

                    System.out.println("______________________________________________________________________________________");
                    for (int k = 0; k < s1.contador(); k++) {
                        System.out.print("El producto " + (k+1) + " tiene como precio unitario: ");
                        System.out.println(s1.getCiudad(0).getProducto(k).getPrecioUnitario());
                    }
                    bandera = false;
                    break;

                case 2:
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l <s1.contador() ; l++) {
                            String Mensaje = "Ingrese el numero de unidades vendidas para el Producto " + s1.getCiudad(k).getProducto(l).getId() + " en: " + s1.getCiudad(k).getNombre();
                            do{
                                unidadesVendidas = Integer.valueOf(JOptionPane.showInputDialog(Mensaje));       //Para no vender mas de lo que hay
                            }while (unidadesVendidas>s1.getCiudad(k).getProducto(l).getExistencias());
                            s1.getCiudad(k).getProducto(l).setUnidadesV(unidadesVendidas);
                            int resta= s1.getCiudad(k).getProducto(l).getExistencias() - unidadesVendidas;
                            s1.getCiudad(k).getProducto(l).setExistencias(resta);
                        }
                    }
                    bandera = true;
                    break;

                case 3:
                    int con1 = s1.contador();
                    for (int k = 0; k < 4; k++) {
                        for (int l = 1; l <= s1.contador(); l++) {
                            ventas = ventas + s1.getCiudad(k).venderProducto(l, con1);
                        }
                        System.out.println("En " + s1.getCiudad(k).getNombre() + " hubo un total de ventas: " + ventas);
                        ventas=0;
                    }
                    break;

                case 4:
                    float [] promedio = new float[s1.contador()];
                    System.out.println("El producto con mayores ventas es: " + s1.topProductos(s1.contador(), bandera1));
                    System.out.println("El producto con menores ventas es: " + s1.botProductos(s1.contador(), bandera1));
                    System.out.println("La ciudad con mayores ventas es: " + s1.topCiudad(s1.contador(), bandera1));
                    System.out.println("La ciudad con menores ventas es: " + s1.botCiudad(s1.contador(), bandera1));
                    promedio = s1.promedioVentas(s1.contador());
                    for (int k = 0; k < s1.contador(); k++) {
                        System.out.println("El promedio de ventas para el producto" + (k+1) + " es: " + promedio[k]);
                    }
                    break;

                case 5:
                    bandera1 = true;
                    boolean ban = false, ban2 = true;        //Bandera para saber si se repite o no un precio
                    precio = Float.valueOf(JOptionPane.showInputDialog("Ingrese el precio unitario del producto"));     //Ingreso el precio
                    if(i==0) {      //Asumo que sera el primer producto del sistema
                        descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
                        for (int k = 0; k < 4; k++) {
                            String Mensaje = "Ingrese el numero de existencias para: " + s1.getCiudad(k).getNombre();
                            exist = Integer.valueOf(JOptionPane.showInputDialog(Mensaje));              //Meto el producto a las ciudades
                            Producto p1 = new Producto(a, descripcion, precio, exist);
                            s1.getCiudad(k).agregarProducto(p1);
                        }
                        validar[i] = precio;        //En un arreglo vacio almaceno el precio que ingreso para no repetirlo
                        i++;
                        a++;                        //i es para el arreglo validar y a es para el arreglo de productos de la ciudad
                        con++;                      //numero de productos hasta el momento
                    }
                    else {
                        for (int k = 0; k < con; k++) {
                            if(validar[k]==precio) {        //Se encontro un precio igual
                                ban = true;
                                ban2 = false;
                            }
                        }
                        if(ban == false) {
                            descripcion = JOptionPane.showInputDialog("Ingrese la descripcion del producto");
                            for (int k = 0; k < 4; k++) {
                                String Mensaje = "Ingrese el numero de existencias para: " + s1.getCiudad(k).getNombre();
                                exist = Integer.valueOf(JOptionPane.showInputDialog(Mensaje));      //Lo mismo que arriba
                                Producto p1 = new Producto(a, descripcion, precio, exist);
                                s1.getCiudad(k).agregarProducto(p1);
                            }
                            validar[i] = precio;
                            i++;
                            a++;
                            con++;
                        }
                        else {
                            System.out.println("Error, ya existe este producto"); //
                        }
                    }
                    if(ban2 == true) {
                        s1.setNumProductos();
                    }
                    break;

                case 6:
                    System.out.println("Adios");
                    salir = true;
                    break;
            }

        }
    }
}
public class Supermercado {
    //Atributos
    private Ciudad[] ciudad;
    private int posCiudad;
    private int numProductos=0;

    //Constructor
    public Supermercado() {
        ciudad = new Ciudad[4];
    }

    //Setters y Getters
    public Ciudad getCiudad(int posCiudad) {

        return ciudad[posCiudad];
    }

    public void setCiudad(Ciudad ciudad, int posCiudad) {

        this.ciudad[posCiudad] = ciudad;
    }

    public void setNumProductos(){
        numProductos++;
    }
    
     public int contador(){
        return numProductos;
}


    //Metodos

    public float[] promedioVentas(int contador) {
        float[] promedio = new float[contador];
        float suma = 0;
        float prom;
        int k=0;                                        //indice para el arreglo
        for (int i = 0; i < contador; i++) {
            for (int j = 0; j < 4; j++) {
                suma = suma + ciudad[j].getProducto(i).getUnidadesV() * ciudad[j].getProducto(i).getPrecioUnitario();
            }
            prom = suma/4;
            promedio[k] = prom;
            k++;
            suma = 0;
        }
        return promedio;
    }

    public String topCiudad(int contador, boolean ban) {
        float ventas=0;
        float[] ventas1 = new float[4];
        for (int k = 0; k < 4; k++) {
            for (int l = 1; l <= contador(); l++) {
                ventas = ventas + getCiudad(k).venderProducto(l, contador);
            }
            ventas1[k] = ventas;
            ventas=0;
        }
        if(ban==false) {
            return "No existen productos";
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("Venta " + ventas1[i]);
        }
        float max =ventas1[0];
        int cont=0;
        for (int i = 0; i < 4; i++) {
            if(max<ventas1[i]) {
                max = ventas1[i];
                cont = i;
            }
        }
        String Mensaje = ciudad[cont].getNombre();
        return Mensaje;
    }

    public String botCiudad(int contador, boolean ban) {
        float ventas=0;
        float[] ventas1 = new float[4];
        for (int k = 0; k < 4; k++) {
            for (int l = 1; l <= contador(); l++) {
                ventas = ventas + getCiudad(k).venderProducto(l, contador);
            }
            ventas1[k] = ventas;
            ventas=0;
        }
        if(ban==false) {
            return "No existen productos";
        }
        float minn =ventas1[0];
        int cont=0;
        for (int i = 0; i < 4; i++) {
            if(minn>ventas1[i]) {
                minn = ventas1[i];
                cont=i;
            }
        }
        String Mensaje = ciudad[cont].getNombre();
        return Mensaje;
    }


    public int topProductos(int contador, boolean ban) {
        int con;
        float suma=0, maxn;
        float[] max = new float[contador];
        for (int i = 0; i < contador; i++) {
            for (int j = 0; j < 4; j++) {
                suma = suma + ciudad[j].getProducto(i).getUnidadesV()*ciudad[0].getProducto(i).getPrecioUnitario();
            }
            max[i] = suma;
            suma = 0;
        }
        if(ban==false) {
            return 0;
        }
        maxn = max[0];
        con = 1;
        for (int i = 1; i < contador; i++) {
            if(maxn<max[i]) {
                maxn = max[i];
                con++;
            }
        }
        return con;
    }

    public int botProductos(int contador, boolean ban) {
        int con;
        float suma=0, minn;
        float[] max = new float[contador];
        for (int i = 0; i < contador; i++) {
            for (int j = 0; j < 4; j++) {
                suma = suma + ciudad[j].getProducto(i).getUnidadesV()*ciudad[0].getProducto(i).getPrecioUnitario();
            }
            max[i] = suma;
            suma = 0;
        }
        if(ban==false) {
            return 0;
        }
        minn = max[0];
        con = 1;
        for (int i = 1; i < contador; i++) {
            if(minn>max[i]) {
                minn = max[i];
                con++;
            }
        }
        return con;
    }
}


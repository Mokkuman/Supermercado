public class Ciudad {
    //Atributos
    private String nomCiudad;
    private Producto producto[];
    private int posProducto=0;
    private float total=0;

    private Supermercado supermercado;

    //Constructor
    public Ciudad(String nombre) {
        this.nomCiudad = nombre;
        producto = new Producto[100];
    }

    //Getters y Setters
    public String getNombre() {
        return nomCiudad;
    }

    public void setNombre(String nombre) {
        this.nomCiudad = nombre;
    }

    public Producto getProducto(int posProducto) {
        return producto[posProducto];
    }

    public void setSupermercado(int pos) {
        supermercado.setCiudad(this, pos);
    }

    public void agregarProducto(Producto p) {
        producto[posProducto] = p;
        producto[posProducto].setCiudad(this);
        posProducto++;
    }

    public float venderProducto(int id, int contador) {
        float precio, suma = 0;
        for (int i = 0; i < contador; i++) {
           if(producto[i].getId() == id) {
               precio = producto[i].getUnidadesV() * producto[i].getPrecioUnitario();
               suma = suma + precio;
           }
        }
        return suma;
    }


}


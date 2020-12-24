public class Producto {
    //Atributos
    private String descripcion;
    private int existencias;
    private float precioUnit;
    private int id;
    private int unidadesV;

    private Ciudad ciudad;

    //Constructor

    public Producto(int id, String nombre, float precio,int cant) {
        this.descripcion = nombre;
        this.precioUnit = precio;
        this.existencias =cant;
        this.id=id;
    }

    //Setters y Getters

    public int getId() {
        return id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecioUnitario() {
        return precioUnit;
    }
    
     public int getExistencias() {
        return existencias;
    }   

     public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
     
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnit = precioUnitario;
    }

    public int getUnidadesV() {
        return unidadesV;
    }

    public void setUnidadesV(int unidades) {
        this.unidadesV = unidades;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    //Metodos

}

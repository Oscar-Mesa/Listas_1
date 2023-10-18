public class cls_inventario{
    private String str_codigo;
    private String str_nombre;
    private int int_stock;
    private float flt_precio_compras;
    private float flt_precio_venta;
    private float flt_ganancia;

    public cls_inventario(String codigo, String nombre, int stock, float precio_compra, float ganancia) 
    {
        this.str_codigo = codigo;
        this.str_nombre = nombre;
        this.int_stock = stock; 
        this.flt_precio_compras = precio_compra;
        this.flt_ganancia = ganancia;
        this.flt_precio_venta = (precio_compra * ganancia) + precio_compra;
    }

    public void setNombre(String nombre){this.str_nombre = nombre;}
    public void setStock(int stock){this.int_stock = stock;}

    public String getNombre(){return str_nombre;}
    public int getStock(){return int_stock;}
    public String getCodigo(){return str_codigo;}
    public float getprecio_compra(){return this.flt_precio_compras;}
    public float getprecio_venta(){return this.flt_precio_venta;}
    public float getganancia(){return this.flt_ganancia;}
}
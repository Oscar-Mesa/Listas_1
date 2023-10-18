import java.util.LinkedList;

import javax.swing.JOptionPane;

public class app_inventario {
    
    static LinkedList<cls_inventario> obj_inventario = new LinkedList<cls_inventario>();
    static boolean bln_sw;
    static int int_posicion;
    public static void main(String[] args){
        fnt_menu_principal(true);
    }

    private static void fnt_registrar(String cod, String nombre, int stock, float prec_compra,
    float ganancia){

        obj_inventario.add(new cls_inventario(cod, nombre, stock,prec_compra,ganancia));
        JOptionPane.showMessageDialog(null, "Articulo registrado con éxito",
        "Registro", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void fnt_selector(String opcion){

        if(opcion.equals("1")){
            String codigo = JOptionPane.showInputDialog(null,"Código");
            String nombre = JOptionPane.showInputDialog(null,"Nombre");
            int stock = Integer.parseInt(JOptionPane.showInputDialog(null,"Stock"));
            float precio_compra = Float.parseFloat(JOptionPane.showInputDialog(null,"Precio"));
            float ganancia = Float.parseFloat(JOptionPane.showInputDialog(null,"Ganancia"));
            if(codigo.equals("") || nombre.equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar toda la información", "Registro", JOptionPane.ERROR_MESSAGE);
            }else{
                fnt_registrar(codigo, nombre, stock, precio_compra, ganancia);
            }
         
        }
    }

    private static void fnt_consultar(String codigo){
        if (codigo.equals("")){
            JOptionPane.showMessageDialog(null, "Debe indicar el código del articulo", "Consultar", JOptionPane.ERROR_MESSAGE);
        }else{
            bln_sw = false;
            int_posicion = 0;

            for (int i = 0; i < obj_inventario.size(); i++){
                if(codigo.equals(obj_inventario.get(i).getCodigo())){
                    bln_sw = true;
                    int_posicion = i;
                    break;
                }
        }
        if(bln_sw == false){
            JOptionPane.showMessageDialog(null,"No se encontraron registros",
            "Consultar",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,
            "Código: " + obj_inventario.get(int_posicion).getCodigo()+ "\n"
            + "\nNombre: " + obj_inventario.get(int_posicion).getNombre()
            + "\nStock: " + obj_inventario.get(int_posicion).getStock()
            + "\nPrecio Compra" + obj_inventario.get(int_posicion).getprecio_compra()
            + "\nGanancia" + obj_inventario.get(int_posicion).getganancia()
            + "\nPrecio venta" + obj_inventario.get(int_posicion).getprecio_venta());
        }
    }
    }



    private static void fnt_menu_principal(boolean menu){
        while (menu == true){
            String men1 = JOptionPane.showInputDialog(null,
            "<< MENU PRINCIPAL>> \n\n"
            +"1. REGISTRAR\n"
            +"2. CONSULTAR\n"
            +"3. ACTUALIZAR\n"
            +"4. SALIR");
            fnt_selector(men1);
        }
    }

}

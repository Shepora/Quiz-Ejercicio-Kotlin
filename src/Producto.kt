class Producto (val Codigo_Producto: String , val Nombre_Prodcuto: String , val Precio_producto: Double , var Cantidad_Stock: Int ){

fun Vender_Producto(Cantidad: Int) {
    if (Cantidad <= Cantidad_Stock) {
        Cantidad_Stock -= Cantidad
        true
    } else {
        false
    }
}
    fun Reponer_Stock (Cantidad: Int){
        Cantidad_Stock += Cantidad
    }
    fun Aplicar_Descuento(Porcentaje: Double){
        Precio_producto *- (1 - Porcentaje/100)
    }
    fun Mostrar_Informacion_Productos(){
        println("Codigo del producto: $Codigo_Producto")
        println("Nombre del producto: $Nombre_Prodcuto")
        println("Precio del producto: $Precio_producto")
        println("Stock del prodcuto: $Cantidad_Stock")
    }
    fun Aumentar_Precio(Porcentaje: Double){
        Precio_producto * (1 + Porcentaje/100)
    }
    fun Calcular_Valor_Total_Inventario(): Double{
        return Precio_producto * Cantidad_Stock
    }
}

val Lista_Productos = mutableListOf<Producto>()

fun Crear_Producto(Codigo_Producto:String, Nombre_Producto:String, Precio_Producto:Double, Cantidad_Stock: Int){
    val producto = Producto(Codigo_Producto, Nombre_Producto, Precio_Producto, Cantidad_Stock)
    Lista_Productos.add(producto)
}
fun eliminarProductoPorCodigo(codigo: String): Boolean {
    val producto = Lista_Productos.find { it.Codigo_Producto == codigo }
    return if (producto != null) {
        Lista_Productos.remove(producto)
        true
    } else {
        false
    }
}

fun Mostrar_Todos_Productos(){
    Lista_Productos.forEach{it.Mostrar_Informacion_Productos() }

}

package com.example.conversordemedidas

class Listas {
    val itens: ArrayList<Int>
        get() {
            val index = ArrayList<Int>()
            index.add(1)
            index.add(2)
            return index
        }

    fun getMedidas(medidas: String?): ArrayList<String> {
        val listaMedidas = ArrayList<String>()
        listaMedidas.add("Polegadas")
        listaMedidas.add("Centímetros")
        listaMedidas.add("Pés")
        listaMedidas.add("Metros")
        listaMedidas.add("Milhas")
        listaMedidas.add("Quilometros")
        listaMedidas.add("Celsius")
        listaMedidas.add("Farenheint")
        listaMedidas.add("Nós")
        listaMedidas.add("Km_h")
        return listaMedidas
    }
}

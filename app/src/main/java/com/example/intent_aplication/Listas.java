package com.example.intent_aplication;

import java.util.ArrayList;

public class Listas {
    public ArrayList<Integer> getItens(){
        ArrayList<Integer> index = new ArrayList<>();
        index.add(1);
        index.add(2);

        return index;
    }

    public ArrayList<String> getMedidas(String medidas){
        ArrayList<String> listaMedidas = new ArrayList<>();
        listaMedidas.add("Polegadas");
        listaMedidas.add("Centímetros");
        listaMedidas.add("Pés");
        listaMedidas.add("Metros");
        listaMedidas.add("Milhas");
        listaMedidas.add("Quilometros");
        listaMedidas.add("Celsius");
        listaMedidas.add("Farenheint");
        listaMedidas.add("Nós");
        listaMedidas.add("Km_h");

        return listaMedidas;
    }
}

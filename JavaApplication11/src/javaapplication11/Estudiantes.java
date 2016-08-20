/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Estudiantes {
    public String cuenta;
    public ArrayList<Integer> notas = new ArrayList<>();//Lista<Integer>
    public int promedio;

    public Estudiantes() {
    }

    public Estudiantes(String cuenta) {
        this.cuenta = cuenta;
    }

    public void Cpromedio(){
        int suma = 0;
        for (int i = 0; i < notas.size(); i++) {
            suma = suma + notas.get(i);
        }
        promedio = suma/notas.size();
    }

}

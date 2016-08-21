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
    public Lista<Integer> notas = new Lista();
    //public ArrayList<Integer> notas = new ArrayList<>();//Lista<Integer>
    public int promedio;

    public Estudiantes() {
    }

    public Estudiantes(String cuenta) {
        this.cuenta = cuenta;
    }

    public void Cpromedio(){
        int suma = 0;
        for (int i = 1; i < notas.fin(); i++) {
            suma = suma + notas.recuperar(i);
        }
        promedio = suma/(notas.fin()-1);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import com.csvreader.CsvWriter;
import java.io.FileWriter;

/**
 *
 * @author Alexis
 */
public class JavaApplication11 {

    public static Lista<Estudiantes> ListaEstudiantes = new Lista();
    
    public static void main(String[] args) throws IOException {
        Random aleatorio = new Random();
        muestraContenido("./prueba2.txt");
        Scanner rd = new Scanner(System.in);
        int op = 0;
        int nota;
        int entero;
        do {
            System.out.println("Bienvenido");
            System.out.println("Selecione una opcion:\n1. Ingresar una nota\n2. Salir");
            op = rd.nextInt();
            nota = 0;
            if (op == 1) {
                entero = aleatorio.nextInt(ListaEstudiantes.fin());//.fin
                if (entero == ListaEstudiantes.fin()) {
                    entero = ListaEstudiantes.fin()-1;
                }
                if (entero == 0) {
                    entero++;
                }
                System.out.println(ListaEstudiantes.recuperar(entero).cuenta/*.get(entero).cuenta*/);//get(Recuperar)
                System.out.println("Ingrese la nota: ");
                nota = rd.nextInt();
                ListaEstudiantes.recuperar(entero).notas.insertar(nota, ListaEstudiantes.recuperar(entero).notas.fin());
                //ListaEstudiantes.get(entero).notas.add(nota);
            }
        } while (op == 1);
        for (int i = 1; i < ListaEstudiantes.fin(); i++) {
            ListaEstudiantes.recuperar(i).Cpromedio();/*.get(i).Cpromedio();*/
        }
        String outputFile = "./ArchivoNotas.csv";
        boolean existe = new File(outputFile).exists();

        if (existe) {
            File ArchivoNotas = new File(outputFile);
            ArchivoNotas.delete();
        }

        try {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

            csvOutput.write("Cuenta");
            csvOutput.write("Promedio");
            csvOutput.endRecord();

            for (int i = 1; i < ListaEstudiantes.fin()/*.size()*/; i++) {
                csvOutput.write(ListaEstudiantes.recuperar(i).cuenta/*.get(i).cuenta*/);
                csvOutput.write(Integer.toString(ListaEstudiantes.recuperar(i).promedio/*.get(i).promedio*/));
                csvOutput.endRecord();
            }
            csvOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String obtenerCuenta(String hola) {
        int pos1;
        int pos2;

        pos1 = hola.indexOf(',');
        pos2 = hola.indexOf(',', pos1 + 1);

        String respuesta = hola.substring(pos1 + 1, pos2);
        //System.out.println(respuesta);
        return respuesta;
    }

    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        Estudiantes persona;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            //System.out.println(cadena);
            persona = new Estudiantes(obtenerCuenta(cadena));
            //obtenerCuenta(cadena);
            ListaEstudiantes.insertar(persona, ListaEstudiantes.fin());
            //ListaEstudiantes.add(persona);
        }
        b.close();
    }

}

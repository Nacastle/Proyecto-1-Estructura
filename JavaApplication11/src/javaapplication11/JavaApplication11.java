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
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.csvreader.CsvWriter;
import java.io.FileWriter;
/**
 *
 * @author Alexis
 */
public class JavaApplication11 {

    public static ArrayList<Estudiantes> ListaEstudiantes = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        Random aleatorio = new Random();
        //String hola = "Luis Fernando Salazar Fuentes,10011512,I-1";
        //obtenerCuenta(hola);
        //System.out.println("");
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
                entero = aleatorio.nextInt(ListaEstudiantes.size());//.fin
                System.out.println(ListaEstudiantes.get(entero).toString());//get(Recuperar)
                System.out.println("Ingrese la nota: ");
                nota = rd.nextInt();
                ListaEstudiantes.get(entero).notas.add(nota);
            }
        } while (op == 1);
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            ListaEstudiantes.get(i).Cpromedio();
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
            
            for (int i = 0; i < ListaEstudiantes.size(); i++) {
                csvOutput.write(ListaEstudiantes.get(i).cuenta);
                csvOutput.write(Integer.toString(ListaEstudiantes.get(i).promedio));
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
            ListaEstudiantes.add(persona);
        }
        b.close();
    }

}

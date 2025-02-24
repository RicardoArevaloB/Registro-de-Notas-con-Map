package com.ejercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            Map<String, Double> estudiantes = new HashMap<>();


            System.out.print("Escribe el número de estudiantes que vas a registrar: ");
            int cantidadEstudiantes = sc.nextInt();
            sc.nextLine(); 


            for (int i = 0; i < cantidadEstudiantes; i++) {
                System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese la nota de " + nombre + ": ");
                double nota = sc.nextDouble();
                sc.nextLine(); 

                estudiantes.put(nombre, nota); 
            }

            System.out.println("\nLista completa de estudiantes y sus notas:");
            for (Map.Entry<String, Double> entry : estudiantes.entrySet()) {
                System.out.println("Estudiante: " + entry.getKey() + ", Nota: " + entry.getValue());
            }


            System.out.print("\nIngrese el nombre del estudiante para buscar su nota: ");
            String nombreBuscar = sc.nextLine();
            if (estudiantes.containsKey(nombreBuscar)) {
                System.out.println("La nota de " + nombreBuscar + " es: " + estudiantes.get(nombreBuscar));
            } else {
                System.out.println("El estudiante " + nombreBuscar + " no está registrado.");
            }

            String mejorEstudiante = null;
            double mejorNota = Double.MIN_VALUE;

            for (Map.Entry<String, Double> entry : estudiantes.entrySet()) {
                if (entry.getValue() > mejorNota) {
                    mejorNota = entry.getValue();
                    mejorEstudiante = entry.getKey();
                }
            }

            if (mejorEstudiante != null) {
                System.out.println("\nEl estudiante con mejor rendimiento es: " + mejorEstudiante + " con una nota de: " + mejorNota);
            } else {
                System.out.println("\nNo hay estudiantes registrados.");
            }
        } 
    }
}
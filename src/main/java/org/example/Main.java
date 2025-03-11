package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner _teclado = new Scanner(System.in);
        int _opa;
        List<Cabina_Telefonica> _cabina = new ArrayList<>();

        /*
        Cabina_Telefonica cabina1 = new Cabina_Telefonica(1);
        Cabina_Telefonica cabina2 = new Cabina_Telefonica(2);
        Cabina_Telefonica cabina3 = new Cabina_Telefonica(3);
        _cabina.add(cabina1);
        _cabina.add(cabina2);
        _cabina.add(cabina3);
         */
        String _rojo = "\u001B[31m"; // cambiar color segun la terminal, en este caso rojo
        String _rosado = "\u001B[35m";
        String _predeterminado = "\u001B[0m";
        do {
            System.out.println("═════════════════════════════════════════════");
            System.out.println("||          CABINAS TELEFONICAS          ||");
            System.out.println("═════════════════════════════════════════════");
            System.out.printf("%-5s %s%n", "1.", "Crear una cabina telefonica");
            System.out.printf("%-5s %s%n", "2.", "Cabina Telefonica");
            System.out.printf("%-5s %s%n", "3.", "Informacion Cabinas telefonicas");
            System.out.printf("%-5s %s%n", "4.", "Consolidado");
            System.out.printf("%-5s %s%n", "5.", "Reiniciar Cabinas");
            System.out.printf("%-5s %s%n", "0.", "Salir");
            System.out.println("═════════════════════════════════════════════");
            System.out.printf(_rojo+"Digite Opcion: "+_predeterminado);
            _opa = _teclado.nextInt();
            switch (_opa){
                case 1 -> {
                    int id = 1 + _cabina.size();
                    System.out.println(_rosado+"Cabina Telefonica Creada con Exito"+_predeterminado);
                    _cabina.add( new Cabina_Telefonica(id));
                }
                case 2 -> {
                    if (_cabina.size() > 0){
                        System.out.println("═════════════════════════════════════════════");
                        System.out.println("          Cabinas telefonicas");
                        System.out.println("═════════════════════════════════════════════");
                        for (int i = 0; i<_cabina.size(); i++){
                            System.out.println("Cabina Telefonica: #"+_cabina.get(i).getId_llamada());
                        }
                        System.out.printf(_rojo+"Digite Opcion: "+_predeterminado);
                        int _opcion = _teclado.nextInt();
                        if (_opcion <= _cabina.size()){
                            _opcion = _opcion - 1;
                            System.out.println("Cabina Telefonica: #"+ _cabina.get(_opcion).getId_llamada());

                            System.out.println("""
                            1. Local
                            2. A Distancia
                            3. Por Celular
                            """);
                            System.out.printf(_rojo+"Digite Opcion: "+_predeterminado);
                            int _opcionB = _teclado.nextInt();
                            if (_opcionB <= 3){
                                _cabina.get(_opcion).Llamadas(_opcionB);

                                System.out.println("Cabina Telefonica: #"+(_opcion+1));
                                System.out.println(_rosado+  _cabina.get(_opcion).InformacionIndividual(_opcionB) + _predeterminado);
                                _teclado.nextLine();
                                String aceptar = _teclado.nextLine();
                            }else {
                                System.out.println(_rojo+ "Error: Fuera de Rango" + _predeterminado);
                            }

                        } else {
                            System.out.println(_rojo+ "Error: Fuera de Rango" + _predeterminado);
                        }

                    } else {
                        System.out.println("No hay Cabinas Telefonicas Registridas");
                    }

                }
                case 3 -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("              Informacion");
                    System.out.println("═════════════════════════════════════════════");
                    for (int i = 0; i<_cabina.size(); i++){
                        System.out.println("\n° Cabina Telefonica: #"+_cabina.get(i).getId_llamada());
                        System.out.println(_cabina.get(i).Informacion());
                    }
                    _teclado.nextLine();
                    String aceptar = _teclado.nextLine();
                }
                case 4 -> {
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("              Consolidado");
                    System.out.println("═════════════════════════════════════════════");
                    for (int i = 0; i<_cabina.size(); i++){
                        System.out.println(_rosado+ "Cabina Telefonica: #"+_cabina.get(i).getId_llamada());
                        System.out.println(_cabina.get(i).Consolidado());
                        System.out.println("═════════════════════════════════════════════"+_predeterminado);
                    }
                    _teclado.nextLine();
                    String aceptar = _teclado.nextLine();
                }
                case 5 -> {
                    if (_cabina.size() > 0){

                    }
                    System.out.println("═════════════════════════════════════════════");
                    System.out.println("       Reiniciar Cabinas Telefonicas");
                    System.out.println("═════════════════════════════════════════════");
                    for (int i = 0; i<_cabina.size(); i++){
                        System.out.println("Cabina Telefonica: #"+_cabina.get(i).getId_llamada()+_rojo+ " Borrando"+_predeterminado);
                        _cabina.get(i).ReiniciarTodo();
                    }
                }
                default -> System.out.println("Saliendo ...");
            }
        }while (_opa != 0);

    }
}
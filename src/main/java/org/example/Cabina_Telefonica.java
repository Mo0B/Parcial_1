package org.example;

import java.util.Random;

public class Cabina_Telefonica {
    Random random = new Random();

    private double costol, costod, costoc;
    private double costol_t, costod_t, costoc_t;

    private int llamal, llamad, llamac;
    private int id_llamada;

    private int minul_t, minud_t, minuc_t;
    private int minul, minud, minuc;

    public Cabina_Telefonica(int id_llamada) {

        this.id_llamada = id_llamada;
    }

    public int getId_llamada() {
        return id_llamada;
    }

    public String Consolidado(){
        return "Numero de llamadas: "+(llamac+llamad+llamal)+
                "\nCosto: "+(costol_t+costod_t+costoc_t)+
                "\nMinutos: "+(minuc_t+minud_t+minul_t);
    }

    public String Informacion(){

        return    "# de llamadas       LOCALES: "+this.llamal+" | Costo: "+this.costol_t+" | Minutos: "+this.minul_t+
                "\n# de llamadas A   DISTANCIA: "+this.llamad+" | Costo: "+this.costod_t+" | Minutos: "+this.minud_t+
                "\n# de llamadas por   CELULAR: "+this.llamac+" | Costo: "+this.costoc_t+" | Minutos: "+this.minuc_t;
    }

    public String InformacionIndividual(int opcion){
        if (opcion == 1){
            return "Llamada Local: \nCosto : "+this.costol+
                    "\nMinutos: "+this.minul;
        } else
        if (opcion == 2){
            return "Llamada a Distancia: \nCosto : "+this.costod+
                    "\nMinutos: "+this.minud;
        } else
        if (opcion == 3){
            return "Llamada por Celular: \nCosto : "+this.costoc+
                    "\nMinutos: "+this.minuc;
        } else{
            return "Error: Fuera de rango";
        }

    }

    public void Llamadas(int opcion){


        if (opcion == 1){
            llamal ++;
            minul =  (random.nextInt(60) + 1);
            this.costol = minul * 50;
            this.costol_t = this.costol_t + this.costol;
            minul_t = minul + minul_t;
        }
      if (opcion == 2){
          llamad ++;
          minud =  (random.nextInt(60) + 1);
        this.costod = minud * 350;
          this.costod_t = this.costod_t + this.costod;

          minud_t = minud + minud_t;
        }
        if (opcion == 3){
            llamac ++;
            minuc =  (random.nextInt(60) + 1);
         this.costoc = minuc * 150;
            this.costoc_t = this.costoc_t + this.costoc;

            minuc_t = minuc + minuc_t;
        }
    }
    public void ReiniciarTodo(){
        minud_t = minuc_t = minul_t = llamal = llamac = llamad =0;
        minul = minud = minuc = 0;
        costoc_t = costod_t = costol_t = costoc = costod = costol = 0;

    }
}

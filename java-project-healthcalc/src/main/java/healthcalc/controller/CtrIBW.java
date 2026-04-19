package healthcalc.controller;

import healthcalc.model.HealthCalc;
import healthcalc.view.ViewHealthCalc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrIBW implements ActionListener{
    private HealthCalc model;
    private ViewHealthCalc view;
    
    public CtrIBW(HealthCalc model, ViewHealthCalc view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equalsIgnoreCase("CALCULAR_IBW")) {
            
            try {
            
            String generostr = view.getGeneroIBW().toUpperCase().trim();
            String alturastr= view.getAlturaIBW().trim();
            alturastr = alturastr.replace(',', '.'); //evita el error de formato y manda al error de fuera de rango si el usuario intenta introducir la altura en metros con ","
            if (generostr.isEmpty()){
                view.setMessage("Error: Introduce Género (H/M)");
                return;
            }
            if (alturastr.isEmpty()) {
                view.setMessage("Error: Introduzca altura (cm)");
                return;
            }
            char genero=generostr.charAt(0);
            double altura = Double.parseDouble(alturastr);

            double pesoIdeal = model.idealBodyWeight(altura, genero);
            String rformat= String.format("%.2f", pesoIdeal);
            view.setResultadoIBW(String.valueOf(rformat)); 

            } catch (Exception e) {
                view.setMessage(e.getMessage());
            }
                
        }
    }
}
    



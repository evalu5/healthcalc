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
            double altura = Double.parseDouble(view.getAlturaIBW());
            char genero = view.getGeneroIBW().toUpperCase().trim().charAt(0);

            double pesoIdeal = model.idealBodyWeight(altura, genero);
            
            view.setResultadoIBW(String.valueOf(pesoIdeal));
        }
    }
}
    



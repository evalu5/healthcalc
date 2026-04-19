package healthcalc.controller;

import healthcalc.model.HealthCalc;
import healthcalc.view.ViewHealthCalc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrlIBW implements ActionListener{
    private HealthCalc model;
    private ViewHealthCalc view;
    
    public CtrlIBW(HealthCalc model, ViewHealthCalc view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
    }
}
    



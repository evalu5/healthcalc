package healthcalc;

import javax.swing.SwingUtilities;
import healthcalc.model.*;
import healthcalc.view.*;
import healthcalc.controller.*;

public class MainView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthCalc model = new HealthCalcImpl();
            HealthCalcView view = new HealthCalcView();
            
            CtrIMC controllerIMC = new CtrIMC(model, view);
            
            view.setController(controllerIMC); 
            
            view.setVisible(true);
        });
    }
}
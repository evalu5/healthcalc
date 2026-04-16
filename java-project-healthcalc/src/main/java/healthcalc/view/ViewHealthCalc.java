package healthcalc.view;

import java.awt.event.ActionListener;

public interface ViewHealthCalc {
    
    public String getPeso();
    public String getAltura();
    
    public void setInterpretacion(String msg);
    public void setResultado(String res);
    public void setMessage(String msg);
    
   
    public void setController(ActionListener ctr);
}
package Controller;

import Model.Produto;
import javax.swing.JOptionPane;

public class Vender_Produto extends Produto {

    private int RV;
    private int quantidade_venda;

    public void vender() {
        RV = this.getQuantidade();

        if (RV >= 1) {
            RV= RV - quantidade_venda;

        } else {
            JOptionPane.showMessageDialog(null, "Quantidade do produto insuficiente!");

        }

    }

}

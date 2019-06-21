package start;

import form.*;
import javax.swing.JFrame;

public class Start {

    public static void main(String[] args) {
        podesiIzgledForme();
//        JFrame logIn = new FormLogIn();
//        logIn.setVisible(true);
        JFrame main = new FormMain();
        main.setVisible(true);
    }

    private static void podesiIzgledForme() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {

        }
    }
}

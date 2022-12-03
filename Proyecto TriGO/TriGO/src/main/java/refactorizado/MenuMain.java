package refactorizado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMain extends JFrame{
    JFrame menu;
    private JPanel panelMain;
    private JButton humanoButton;
    private JButton machineButton;

    public MenuMain(){
        super("TriGO");
        menu = this;
        this.setSize(500,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        humanoButton.setFocusPainted(false);
        machineButton.setFocusPainted(false);

        setContentPane(panelMain);

        humanoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableroGUI(new JuegoFase1(false));
                menu.dispose();
            }
        });

        machineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TableroGUI(new JuegoFase1(true));
                menu.dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuMain();
            }
        });
    }

}

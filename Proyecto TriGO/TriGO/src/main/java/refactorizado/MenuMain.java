package refactorizado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMain extends JFrame{
    JFrame menu;
    private JPanel panelMain;
    private JButton humanoButton;
    private JButton machineButton;
    private JButton howToPlayButton;

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
    JFrame how = this;
        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(how,"Coloca tus piezas en el tablero, forma un tres en raya \ny captura tantas piezas de tu rival como puedas. \n" +
                        "\nCuida tus movimientos y lleva tus piezas a la victoria \ndejando al oponente con solo dos piezas o incluso \nhasta sin movimientos \n" +
                        "\n ¡Recuerda que cada movimiento \n cuenta en tu camino hacia la victoria!\n\n",
                        "How To Play", JOptionPane.INFORMATION_MESSAGE );

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

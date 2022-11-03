package org.funcionalidad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.funcionalidad.Juego.Cell;
import org.funcionalidad.Juego.GameState;

public class TableroGUI extends JFrame {

    public static final int CELL_SIZE = 80;
    public static final int CELL_SIZE_HALF = CELL_SIZE / 2;
    public static final int GRID_WIDTH = 8;
    public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;

    public static final int CELL_PADDING = CELL_SIZE / 3;  // iba 6e
    public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
    public static final int SYMBOL_STROKE_WIDTH = 8;

    private GameBoardCanvas gameBoardCanvas;
    private JLabel gameStatusBar;

    public Juego game;

    public TableroGUI() {
        this(new Juego());
    }

    public TableroGUI(Juego game) {
        this.game = game;
        setContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("TriGO: NINE MEN'S MORRIS");
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    private void setContentPane() {
        gameBoardCanvas = new GameBoardCanvas();
        gameBoardCanvas
                .setPreferredSize(new Dimension(CELL_SIZE * game.getTotalRows(), CELL_SIZE * game.getTotalColumns()));
        gameStatusBar = new JLabel("  ");
        gameStatusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        gameStatusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(gameBoardCanvas, BorderLayout.CENTER);
        contentPane.add(gameStatusBar, BorderLayout.PAGE_END);
    }

    class GameBoardCanvas extends JPanel {

        GameBoardCanvas() {
            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println("\nTurno: "+game.turn);
                    int rowSelected = e.getY() / CELL_SIZE;
                    int colSelected = e.getX() / CELL_SIZE;
                    if (game.getGameState() == GameState.DEPLOY) {
                        game.desplegarFicha(rowSelected, colSelected);
                    }else if(game.getGameState()== GameState.MOVING){
                        game.moverFicha(rowSelected, colSelected);
                    }
                    else if(game.getGameState()== GameState.SELECT_CAPTURE_RED){
                        game.capturarPieza(game.jugadores[1],game.jugadores[0], new Point(rowSelected,colSelected));
                    }
                    else if(game.getGameState()== GameState.SELECT_CAPTURE_BLUE){
                        game.capturarPieza(game.jugadores[0],game.jugadores[1],new Point(rowSelected,colSelected) );
                    }
                    else {
                        game.resetGame();
                    }
                    repaint();

                }
            });
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.getHSBColor(43, 30, 50));
            drawGridLines(g);
            drawBoard(g);
            printStatusBar();
        }

        private void drawGridLines(Graphics  g) {
            g.setColor(Color.LIGHT_GRAY);
            int rowN=-1,colN=-1;
            for (int row = 1; row <= game.getTotalRows(); ++row) {
                if(row<(int)game.getTotalRows()/2+1) rowN++;
                else if (row>(int)game.getTotalRows()/2+1) rowN--;
                else {rowN++;continue;}
                g.fillRoundRect(CELL_SIZE_HALF + CELL_SIZE*rowN, CELL_SIZE * row - GRID_WIDHT_HALF - CELL_SIZE_HALF, CELL_SIZE * (game.getTotalRows()-1-rowN*2) - 1, GRID_WIDTH,
                        GRID_WIDTH, GRID_WIDTH);
            }
            for (int col = 1; col <= game.getTotalColumns(); ++col) {
                if(col<(int)game.getTotalRows()/2+1) colN++;
                else if (col>(int)game.getTotalRows()/2+1) colN--;
                else {colN++;continue;}
                g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF -CELL_SIZE_HALF, CELL_SIZE_HALF+CELL_SIZE*colN, GRID_WIDTH,
                        CELL_SIZE * (game.getTotalColumns()-1-colN*2) - 1, GRID_WIDTH, GRID_WIDTH);
            }
            g.fillRoundRect( CELL_SIZE - GRID_WIDHT_HALF - CELL_SIZE_HALF,CELL_SIZE_HALF * game.getTotalColumns(), CELL_SIZE * 2+2, GRID_WIDTH,
                    GRID_WIDTH, GRID_WIDTH);
            g.fillRoundRect( CELL_SIZE*5 - GRID_WIDHT_HALF - CELL_SIZE_HALF,CELL_SIZE_HALF * game.getTotalColumns(), CELL_SIZE * 2+2, GRID_WIDTH,
                    GRID_WIDTH, GRID_WIDTH);
            g.fillRoundRect( CELL_SIZE_HALF * game.getTotalColumns(),CELL_SIZE - GRID_WIDHT_HALF - CELL_SIZE_HALF, GRID_WIDTH,CELL_SIZE * 2+2,
                    GRID_WIDTH, GRID_WIDTH);
            g.fillRoundRect( CELL_SIZE_HALF * game.getTotalColumns(),CELL_SIZE*5 - GRID_WIDHT_HALF - CELL_SIZE_HALF, GRID_WIDTH,CELL_SIZE * 2+2,
                    GRID_WIDTH, GRID_WIDTH);
        }

        private void drawBoard(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int row = 0; row < game.getTotalRows(); ++row) {
                for (int col = 0; col < game.getTotalColumns(); ++col) {
                    int x1 = col * CELL_SIZE + CELL_PADDING;
                    int y1 = row * CELL_SIZE + CELL_PADDING;

                    if((game.getCell(row, col)== Cell.EMPTY || game.getCell(row, col)== Cell.SHINY) && game.getCell(row, col)!=Cell.DISABLE){
                        g2d.setColor(Color.LIGHT_GRAY);
                        //g2d.drawOval(x1+CELL_PADDING/4, y1+CELL_PADDING/4, SYMBOL_SIZE/2, SYMBOL_SIZE/2);
                        g2d.fillOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
                    }

                    if (game.getCell(row, col) == Cell.RED) {
                        g2d.setColor(Color.RED);
                        g2d.fillOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
                    } else if (game.getCell(row, col) == Cell.BLUE) {
                        g2d.setColor(Color.BLUE);
                        g2d.fillOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
                    } else if (game.getCell(row, col) == Cell.SHINY) {
                        g2d.setStroke(new BasicStroke(3));
                        g2d.setColor(Color.GREEN);
                        g2d.drawOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
                    }
                }
            }
        }

        private void printStatusBar() {
            if (game.getGameState() == GameState.DEPLOY) {
                gameStatusBar.setForeground(Color.BLACK);
                if (game.getTurn() == 'X') {
                    gameStatusBar.setText("Turno de Azul");
                } else {
                    gameStatusBar.setText("Turno de Rojo");
                }
            } else if (game.getGameState() == GameState.MOVING) {
                gameStatusBar.setForeground(Color.GRAY);
                gameStatusBar.setText("Fase de movimiento. Selecciona tus fichas y desplázalas");
            } else if(game.getGameState() == GameState.SELECT_CAPTURE_BLUE){
                gameStatusBar.setForeground(Color.blue);
                gameStatusBar.setText("Seleccione la ficha azul a capturar.");
            } else if(game.getGameState() == GameState.SELECT_CAPTURE_RED){
                gameStatusBar.setForeground(Color.RED);
                gameStatusBar.setText("Seleccione la ficha roja a capturar.");
            } else if (game.getGameState() == GameState.BLUE_WON) {
                gameStatusBar.setForeground(Color.RED);
                gameStatusBar.setText("Rojo gana! Click para jugar otra vez.");
            } else if (game.getGameState() == GameState.RED_WON) {
                gameStatusBar.setForeground(Color.blue);
                gameStatusBar.setText("Azul gana! Click para jugar otra vez.");
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableroGUI(new Juego());
            }
        });
    }
}

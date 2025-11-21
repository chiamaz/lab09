package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller controller;

    /**
     * Graphical application.
     * 
     * @param controller the controller attached to SimpleGUI
     */
    public SimpleGUI(final SimpleController controller) {
        this.controller = controller;
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel.add(panel1, BorderLayout.NORTH);

        final JTextField textF = new JTextField();
        panel1.add(textF, BorderLayout.NORTH);

        final JTextArea textA = new JTextArea(); 
        textA.setEditable(false);
        panel.add(textA, BorderLayout.CENTER);

        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel.add(panel2, BorderLayout.SOUTH);

        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show History");

        panel2.add(print, BorderLayout.NORTH);
        panel2.add(showHistory, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                SimpleGUI.this.controller.setStringToPrint(textF.getText());
                SimpleGUI.this.controller.printString();
            }
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                textA.setText(SimpleGUI.this.controller.getHistory().toString());
            }
        });
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
        frame.pack();
    }

    /**
     * Starts the graphical application.
     * 
     * @param args String[] args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}

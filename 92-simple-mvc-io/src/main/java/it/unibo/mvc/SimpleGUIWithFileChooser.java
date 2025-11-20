package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;    

    private final JFrame frame = new JFrame();
    
    public SimpleGUIWithFileChooser(final Controller controller){
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField text = new JTextField(controller.getFile().getAbsolutePath());
        text.setEditable(false);
        final JButton browse = new JButton("Browse...");
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.add(text, BorderLayout.CENTER);
        panel.add(browse, BorderLayout.LINE_END);

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored){
                final JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(browse) == JFileChooser.APPROVE_OPTION){
                    controller.setCurrentFile(chooser.getSelectedFile());
                    text.setText(chooser.getSelectedFile().getAbsolutePath());
                }
                else if (chooser.showSaveDialog(browse) == JFileChooser.CANCEL_OPTION) {
                    //
                }
                else {
                    JOptionPane.showMessageDialog(frame, "error has occured");
                }
            }
        });
    }
    private void display() {
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

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
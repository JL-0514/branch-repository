package view;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class will create a new WelcomeFrame, the initial GUI.
 */

//TODO: Make the font size dynamic


public class WelcomeFrame extends JFrame {

    /**
     * This constructor will create a new WelcomeFrame.
     */
    public WelcomeFrame() {

        final double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        final double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        final Dimension frameSize = new Dimension((int) screenWidth / 2, (int) screenHeight / 2);


        // Set frame properties
        setTitle("Crafty Companion");
        setSize(frameSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create components
        JLabel welcomeLabel = new JLabel("Welcome to Crafty Companion!", SwingConstants.CENTER);
        JButton newButton = new JButton("New");
        JButton loadButton = new JButton("Load");

        Font buttonFont = new Font("Segue", Font.PLAIN, (int) (frameSize.getHeight() / 30));
        Font labelFont = new Font("Segue", Font.PLAIN, (int) (frameSize.getHeight() / 20));

        welcomeLabel.setFont(labelFont);
        newButton.setFont(buttonFont);
        loadButton.setFont(buttonFont);

        // Set layout and add components
        setLayout(new GridBagLayout());

        // Create constraints for components
        GridBagConstraints gbc = new GridBagConstraints();

        //Add welcome label with dynamic font size
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0.5;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(welcomeLabel, gbc);

        // Add New button with dynamic resizing
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        //makes the buttons fill their areas
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        add(newButton, gbc);

        // Add Load button with dynamic resizing
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        add(loadButton, gbc);

        //add event listeners to buttons
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewFrame();
                dispose();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadFrame();
                dispose();
            }
        });

        // Make the frame visible
        setVisible(true);
    }


}

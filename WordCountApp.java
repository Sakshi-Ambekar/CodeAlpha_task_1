package wordcountapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountApp extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
    private JLabel resultLabel;
    private JButton countButton;

    // Constructor
    public WordCountApp() {
        // Set frame properties
        setTitle("Enhanced Word Count Application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create components
        textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        countButton = new JButton("Count Words");
        countButton.addActionListener(this);

        resultLabel = new JLabel("Word Count: 0");

        // Create panels for layout
        JPanel textPanel = new JPanel();
        textPanel.setBorder(BorderFactory.createTitledBorder("Enter your text here:"));
        textPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
        resultPanel.add(resultLabel);

        // Set layout manager for frame
        setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(resultPanel, BorderLayout.NORTH);

        // Make frame visible
        setVisible(true);
    }

    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        // Count words
        String text = textArea.getText();
        if (text.isEmpty()) {
            resultLabel.setText("Word Count: 0");
        } else {
            String[] words = text.trim().split("\\s+"); // Split by whitespace
            int wordCount = words.length;
            resultLabel.setText("Word Count: " + wordCount);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCountApp());
    }
}



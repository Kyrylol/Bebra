import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Main extends JFrame {
        private JTextField maxTextField;
        private JTextField minTextField;
        private JTextField rankTextField;
        private JTextArea resultTextArea;

        public Main() {
            // Set up the JFrame
            setTitle("NFT Price Calculator");
            setSize(400, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new GridLayout(5, 2));

            // Create and add components
            add(new JLabel("Enter 1/1 NFT price:"));
            maxTextField = new JTextField();
            add(maxTextField);

            add(new JLabel("Enter floor price:"));
            minTextField = new JTextField();
            add(minTextField);

            add(new JLabel("Enter your NFT's rank:"));
            rankTextField = new JTextField();
            add(rankTextField);

            JButton calculateButton = new JButton("Calculate");
            add(calculateButton);

            resultTextArea = new JTextArea();
            resultTextArea.setEditable(false);
            add(resultTextArea);

            // Add action listener to the calculate button
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calculateNFTPrice();
                }
            });
        }

        private void calculateNFTPrice() {
            try {
                float max = Float.parseFloat(maxTextField.getText());
                float min = Float.parseFloat(minTextField.getText());
                int rank = Integer.parseInt(rankTextField.getText());

                float a = max - min;
                float b = a / 6666;
                int c = 6666 - rank;
                float d = c * b + min;

                resultTextArea.setText("Your NFT price is " + d + " INJ");
            } catch (NumberFormatException ex) {
                resultTextArea.setText("Invalid input. Please enter valid numbers.");
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Main().setVisible(true);
                }
            });
        }
    }

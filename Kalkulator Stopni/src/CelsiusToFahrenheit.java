import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;

public class CelsiusToFahrenheit extends JFrame implements ActionListener {

    private JLabel lCelsius, lFahrenheit;
    private JTextField tCelsius, tFahrenheit;
    private JButton bKonwertuj;
    private double tempCelsius, tempFahrenheit;
    private JCheckBox chWielkie;
    private ButtonGroup stopnieGroup;
    private JRadioButton ConF, FonC;

    public CelsiusToFahrenheit() {


        setSize(400, 300);
        setTitle("Przeliczanie stopni Celsiusza na Fehrenheita");
        setLayout(null);

        lCelsius = new JLabel("Stopnie Celsiusza:");
        lCelsius.setBounds(20, 20, 150, 20);
        add(lCelsius);


        tCelsius = new JTextField("");
        tCelsius.setBounds(170, 20, 150, 20);
        add(tCelsius);
        tCelsius.addActionListener(this);

        lFahrenheit = new JLabel("Stopnie Fahrenheit:");
        lFahrenheit.setBounds(20, 70, 150, 20);
        add(lFahrenheit);

        tFahrenheit = new JTextField("");
        tFahrenheit.setBounds(170, 70, 150, 20);
        add(tFahrenheit);
        tFahrenheit.addActionListener(this);

        bKonwertuj = new JButton("Konwertuj");
        bKonwertuj.setBounds(20, 100, 150, 20);
        add(bKonwertuj);
        bKonwertuj.addActionListener(this);

        stopnieGroup = new ButtonGroup();
        ConF = new JRadioButton("Celsius on Feren");
        ConF.setBounds(80, 200, 150, 20);
        add(ConF);
        ConF.addActionListener(this);
        stopnieGroup.add(ConF);
        ConF.isSelected();

        FonC = new JRadioButton("Feren on Celsius");
        FonC.setBounds(230, 200, 150, 20);
        add(FonC);
        FonC.addActionListener(this);
        stopnieGroup.add(FonC);


    }

    public static void main(String[] args) {
        CelsiusToFahrenheit aplikacja = new CelsiusToFahrenheit();
        aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplikacja.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();
        if (zrodlo == bKonwertuj)
        {
            if (ConF.isSelected())
            {
                tempCelsius = Double.parseDouble(tCelsius.getText());
                tempFahrenheit = 32.0 + 9.0 / 5 * tempCelsius;
                tFahrenheit.setText(String.valueOf(tempFahrenheit));
            } else if (FonC.isSelected()) {
                tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
                tempCelsius = (tempFahrenheit - 32.0) * (5.0 / 9.0);
                tCelsius.setText(String.valueOf(tempCelsius));
            }
        }
        if (zrodlo == tCelsius)
        {
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFahrenheit = 32.0 + 9.0 / 5 * tempCelsius;
            tFahrenheit.setText(String.valueOf(tempFahrenheit));
        }
        else if (zrodlo == tFahrenheit) {
            tempFahrenheit = Double.parseDouble(tFahrenheit.getText());
            tempCelsius = (tempFahrenheit - 32.0) * (5.0 / 9.0);
            tCelsius.setText(String.valueOf(tempCelsius));
        }
    }
}





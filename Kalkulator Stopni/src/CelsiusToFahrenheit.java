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
    private ButtonGroup bgRozmiar;
    private JRadioButton rbMaly, rbSredni, rbDuzy;

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

        bKonwertuj = new JButton("Konwertuj");
        bKonwertuj.setBounds(20, 100, 150, 20);
        add(bKonwertuj);
        bKonwertuj.addActionListener(this);

        chWielkie = new JCheckBox("Wielkie Litery");
        chWielkie.setBounds(250, 100, 150, 20);
        add(chWielkie);
        chWielkie.addActionListener(this);

        bgRozmiar = new ButtonGroup();
        rbDuzy = new JRadioButton("Duzy", true);
        rbDuzy.setBounds(50, 150, 100, 20);
        add(rbDuzy);
        bgRozmiar.add(rbDuzy);
        rbDuzy.addActionListener(this);

        rbSredni = new JRadioButton("Sredni", true);
        rbSredni.setBounds(150, 150, 100, 20);
        add(rbSredni);
        bgRozmiar.add(rbSredni);
        rbSredni.addActionListener(this);

        rbMaly = new JRadioButton("Maly", true);
        rbMaly.setBounds(250, 150, 100, 20);
        add(rbMaly);
        bgRozmiar.add(rbMaly);
        rbMaly.addActionListener(this);


    }

    public static void main(String[] args) {
        CelsiusToFahrenheit aplikacja = new CelsiusToFahrenheit();
        aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplikacja.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();
        if (zrodlo == bKonwertuj || zrodlo == tCelsius) {
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFahrenheit = 32.0 + 9.0 / 5 * tempCelsius;
            tFahrenheit.setText(String.valueOf(tempFahrenheit));
        } else if (zrodlo == chWielkie) {
            if (chWielkie.isSelected() == true) {
                tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 18));
            } else {
                tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
        } else if ( zrodlo == rbMaly){
            tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 13));
        }
            else if ( zrodlo == rbSredni){
            tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 16));

          } else if  (zrodlo == rbDuzy){
        tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 18));
    }


    }
}

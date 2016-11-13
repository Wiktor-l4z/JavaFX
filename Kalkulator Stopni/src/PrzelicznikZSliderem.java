import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class PrzelicznikZSliderem extends JFrame implements ChangeListener{



    private JLabel lCelsius, lFahrenheit;
    private  JSlider sCelsius, sFahrenheit;
    private int tempCelsius, tempFehrenheit;


    public PrzelicznikZSliderem(){

        setSize(500,300);
        setTitle("Przelicznik stopni Celsiusza na Fahrenheita");
        setLayout(null);

        sCelsius = new JSlider(0,100,0);
        sCelsius.setBounds(50,50,300,50);
        sCelsius.setMajorTickSpacing(20);
        sCelsius.setMinorTickSpacing(5);
        sCelsius.setPaintTicks(true);
        sCelsius.setPaintLabels(true);
        add(sCelsius);
        sCelsius.addChangeListener(this);

        sFahrenheit = new JSlider(30,210,30);
        sFahrenheit.setBounds(50,150,300,50);
        sFahrenheit.setMajorTickSpacing(20);
        sFahrenheit.setMinorTickSpacing(5);
        sFahrenheit.setPaintTicks(true);
        sFahrenheit.setPaintLabels(true);
        add(sFahrenheit);
        sFahrenheit.addChangeListener(this);
        sFahrenheit.setEnabled(false);


        lCelsius = new JLabel("Celsius:");
        lCelsius.setBounds(380,50,300,50);
        add(lCelsius);

        lFahrenheit = new JLabel("Fehrenheit:");
        lFahrenheit.setBounds(380,150,300,50);
        add(lFahrenheit);


    }
    public static void main(String[] args) {
        PrzelicznikZSliderem aplikacja = new PrzelicznikZSliderem();
        aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplikacja.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        tempCelsius = sCelsius.getValue();
        lCelsius.setText("Celsius: " + tempCelsius);

        tempFehrenheit = 32+ 9/5 * tempCelsius;
        lFahrenheit.setText("Fehrenheit: " + tempFehrenheit);

        sFahrenheit.setValue(tempFehrenheit);
    }
}



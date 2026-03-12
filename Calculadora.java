import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculadora extends JFrame implements ActionListener{

  //Componentes
  private JMenuBar menubar;
  private JMenu menuOpciones, menuActualizaciones;
  private JMenuItem miModoOscuro, miModoClaro, miSalir, miLimpiar, miHistorial, miVersionActual;
  private JTextField textfield1;
  private JLabel label1;
  private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9,
                  bdiv, bmul, bresta, bsuma, blim, bpun;
  float num1 = 0, num2 = 0, resultado = 0;

  //Variables
  String firstNumber = "Introduzca el primer número";
  String secondNumber = "Introduzca el segundo número";
  String operacion = "Elija la operación";
  String versionActual = "Versión 1.1 - 2023/9/3";
  String historial =  "Versión 1.0 (2023/9/2) - NACE EL PROGRAMA" +
                      "\n- Solo permite cálculos básicos entre dos números" +
                      "\n- No permite cálculo de números con decimales" +
                      "\nVersión 1.1 (2023/9/3)" +
                      "\n- Se ha hecho restricciones al hacer click en botones" +
                      "\n- Se ha limitado el número de decimales y eliminado en caso no necesario" +
                      "\n- Se ha añadido tema oscuro y otra ruta para cerrar el programa" +
                      "\n- Se ha quitado el foco del ratón dentro del JTextField";
  
  public Calculadora(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Calculadora");
    setIconImage(new ImageIcon(getClass().getResource("images/Calculadora.png")).getImage());
    
    menubar = new JMenuBar();
    setJMenuBar(menubar);

    menuOpciones = new JMenu("Opciones");
    menubar.add(menuOpciones);
 
    menuActualizaciones= new JMenu("Actualizaciones");
    menubar.add(menuActualizaciones);

    miModoOscuro = new JMenuItem("Modo Oscuro");
    menuOpciones.add(miModoOscuro);
    miModoOscuro.addActionListener(this);
  
    miModoClaro = new JMenuItem("Modo Claro");
    menuOpciones.add(miModoClaro);
    miModoClaro.addActionListener(this);

    miSalir = new JMenuItem("Salir");
    menuOpciones.add(miSalir);
    miSalir.addActionListener(this);
  
    miHistorial = new JMenuItem("Historial");
    menuActualizaciones.add(miHistorial);
    miHistorial.addActionListener(this);
  
    miVersionActual = new JMenuItem("Versión Actual");
    menuActualizaciones.add(miVersionActual);
    miVersionActual.addActionListener(this);

    textfield1 = new JTextField(firstNumber);
    textfield1.setBounds(5, 5, 295, 50);
    textfield1.setFont(new Font("Andale mono", 1, 18));
    textfield1.setEditable(false);
    textfield1.setHorizontalAlignment(JTextField.CENTER);
    textfield1.setFocusable(false);
    add(textfield1);

    b7 = new JButton("7");
    b7.setBounds(5, 60, 70, 70);
    b7.setFont(new Font("Andale mono", 1, 25));
    b7.setFocusPainted(false);
    add(b7);
    b7.addActionListener(this);

    b8 = new JButton("8");
    b8.setBounds(80, 60, 70, 70);
    b8.setFont(new Font("Andale mono", 1, 25));
    b8.setFocusPainted(false);
    add(b8);
    b8.addActionListener(this);

    b9 = new JButton("9");
    b9.setBounds(155, 60, 70, 70);
    b9.setFont(new Font("Andale mono", 1, 25));
    b9.setFocusPainted(false);
    add(b9);
    b9.addActionListener(this);

    bdiv = new JButton("/");
    bdiv.setBounds(230, 60, 70, 70);
    bdiv.setFont(new Font("Andale mono", 1, 25));
    bdiv.setFocusPainted(false);
    add(bdiv);
    bdiv.addActionListener(this);

    b4 = new JButton("4");
    b4.setBounds(5, 135, 70, 70);
    b4.setFont(new Font("Andale mono", 1, 25));
    b4.setFocusPainted(false);
    add(b4);
    b4.addActionListener(this);

    b5 = new JButton("5");
    b5.setBounds(80, 135, 70, 70);
    b5.setFont(new Font("Andale mono", 1, 25));
    b5.setFocusPainted(false);
    add(b5);
    b5.addActionListener(this);

    b6 = new JButton("6");
    b6.setBounds(155, 135, 70, 70);
    b6.setFont(new Font("Andale mono", 1, 25));
    b6.setFocusPainted(false);
    add(b6);
    b6.addActionListener(this);

    bmul = new JButton("x");
    bmul.setBounds(230, 135, 70, 70);
    bmul.setFont(new Font("Andale mono", 1, 25));
    bmul.setFocusPainted(false);
    add(bmul);
    bmul.addActionListener(this);

    b1 = new JButton("1");
    b1.setBounds(5, 210, 70, 70);
    b1.setFont(new Font("Andale mono", 1, 25));
    b1.setFocusPainted(false);
    add(b1);
    b1.addActionListener(this);

    b2 = new JButton("2");
    b2.setBounds(80, 210, 70, 70);
    b2.setFont(new Font("Andale mono", 1, 25));
    b2.setFocusPainted(false);
    add(b2);
    b2.addActionListener(this);

    b3 = new JButton("3");
    b3.setBounds(155, 210, 70, 70);
    b3.setFont(new Font("Andale mono", 1, 25));
    b3.setFocusPainted(false);
    add(b3);
    b3.addActionListener(this);

    bresta = new JButton("-");
    bresta.setBounds(230, 210, 70, 70);
    bresta.setFont(new Font("Andale mono", 1, 25));
    bresta.setFocusPainted(false);
    add(bresta);
    bresta.addActionListener(this);

    blim = new JButton("C");
    blim.setBounds(5, 285, 70, 70);
    blim.setFont(new Font("Andale mono", 1, 25));
    blim.setFocusPainted(false);
    add(blim);
    blim.addActionListener(this);

    b0 = new JButton("0");
    b0.setBounds(80, 285, 70, 70);
    b0.setFont(new Font("Andale mono", 1, 25));
    b0.setFocusPainted(false);
    add(b0);
    b0.addActionListener(this);

    bpun = new JButton(".");
    bpun.setBounds(155, 285, 70, 70);
    bpun.setFont(new Font("Andale mono", 1, 25));
    bpun.setFocusPainted(false);
    add(bpun);
    bpun.addActionListener(this);

    bsuma = new JButton("+");
    bsuma.setBounds(230, 285, 70, 70);
    bsuma.setFont(new Font("Andale mono", 1, 25));
    bsuma.setFocusPainted(false);
    add(bsuma);
    bsuma.addActionListener(this);

    label1 = new JLabel("Created by Qiu | © All rights reserved");
    label1.setBounds(48, 365, 250, 20);
    add(label1);

  }
  public void actionPerformed(ActionEvent e){

    if(e.getSource() == miModoOscuro){

      Color negro = new Color(0,0,0);
      Color gris = new Color(23, 32, 42);
      Color blanco = new Color(255,255,255);
      Color gris2 = new Color(50,50,50);

      label1.setForeground(blanco);

      blim.setForeground(blanco);
      blim.setBackground(gris2);
      b0.setForeground(blanco);
      b0.setBackground(gris2);
      b1.setForeground(blanco);
      b1.setBackground(gris2);
      b2.setForeground(blanco);
      b2.setBackground(gris2);
      b3.setForeground(blanco);
      b3.setBackground(gris2);
      b4.setForeground(blanco);
      b4.setBackground(gris2);
      b5.setForeground(blanco);
      b5.setBackground(gris2);
      b6.setForeground(blanco);
      b6.setBackground(gris2);
      b7.setForeground(blanco);
      b7.setBackground(gris2);
      b8.setForeground(blanco);
      b8.setBackground(gris2);
      b9.setForeground(blanco);
      b9.setBackground(gris2);
      bdiv.setForeground(blanco);
      bdiv.setBackground(gris2);
      bmul.setForeground(blanco);
      bmul.setBackground(gris2);
      bresta.setForeground(blanco);
      bresta.setBackground(gris2);
      bsuma.setForeground(blanco);
      bsuma.setBackground(gris2);
      bpun.setForeground(blanco);
      bpun.setBackground(gris2);

      getContentPane().setBackground(negro);

      textfield1.setBackground(gris);
      textfield1.setForeground(blanco);

      menubar.setBackground(negro);
      menuOpciones.setForeground(blanco);
      menuActualizaciones.setForeground(blanco);
      miModoOscuro.setBackground(negro);
      miModoOscuro.setForeground(blanco);
      miModoClaro.setBackground(negro);
      miModoClaro.setForeground(blanco);
      miSalir.setBackground(negro);
      miSalir.setForeground(blanco);
      miHistorial.setBackground(negro);
      miHistorial.setForeground(blanco);
      miVersionActual.setBackground(negro);
      miVersionActual.setForeground(blanco);
    }

    if(e.getSource() == miModoClaro){

      Color negro = new Color(0,0,0);
      Color blanco = new Color(230,230,230);

      label1.setForeground(negro);

      blim.setBackground(new JButton().getBackground());
      blim.setForeground(new JButton().getForeground());
      b0.setBackground(new JButton().getBackground());
      b0.setForeground(new JButton().getForeground());
      bpun.setBackground(new JButton().getBackground());
      bpun.setForeground(new JButton().getForeground());
      bsuma.setBackground(new JButton().getBackground());
      bsuma.setForeground(new JButton().getForeground());
      b1.setBackground(new JButton().getBackground());
      b1.setForeground(new JButton().getForeground());
      b2.setBackground(new JButton().getBackground());
      b2.setForeground(new JButton().getForeground());
      b3.setBackground(new JButton().getBackground());
      b3.setForeground(new JButton().getForeground());
      bresta.setBackground(new JButton().getBackground());
      bresta.setForeground(new JButton().getForeground());
      b4.setBackground(new JButton().getBackground());
      b4.setForeground(new JButton().getForeground());
      b5.setBackground(new JButton().getBackground());
      b5.setForeground(new JButton().getForeground());
      b6.setBackground(new JButton().getBackground());
      b6.setForeground(new JButton().getForeground());
      bmul.setBackground(new JButton().getBackground());
      bmul.setForeground(new JButton().getForeground());
      b7.setBackground(new JButton().getBackground());
      b7.setForeground(new JButton().getForeground());
      b8.setBackground(new JButton().getBackground());
      b8.setForeground(new JButton().getForeground());
      b9.setBackground(new JButton().getBackground());
      b9.setForeground(new JButton().getForeground());
      bdiv.setBackground(new JButton().getBackground());
      bdiv.setForeground(new JButton().getForeground());

      getContentPane().setBackground(blanco);

      textfield1.setBackground(blanco);
      textfield1.setForeground(negro);

      menubar.setBackground(blanco);
      menuOpciones.setForeground(negro);
      menuActualizaciones.setForeground(negro);
      miModoOscuro.setBackground(blanco);
      miModoOscuro.setForeground(negro);
      miModoClaro.setBackground(blanco);
      miModoClaro.setForeground(negro);
      miSalir.setBackground(blanco);
      miSalir.setForeground(negro);
      miHistorial.setBackground(blanco);
      miHistorial.setForeground(negro);
      miVersionActual.setBackground(blanco);
      miVersionActual.setForeground(negro);
      
    }

    if(e.getSource() == miSalir){
      System.exit(0);
    }
 
    if(e.getSource() == miHistorial){
      JOptionPane.showMessageDialog(null, historial);
    }

    if(e.getSource() == miVersionActual){
      JOptionPane.showMessageDialog(null, versionActual);
    }

    String temp = textfield1.getText();

    if(temp.equals(firstNumber)){
      
      if(e.getSource() == b0){
        num1 = 0;
      }else if(e.getSource() == b1){
        num1 = 1;
      }else if(e.getSource() == b2){
        num1 = 2;
      }else if(e.getSource() == b3){
        num1 = 3;
      }else if(e.getSource() == b4){
        num1 = 4;
      }else if(e.getSource() == b5){
        num1 = 5;
      }else if(e.getSource() == b6){
        num1 = 6;
      }else if(e.getSource() == b7){
        num1 = 7;
      }else if(e.getSource() == b8){
        num1 = 8;
      }else if(e.getSource() == b9){
        num1 = 9;
      }

      if(e.getSource() == b0 || e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || 
         e.getSource() == b4 || e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 ||
         e.getSource() == b8 || e.getSource() == b9){

        textfield1.setText(secondNumber);

      }else if(e.getSource() == bdiv || e.getSource() == bmul || e.getSource() == bresta || 
               e.getSource() == bsuma || e.getSource() == bpun){
        JOptionPane.showMessageDialog(null, "Introduzca un número");
        textfield1.setText(firstNumber);

      }
    }

    if(temp.equals(secondNumber)){
      
      if(e.getSource() == b0){
        num2 = 0;
      }else if(e.getSource() == b1){
        num2 = 1;
      }else if(e.getSource() == b2){
        num2 = 2;
      }else if(e.getSource() == b3){
        num2 = 3;
      }else if(e.getSource() == b4){
        num2 = 4;
      }else if(e.getSource() == b5){
        num2 = 5;
      }else if(e.getSource() == b6){
        num2 = 6;
      }else if(e.getSource() == b7){
        num2 = 7;
      }else if(e.getSource() == b8){
        num2 = 8;
      }else if(e.getSource() == b9){
        num2 = 9;
      }

      if(e.getSource() == b0 || e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || 
         e.getSource() == b4 || e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 ||
         e.getSource() == b8 || e.getSource() == b9){

        textfield1.setText(operacion);

      }else if(e.getSource() == bdiv || e.getSource() == bmul || e.getSource() == bresta || 
               e.getSource() == bsuma || e.getSource() == bpun){
        JOptionPane.showMessageDialog(null, "Introduzca un número");
        textfield1.setText(secondNumber);

      }
    }  
    
    if(temp.equals(operacion)){

      if(e.getSource() == bdiv || e.getSource() == bmul || 
         e.getSource() == bresta || e.getSource() == bsuma){

        if(e.getSource() == bdiv){
          resultado = num1 / num2;
        }else if(e.getSource() == bmul){
          resultado = num1 * num2;
        }else if(e.getSource() == bresta){
          resultado = num1 - num2;
        }else if(e.getSource() == bsuma){
          resultado = num1 + num2;
        }
        
        DecimalFormat df = new DecimalFormat("#.###");
        textfield1.setText("El resultado es: " + df.format(resultado));

      }else if(e.getSource() == b0 || e.getSource() == b1 || e.getSource() == b2 || e.getSource() == b3 || 
         e.getSource() == b4 || e.getSource() == b5 || e.getSource() == b6 || e.getSource() == b7 ||
         e.getSource() == b8 || e.getSource() == b9 || e.getSource() == bpun){

        JOptionPane.showMessageDialog(null, "Elija una operación");

      }
    }

    if(e.getSource() == blim){
      float num1 = 0, num2 = 0, resultado = 0;
      textfield1.setText(firstNumber);
    }
  }
  public static void main(String args[]){
    Calculadora ventana = new Calculadora();
    ventana.setBounds(0, 0, 320, 450);
    ventana.setVisible(true);
    ventana.setResizable(false);
    ventana.setLocationRelativeTo(null);
  }
}
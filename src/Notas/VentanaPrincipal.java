package Notas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    // Un contenedor de elementos gráficos
    private Container contenedor;
    // Etiquetas estáticas de cada nota
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio,desviacion, mayor, menor;
    // Campos de ingreso de cada nota
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    // Botones para realizar cálculos y para borrar las notas
    private JButton calcular, limpiar;
    //constructor ventana principal
    public VentanaPrincipal() {
        inicio();
        setTitle("Notas"); // Establece el título de la ventana
        setSize(280,380); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); /* La ventana se posiciona en el centro de la pantalla */
        // Establece que el botón de cerrar permitirá salir de la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); /* Establece que el tamaño de la ventana no se puede cambiar */
    }
    /**
     * Método que crea la ventana con sus diferentes componentes
     * gráficos
     */
    private void inicio() {
        contenedor = getContentPane(); /* Obtiene el panel de contenidos de la ventana */
        contenedor.setLayout(null); /* Establece que el contenedor no tiene un layout */
    // Establece la etiqueta y el campo de texto de la nota 1
        nota1 = new JLabel();
        nota1.setText("Nota 1:");
        nota1.setBounds(20, 20, 135, 23); /* Establece la posición de la etiqueta nota 1 */
        campoNota1 = new JTextField();
    //  Establece la posición del campo de texto de la nota 1
        campoNota1.setBounds(105, 20, 135, 23);
    // Establece la etiqueta y el campo de texto de la nota 2
        nota2 = new JLabel();
        nota2.setText("Nota 2:");
        nota2.setBounds(20, 50, 135, 23); /* Establece la posición de la etiqueta nota 2 */
        campoNota2 = new JTextField();
    // Establece la posición del campo de texto de la nota 2
        campoNota2.setBounds(105, 50, 135, 23);
    // Establece la etiqueta y el campo de texto de la nota 3
        nota3 = new JLabel();
        nota3.setText("Nota 3:");
        nota3.setBounds(20, 80, 135, 23); /* Establece la posición de la etiqueta nota 3*/
        campoNota3 = new JTextField();
    // Establece la posición del campo de texto de la nota 3
        campoNota3.setBounds(105, 80, 135, 23);
    // Establece la etiqueta y el campo de texto de la nota 4
        nota4 = new JLabel();
        nota4.setText("Nota 4:");
        nota4.setBounds(20, 110, 135, 23); /* Establece la posición de la etiqueta nota 4 */
        campoNota4 = new JTextField();
    // Establece la posición del campo de texto de la nota 4
        campoNota4.setBounds(105, 110, 135, 23);
    // Establece la etiqueta y el campo de texto de la nota 5
        nota5 = new JLabel();
        nota5.setText("Nota 5:");
        nota5.setBounds(20, 140, 135, 23); /* Establece la posición de la etiqueta nota 5 */
        campoNota5 = new JTextField();
    // Establece la posición del campo de texto de la nota 5
        campoNota5.setBounds(105, 140, 135, 23);
    // Establece el botón Calcular
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(20, 170, 100, 23); /* Establece la posición del botón Calcular */
    /* Agrega al botón un ActionListener para que gestione eventos del botón */
        calcular.addActionListener(this);
    // Establece el botón Limpiar
        limpiar = new JButton();
        limpiar.setText("Limpiar");
        limpiar.setBounds(125, 170, 80, 23); /* Establece la posición del botón Limpiar */
    /* Agrega al botón un ActionListener para que gestione eventos
    del botón */
        limpiar.addActionListener(this);
    // Establece la etiqueta del promedio con su valor numérico
        promedio = new JLabel();
        promedio.setText("Promedio = ");
        promedio.setBounds(20, 210, 135, 23); /* Establece la posición
    de la etiqueta promedio */
    // Establece la etiqueta de la desviación con su valor numérico
        desviacion = new JLabel();
        desviacion.setText("Desviación = ");
        desviacion.setBounds(20, 240, 200, 23); /* Establece la posición
    de la etiqueta desviación */
    // Establece la etiqueta de la nota mayor con su valor numérico
        mayor = new JLabel();
        mayor.setText("Nota mayor = ");
        mayor.setBounds(20, 270, 120, 23); /* Establece la posición de
    la etiqueta nota mayor */
    // Establece la etiqueta de la nota menor con su valor numérico
        menor = new JLabel();
        menor.setText("Nota menor = ");
        menor.setBounds(20, 300, 120, 23); /* Establece la posición de la etiquete nota menor */
    // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }
    @Override
    public void actionPerformed(ActionEvent evento){
        boolean camposCompletos = true;
        if (evento.getSource() == calcular) { /* Si se pulsa el botón Calcular */
            Notas notas = new Notas(); // Se crea un objeto Notas
    // Se obtiene y convierte el valor numérico de la nota 1
            try {
                String nota1Text = campoNota1.getText();
                if (nota1Text.isEmpty()) {
                    throw new NullPointerException();
                }
                notas.listaNotas[0] = Double.parseDouble(nota1Text);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros");
            } catch (NullPointerException e) {
                camposCompletos = false;
                JOptionPane.showMessageDialog(null, "Espacio en blanco nota 1");
            }

            try {
                String nota2Text = campoNota2.getText();
                if (nota2Text.isEmpty()) {
                    throw new NullPointerException();
                }
                notas.listaNotas[1] = Double.parseDouble(nota2Text);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros");
            } catch (NullPointerException e) {
                camposCompletos = false;
                JOptionPane.showMessageDialog(null, "Espacio en blanco nota 2");
            }

            try {
                String nota3Text = campoNota3.getText();
                if (nota3Text.isEmpty()) {
                    throw new NullPointerException();
                }
                notas.listaNotas[2] = Double.parseDouble(nota3Text);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros");
            } catch (NullPointerException e) {
                camposCompletos = false;
                JOptionPane.showMessageDialog(null, "Espacio en blanco nota 3");
            }

            try {
                String nota4Text = campoNota4.getText();
                if (nota4Text.isEmpty()) {
                    throw new NullPointerException();
                }
                notas.listaNotas[3] = Double.parseDouble(nota4Text);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros");
            } catch (NullPointerException e) {
                camposCompletos = false;
                JOptionPane.showMessageDialog(null, "Espacio en blanco nota 4");
            }
            try {
                String nota5Text = campoNota5.getText();
                if (nota5Text.isEmpty()) {
                    throw new NullPointerException();
                }
                notas.listaNotas[4] = Double.parseDouble(nota5Text);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números enteros");
            } catch (NullPointerException e) {
                camposCompletos = false;
                JOptionPane.showMessageDialog(null, "Espacio en blanco nota 5");
            }

            if (camposCompletos) {
                notas.calcularPromedio();
                notas.calcularDesviacion();

                promedio.setText("Promedio = " + String.valueOf(String.format("%.2f", notas.calcularPromedio())));
                double desv = notas.calcularDesviacion();
                desviacion.setText("Desviación = " + String.format("%.2f", desv));
                mayor.setText("Nota mayor = " + String.valueOf(notas.calcularMayor()));
                menor.setText("Nota menor = " + String.valueOf(notas.calcularMenor()));
            } else {
                promedio.setText("Promedio = ");
                desviacion.setText("Desviación = ");
                mayor.setText("Nota mayor = ");
                menor.setText("Nota menor = ");
            }
        }
    /* Se se pulsa el botón Limpiar se dejan en blanco los campos de notas */
        if (evento.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio = ");
            desviacion.setText("Desviación = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");
        }
    }
}



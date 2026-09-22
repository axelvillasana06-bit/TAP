package com.emiliano;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class VentanaEjemplo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInicial;
	private JTextField txtFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEjemplo frame = new VentanaEjemplo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEjemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(307, 19, 0, 0);
		contentPane.add(canvas);
		
		txtInicial = new JTextField();
		txtInicial.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		txtInicial.setBounds(137, 49, 117, 18);
		contentPane.add(txtInicial);
		txtInicial.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(45, 162, 209, 136);
		contentPane.add(textArea);
		
		JButton btnCalcular = new JButton("Generar");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int inicial = Integer.parseInt(txtInicial.getText());
				int fin = Integer.parseInt(txtFinal.getText());

				int a = 0;
				int b = 1;

				String resultado = "";

				while (a <= fin) {

				    if (a >= inicial) {
				        resultado += a + " ";
				    }

				    int siguiente = a + b;
				    a = b;
				    b = siguiente;
				}

				textArea.setText(resultado);
			}
			
		});
		btnCalcular.setBounds(79, 115, 129, 26);
		contentPane.add(btnCalcular);
		
		JLabel lblNewLabel = new JLabel("Numero inicial");
		lblNewLabel.setBounds(45, 52, 106, 12);
		contentPane.add(lblNewLabel);
		
		txtFinal = new JTextField();
		txtFinal.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();

		        if (!Character.isDigit(c)) {
		            e.consume();
		        }
		    }
		});
		txtFinal.setColumns(10);
		txtFinal.setBounds(137, 87, 117, 18);
		contentPane.add(txtFinal);
		
		JLabel lblNumeroFinal = new JLabel("Numero Final");
		lblNumeroFinal.setBounds(45, 90, 106, 12);
		contentPane.add(lblNumeroFinal);
		
		
		

	}
}

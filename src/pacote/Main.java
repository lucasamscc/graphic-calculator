package pacote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    JLabel texto = new JLabel();
    public Main() {
        super("CalculadoraPoo");
        setSize(250, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 4, 5, 5));
        getContentPane().setBackground(Color.white);
        String[] buttons = {"C","","","","7","8","9","÷","4","5","6","*","1","2","3","-","0",".","=","+"};
        Calculadora calculadora = new Calculadora();

        for (int i = 0; i < buttons.length; i++) {
            if (i == 1 || i==2 || i==3) {
                texto = new JLabel(buttons[i]);
                texto.setForeground(Color.gray);
                texto.setFont(new Font("Serif", Font.BOLD,25));
                add(buttons[i], texto);
            } else {
                JButton botao = new JButton(buttons[i]);
                botao.setFont(new Font("Serif", Font.PLAIN,25));
                botao.setContentAreaFilled(false);
                botao.setBorderPainted(true);
                botao.setFocusPainted(false);
                botao.setForeground(Color.black);
                add(buttons[i], botao);
                switch (buttons[i]){
                    case "+":
                        botao.setForeground(Color.decode("#7986cb"));
                        texto.setFont(new Font("Serif", Font.BOLD,25));
                        botao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                calculadora.setOperacao(Calculadora.OPERACAO.ADICAO);
                                setTexto(texto.getText() + " + ");
                            }
                        });
                        break;
                    case "*":
                        botao.setForeground(Color.decode("#7986cb"));
                        texto.setFont(new Font("Serif", Font.BOLD,25));
                        botao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                calculadora.setOperacao(Calculadora.OPERACAO.MULTIPLICACAO);
                                setTexto(texto.getText() + " x ");
                            }
                        });
                        break;
                    case "-":
                        botao.setForeground(Color.decode("#7986cb"));
                        texto.setFont(new Font("Serif", Font.BOLD,25));
                        botao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                calculadora.setOperacao(Calculadora.OPERACAO.SUBTRACAO);
                                setTexto(texto.getText() + " - ");
                            }
                        });
                        break;
                    case "÷":
                        botao.setForeground(Color.decode("#7986cb"));
                        texto.setFont(new Font("Serif", Font.BOLD,25));
                        botao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                calculadora.setOperacao(Calculadora.OPERACAO.DIVISAO);
                                setTexto(texto.getText() + " ÷ ");
                            }
                        });
                        break;    
                    case "=":
                        botao.setForeground(Color.decode("#7986cb"));
                        texto.setFont(new Font("Serif", Font.BOLD,25));
                        botao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                double resposta = calculadora.calcular();
                                setTexto(Double.toString(resposta));
                            }
                        });
                        break;
                    case "C":
                        botao.setForeground(Color.decode("#7986cb"));
                        texto.setFont(new Font("Serif", Font.BOLD,25));
                        botao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                setTexto("");
                                calculadora.limpaCalculadora();
                            }
                        });
                        break;
                    default:
                        botao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (!(botao.getText()=="." && calculadora.getNumero().indexOf(".")!=-1)){
                                    setTexto(texto.getText() + botao.getText());
                                    calculadora.setNumero(calculadora.getNumero() + botao.getText());
                                }
                            }
                        });
                        break;
                }
            }
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    private void setTexto(String texto) {
        this.texto.setText(texto);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}

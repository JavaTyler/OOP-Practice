package PerfandPrimeGUI;

import PerfectNumbers.PrimeNumber;
import PerfectNumbers.PerfectNumber;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GuiInterface extends JFrame {

    private final int WIDTH = 582;
    private final int HEIGHT = 492;

    private PerfectPrimeControlPanelInner controlPanel;



    public GuiInterface () {

        super();
        controlPanel = new PerfectPrimeControlPanelInner();
        this.add(controlPanel, BorderLayout.WEST);
        this.setTitle("Perfect & Prime Numbers");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setLayout(new BorderLayout(5,5));
        this.setResizable(false);

    }

    public class PerfectPrimeControlPanelInner extends JPanel {

        //Perfect Numbers

        private JButton numberReq;

        private JTextField enterNumbers;
        private JTextArea outputNumbers;
        private JScrollPane scrollPaneOutputPerfectNumbers;

        //Prime Numbers

        private JTextField enterPrimeTestNumber; //Vestigial
        private JTextArea requestedPrimeFactorsList; //Vestigial

        private JLabel resultPrimalityTest;

        private JButton requestPrimalityTest;
        private JButton requestPrimeFactors;

        public PerfectPrimeControlPanelInner() {

            prepareButtonHandlers();

            //Perfect Numbers

            enterNumbers = new JTextField("Input", 5);
            enterNumbers.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            setLayout(new GridLayout(2, 6, 35, 35));
            this.add(numberReq);
            this.add(enterNumbers);

            outputNumbers = new JTextArea(10, 15);
            scrollPaneOutputPerfectNumbers = new JScrollPane(outputNumbers);
            this.add(scrollPaneOutputPerfectNumbers);

            //Prime Numbers

            //this.add(enterPrimeTestNumber = new JTextField("", 15));

            //this.add(requestedPrimeFactorsList = new JTextArea(10, 15));

            this.add( resultPrimalityTest = new JLabel());
            resultPrimalityTest.setLocation(100,10);

            this.add(requestPrimalityTest);
            this.add(requestPrimeFactors);
        }

        private void prepareButtonHandlers() {

            numberReq = new JButton("Request Number");
            numberReq.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            String textFieldString = enterNumbers.getText();
                            int placeHolder = 0;
                            try {
                                int x = Integer.parseInt(textFieldString);
                                System.out.println(x);
                                placeHolder = x;
                            }
                            catch (Exception e) {
                                System.out.println("not a number");
                                outputNumbers.setText("Error");
                                return;
                            }

                            final int inputValue = placeHolder; //Need due to Java wanting constant/constant actor.
                            PerfectNumber relevantCase = new PerfectNumber();
                            PerfectNumber checkRelevantCase = new PerfectNumber();


                            outputNumbers.setText("");

                            Thread thread = new Thread(new Runnable() {
                                int numberToGet = inputValue;
                            public void run() {
                                int i = 1;

                                numberReq.setEnabled(false);
                                requestPrimeFactors.setEnabled(false);

                                while(numberToGet != 0){

                                    if (checkRelevantCase.isPerfect(relevantCase.getPerfect(i)) == true) {
                                        outputNumbers.append("Output: " + i + " " +relevantCase.getPerfect(i) + "\n");
                                        numberToGet--;
                                        i++;
                                    }
                                    else {
                                        i++;
                                    }
                                }

                                numberReq.setEnabled(true);
                                requestPrimeFactors.setEnabled(true);

                                System.out.println(textFieldString);

                                controlPanel.requestFocus();
                            }
                            });

                            thread.start();

                        }
                    }

            );

        requestPrimalityTest = new JButton("Request Primality Test");
        requestPrimalityTest.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        String textFieldString = enterNumbers.getText();
                        long x = 0;
                        try {
                            x = Long.parseLong(textFieldString);
                            System.out.println(x);
                        } catch (Exception e) {
                            System.out.println("Not a number");
                            outputNumbers.setText("Error");
                            return;
                        }

                        long xThread = x;

                        Thread thread = new Thread(new Runnable() {
                            public void run() {

                                PrimeNumber primalityTest = new PrimeNumber();
                                resultPrimalityTest.setText("               Result: " + primalityTest.isPrime(xThread)); //Casting from Boolean to String

                            }
                        });
                        thread.start();
                    }
                }

        );

        requestPrimeFactors = new JButton("Request Prime Factors");
        requestPrimeFactors.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        String textFieldString = enterNumbers.getText();
                        long x = 0;
                        try {
                            x = Long.parseLong(textFieldString);
                            System.out.println(x);
                        }
                        catch (Exception e) {
                            System.out.println("Not a number");
                            outputNumbers.setText("Error");
                            return;
                        }

                        long xThread = x;

                        Thread thread = new Thread(new Runnable() {
                            public void run() {

                                numberReq.setEnabled(false);
                                requestPrimeFactors.setEnabled(false);

                                outputNumbers.setText("");
                                PrimeNumber primeTest = new PrimeNumber();
                                outputNumbers.append("Prime Factors: " + Arrays.toString(primeTest.primeFactors(xThread)));

                                numberReq.setEnabled(true);
                                requestPrimeFactors.setEnabled(true);

                            }
                        });
                        thread.start();
                    }
                }
        );


        }


    }

    public static void main(String[] args)
    {
        GuiInterface frame = new GuiInterface();
    }


}
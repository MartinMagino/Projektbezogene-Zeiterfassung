package gui;


import com.zeiterfassung.Main;
import job.Job;
import project.Project;
import savestate.Savestate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class Gui {
    public static Project currentProject;
    public static Job localJob;
    public static String textfieldEingabeCustomer;
    public static String textfieldEingabeProjectID;
    public static String textfieldEingabeDate;


    public void openMenu() throws IOException {
        JFrame menu = new JFrame("Magino Zeiterfassung");
        menu.setSize(400, 450);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
        JFrame.setDefaultLookAndFeelDecorated(true);


        JButton button1 = new JButton("Altes Projekt");
        button1.setBounds(50, 100, 200, 30);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    selectProject();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });
        JButton button2 = new JButton("Neues Projekt");
        button2.setBounds(50, 200, 200, 30);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(currentProject);
                    createP();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });


        menu.add(button1);
        menu.add(button2);


    }


    public static void openUI() throws IOException {
        JFrame frame = new JFrame("Zeiterfassung");
        frame.setSize(400, 250);
        frame.setLocation(100, 100);
        JFrame.setDefaultLookAndFeelDecorated(true);

        JLabel workerID = new JLabel("Mitarbeiterkürzel:");
        workerID.setBounds(10, 20, 200, 30);

        JLabel jobID = new JLabel("art der Tätigkeit:");
        jobID.setBounds(10, 70, 200, 30);

        JLabel minAtWork = new JLabel("min:");
        minAtWork.setBounds(10, 120, 200, 30);

        JTextField eingabeWorker = new JTextField("NN");
        eingabeWorker.setBounds(220, 20, 100, 30);
        JTextField eingabeJobID = new JTextField();
        eingabeJobID.setBounds(220, 70, 100, 30);
        JTextField eingabeMinAtWork = new JTextField("0");
        eingabeMinAtWork.setBounds(220, 120, 100, 30);

        JButton button = new JButton("Eingabe");
        button.setBounds(50, 170, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textfieldEingabeWorker = eingabeWorker.getText();
                String textfieldEingabeJobID = eingabeJobID.getText();
                String sTextfieldEingabeMinAtWork = eingabeMinAtWork.getText();
                Integer textfieldEingabeMinAtWork = Integer.parseInt(sTextfieldEingabeMinAtWork);
                localJob = new Job(textfieldEingabeWorker, textfieldEingabeJobID, textfieldEingabeMinAtWork);

                try {

                    createT();
                    Savestate.load();
                    Savestate.lines.add(localJob.toString());
                    Savestate.save();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });
        frame.add(workerID);
        frame.add(jobID);
        frame.add(minAtWork);
        frame.add(eingabeWorker);
        frame.add(eingabeJobID);
        frame.add(eingabeMinAtWork);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void createP() throws IOException {
        JFrame frame = new JFrame("Neues Projekt");
        frame.setSize(400, 250);
        frame.setLocation(100, 100);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JLabel customer = new JLabel("Kunde:");
        customer.setBounds(10, 20, 200, 30);

        JLabel projectID = new JLabel("Projekt-Nr:");
        projectID.setBounds(10, 70, 200, 30);

        JLabel date = new JLabel("Datum:");
        date.setBounds(10, 120, 200, 30);

        JTextField eingabeCustomer = new JTextField("z.B. Mahle");
        eingabeCustomer.setBounds(200, 20, 180, 30);
        JTextField eingabeProjectID = new JTextField("AA-0000-dd.mm.jjjj");
        eingabeProjectID.setBounds(200, 70, 180, 30);
        JTextField eingabeDate = new JTextField("dd.mm.jjjj");
        eingabeDate.setBounds(200, 120, 180, 30);

        JButton button = new JButton("Erstellen");
        button.setBounds(100, 170, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textfieldEingabeCustomer = eingabeCustomer.getText();
                textfieldEingabeProjectID = eingabeProjectID.getText();
                textfieldEingabeDate = eingabeDate.getText();
                request();

            }
        });
        frame.add(projectID);
        frame.add(customer);
        frame.add(date);
        frame.add(eingabeCustomer);
        frame.add(eingabeProjectID);
        frame.add(eingabeDate);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void request() {
        JFrame frame = new JFrame("Neues Projekt");
        frame.setSize(400, 250);
        frame.setLocation(100, 100);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        JLabel customer = new JLabel("Kunde:");
        customer.setBounds(10, 20, 200, 30);

        JLabel projectID = new JLabel("Projekt-Nr:");
        projectID.setBounds(10, 70, 200, 30);

        JLabel date = new JLabel("Datum:");
        date.setBounds(10, 120, 200, 30);

        JLabel eingabeCustomer = new JLabel(textfieldEingabeCustomer);
        eingabeCustomer.setBounds(200, 20, 100, 30);
        JLabel eingabeProjectID = new JLabel(textfieldEingabeProjectID);
        eingabeProjectID.setBounds(200, 70, 300, 30);
        JLabel eingabeDate = new JLabel(textfieldEingabeDate);
        eingabeDate.setBounds(200, 120, 100, 30);

        JButton button1 = new JButton("Erstellen");
        button1.setBounds(50, 170, 100, 30);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Project localProject = new Project(textfieldEingabeCustomer, textfieldEingabeProjectID, textfieldEingabeDate);
                    Main.projects.add(localProject);
                    System.out.println(Main.projects);
                    Savestate.saveProjects();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });


        JButton button2 = new JButton("Abbrechen");
        button2.setBounds(250, 170, 100, 30);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);


            }
        });
        frame.add(projectID);
        frame.add(customer);
        frame.add(date);
        frame.add(eingabeCustomer);
        frame.add(eingabeProjectID);
        frame.add(eingabeDate);
        frame.add(button1);
        frame.add(button2);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    public static void createT() {
        JFrame jf = new JFrame("Magino Zeiterfassung");
        jf.setSize(520, 200);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        JFrame.setDefaultLookAndFeelDecorated(true);

        JLabel info1 = new JLabel("auf das Projekt:         " + currentProject);
        info1.setBounds(10, 10, 500, 30);
        JLabel info2 = new JLabel("wurde folgendes gebucht: " + localJob);
        info2.setBounds(10, 50, 500, 30);


        jf.add(info1);
        jf.add(info2);
        jf.setLayout(null);
        jf.setVisible(true);

    }


    public static void selectProject() throws IOException {
        String[] optionsToChoose = Savestate.projectLines.toArray(new String[0]);

        String dropdownSelection = (String) JOptionPane.showInputDialog(
                null,
                "Projekt wählen",
                "Magino Zeiterfassung",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[0]);

        System.out.println("Your chosen Projekt: " + dropdownSelection);
        String[] parts = dropdownSelection.split(",");
        currentProject = new Project(parts[0], parts[1], parts[2]);
        try {
            System.out.println(currentProject);
            Savestate.createProject();
            openUI();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}



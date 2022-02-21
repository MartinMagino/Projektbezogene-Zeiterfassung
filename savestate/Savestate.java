package savestate;

import com.zeiterfassung.Main;
import gui.Gui;
import project.Project;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Savestate {
    public static File currentFile = new File(Gui.currentProject + ".txt");
    public static ArrayList<String> lines = new ArrayList();
    public static ArrayList<String> projectLines = new ArrayList();


    public static void save() throws IOException {
        File localfile = new File(Gui.currentProject + ".txt");
        if (localfile.exists()) {

            PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(Gui.currentProject + ".txt")));

            for (int i = 0; i < lines.size(); i++) {
                out1.println(lines.get(i));
                System.out.println(lines.get(i));
            }

            out1.close();

        }
    }

    public static void read(File currentFile) throws FileNotFoundException {
        File localfile = currentFile;


    }

    public static void load() throws FileNotFoundException {
        File localfile = new File(Gui.currentProject + ".txt");
        if (localfile.exists()) {
            Scanner scanner = new Scanner(localfile);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());


            }
        }

    }

    public static void createProject() throws IOException {
        File localFile = new File(Gui.currentProject + ".txt");
        if (!localFile.exists()) {
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Gui.currentProject + ".txt")));
                System.out.println("File wurde erstellt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("file existiert schon");
        }
    }

    public static void loadProject() throws FileNotFoundException {
        File localfile = new File("data.txt");
        if (localfile.exists()) {
            Scanner scanner = new Scanner(localfile);
            while (scanner.hasNextLine()) {
                projectLines.add(scanner.nextLine());
            }
            for (int i = 0; i < projectLines.size(); i++) {
                String[] parts = projectLines.get(i).split(",");
                Project asd = new Project(parts[0], parts[1], parts[2]);
                Main.projects.add(asd);

            }
            System.out.println(projectLines);
            System.out.println(Main.projects);


        }

    }


    public static void saveProjects() throws IOException {
        File localfile = new File("data.txt");

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("data.txt")));
            for (int i = 0; i < Main.projects.size(); i++) {
                out.println(Main.projects.get(i));
                System.out.println(Main.projects.get(i));
            }

            out.close();




    }


}


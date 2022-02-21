package com.zeiterfassung;

import gui.Gui;
import project.Project;
import savestate.Savestate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Project> projects = new ArrayList();

    public static void main(String[] args) throws IOException {
        File localFolder = new File("Savestate");
        File localFile = new File("Savestate/Save.txt");

        Gui g = new Gui();
        Savestate s = new Savestate();

        Savestate.loadProject();
        g.openMenu();
        //g.selectProject();


    }


}



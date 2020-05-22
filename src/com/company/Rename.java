package com.company;

import java.io.File;

public class Rename {
    private String ans;
    private File file;
    public Rename(String ans, File file) {
        this.ans = ans;
        this.file = file;
    }
    public  void renameFile() {
        if (ans.contains("PDF")) {
            System.out.println("Вы скачали pdf");
            String buf = file.getAbsolutePath();
            File f = new File("answer.pdf");
            if (f.exists()) {
                f.delete();
            }
            file.renameTo(new File("answer.pdf"));
        }
        if (ans.contains("JFIF") || ans.contains("JPE") || ans.contains("JPEG") || ans.contains("JPG")) {
            System.out.println("Вы скачали jpeg");
            String buf = file.getAbsolutePath();
            File f = new File("answer.jpeg");
            if (f.exists()) {
                f.delete();
            }
            file.renameTo(new File("answer.jpeg"));
        }
        if (ans.contains("!DOCTYPE html")){
            System.out.println("Вы скачали html страничку");
            File f = new File("answer.html");
            if (f.exists()) {
                f.delete();
            }
            file.renameTo(new File("answer.html"));
        }
        if (ans.contains("GIF")) {
            System.out.println("Вы скачали GIF");
            String buf = file.getAbsolutePath();
            File f = new File("answer.gif");
            if (f.exists()) {
                f.delete();
            }
            file.renameTo(new File("answer.gif"));
        }

    }

}

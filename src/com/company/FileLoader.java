package com.company;

import java.util.Scanner;

public class FileLoader {
    private Scanner scanner = new Scanner(System.in);
    private DownloadFileThread file;
    private Thread threadDownload;
    public FileLoader() {
    }

    public void run(){
        while(true) {
            printCommand();
            String command = scanner.nextLine();
            downloadFile(command);
            loadcheck(command);
            stopDownload(command);


        }
    }

    private void stopDownload(String command) {
        if(command.trim().equals("stop")) {
            file.stopDownload();
        }
    }

    private void loadcheck(String command) {
        if(command.toLowerCase().equals("check")) {
            try {
                if (threadDownload.isAlive()) {
                    System.out.println("downloaded: " + (int) file.getSize() + "%");
                } else {
                    System.out.println("The file does not download");
                }
            } catch (NullPointerException ex) {
                System.out.println("The file does not download");
            }
        }
    }

    private void downloadFile(String command) {
        if (command.toLowerCase().equals("download")) {
            System.out.println("Enter link");
            String link = scanner.nextLine();
            file = new DownloadFileThread(link);
            try {
                if(threadDownload.isAlive()) {
                    System.out.println("Sorry, previos file still loading");
                } else {
                    threadDownload = new Thread(file);
                    threadDownload.start();
                }
            } catch (NullPointerException ex) {
                threadDownload = new Thread(file);
                threadDownload.start();
            }
        }
    }

    private void printCommand() {
        System.out.println("Commands[download, check, stop]");
        System.out.println("Enter one of these commands for download file, load check, stop download");
    }

}

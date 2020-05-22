package com.company;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class DownloadFileThread implements Runnable{
    private String link;
    private double size;
    private int commonSize;
    private volatile boolean stop = false;


    public DownloadFileThread(String link) {
        this.link = link;
        this.size = 0.0d;
    }
    @Override
    public void run() {
        while (!stop) {
            try {
                File file = new File("answer.txt");
                URL url = new URL(link);
                URLConnection urlConnection = url.openConnection();
                commonSize = urlConnection.getContentLength();
                InputStream is = urlConnection.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String inputline;
                StringBuffer response = new StringBuffer();

                while ((inputline = in.readLine()) != null) {
                    response.append(inputline);
                    size = response.length();
                }

                FileOutputStream fis = new FileOutputStream(file);
                String ans = new String(response);
                fis.write(ans.getBytes());
                fis.close();
                new Rename(ans, file).renameFile();
                System.out.println("File downloaded");
                stop = true;

            } catch (IOException e) {
                System.out.println("failed to download");
            }
        }
    }
    public double getSize() {
       double percent = size / commonSize;
       return percent * 100.0d;
    }

    public void stopDownload() {
        stop = true;
    }

}

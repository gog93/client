package com.example.ecrf.service.impl;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ChatServiceImpl {
    //    @Value("${folder.path}")
    private static String baseUrl = "http://localhost:8081/template";


    //    @Value("${base.url}")
    private static String folderPath = "C:\\myProjects\\eCRF1\\folder\\subfolder\\example.txt";

    public String run() {
        String helper = "@helper";
        File file=new File(folderPath);
//        for (File file : files) {
            String fileName = file.getAbsolutePath();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals(helper)) {
                        String nextLine = br.readLine();
                        if (nextLine == null) {
                            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
                                bw.write("-");

                            } catch (IOException e) {
                                System.err.format("IOException: %s%n", e);
                            }
                            break;
                        }
                    } else {
                        return null;

                    }
                }
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }

//        }
        return null;

    }

    protected List<File> getFilesModifiedAfterLastSchedule(File directory) {
        List<File> filesModified = new ArrayList<>();
        long currentTime = System.currentTimeMillis();
        long fiveMinutesAgo = currentTime - (60 * 1000);

        File[] fileList = directory.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()) {
                    // recursively call this method for subdirectories
                    filesModified.addAll(getFilesModifiedAfterLastSchedule(file));
                } else {
                    try {
                        Path filePath = file.toPath();
                        BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
                        FileTime lastModifiedTime = attributes.lastModifiedTime();

                        if (lastModifiedTime.toMillis() >= fiveMinutesAgo) {
                            filesModified.add(file);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return filesModified;
    }
    public static List<String> linesToArrayList(String filePath) {

        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }

        } catch (Exception ex) {

        }
        return lines;
    }
    public String read() {
        String line = "";
        StringBuilder fileContents = new StringBuilder();

        try {
            // Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(folderPath));

            // Read the contents of the file
            while ((line = reader.readLine()) != null) {
                fileContents.append(line);
                fileContents.append(System.lineSeparator());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return fileContents.toString();
    }

}

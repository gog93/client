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
    private static String folderPath = "C:\\myProjects\\eCRF\\folder\\subfolder\\example.txt";

    public void write(String search) {
        File file = new File(folderPath);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(search); // write the text to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String read() {
        String line = "";
        StringBuilder fileContents = new StringBuilder();

        try {
            Thread.sleep(2000);

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return fileContents.toString();
    }

}

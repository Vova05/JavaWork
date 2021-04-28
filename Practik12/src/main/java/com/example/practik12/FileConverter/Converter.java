package com.example.demo.FileConverter;

import com.example.demo.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

@Service
public class Converter extends ReadAndHash{

    @Autowired
    private Config config;
    private File source;

    @PostConstruct
    public void init() {
        System.out.println("Start converting...");
        InputStream input = null;
        String sourcePath = config.getSourcePath();
        String newPath = config.getNewPath();

        try {
            source = new File(sourcePath);
            if (!source.exists()){
                writeToFile(newPath, "null");
                return;
            }
            input = new FileInputStream(source);
            String dataSource = readFromFile(sourcePath);

            writeToFile(newPath, Hash(dataSource));
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    private void destroy(){
        if (source.delete()){
            System.out.println("File deleted after converting...");
        } else {
            System.out.println("There is no such file!");
        }
    }
}

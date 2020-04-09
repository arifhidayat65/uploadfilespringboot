package com.enigma.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    public static final String PATH_FILE = "C:/nginx-1.16.1/html/img/%s.jpg";

    @Override
    public void saveImageArtist(MultipartFile image, String id) throws IOException {
        File file = new File(String.format(PATH_FILE, id));
        image.transferTo(file);
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(image.getBytes());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

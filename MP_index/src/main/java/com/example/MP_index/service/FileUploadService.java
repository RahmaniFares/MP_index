package com.example.MP_index.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadService {
    private static final String PATH_SEPARATOR = "\\";
    private static final String UPLOAD_DIR = new FileSystemResource("").getFile().getAbsolutePath()+PATH_SEPARATOR+"MP_index"+PATH_SEPARATOR+"src"+PATH_SEPARATOR+"main"+PATH_SEPARATOR+"resources"+PATH_SEPARATOR+"static"+PATH_SEPARATOR+"request_images";


    public boolean uploadFile(MultipartFile file,String ext) throws IllegalStateException, IOException{
        boolean isSaved = false;
        try{
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+PATH_SEPARATOR+randomUUIDString+"."+ext), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
             e.printStackTrace();
        }
        return  isSaved;
    }
}


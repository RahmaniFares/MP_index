package com.example.MP_index.controller;


import com.example.MP_index.service.FileUploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {
    @Autowired
    private FileUploadService srv;

    @PostMapping(value = "/search")
    public String uploadFile(@RequestParam("img") MultipartFile img) throws IllegalStateException, IOException {
         boolean res = srv.uploadFile(img,img.getContentType().split("/")[1]);
        return "Helo";
    }


    @GetMapping(value = "/search")
    public String uploadFile()  {
        try{
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }

       return "Helo";
    }
}

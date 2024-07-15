package com.bank.Controlers;

import com.bank.DTO.ru.cbr.ed.v2.*;
import com.bank.Service.ED807Service;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("/api/ED807")
public class PostController {
    @Autowired
    private ED807Service ed807Service;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(required = false) String name) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
        }

        try (InputStream inputStream = file.getInputStream()) {

            String filePath = uploadDir +file.getOriginalFilename();
            File destFile = new File(filePath);
            file.transferTo(destFile);

            JAXBContext jaxb2Context = JAXBContext.newInstance(ED807.class);
            Unmarshaller unmarshaller = jaxb2Context.createUnmarshaller();
            JAXBElement<ED807> root = (JAXBElement<ED807>) unmarshaller.unmarshal(inputStream);
            ED807 ed807 = root.getValue();

            ed807.setFilePath(filePath);
            List<BICDirectoryEntryType> bicDirectoryEntryTypes = ed807.getBICDirectoryEntry();
            if(name == null){
                name = file.getOriginalFilename();
                ed807.setName(name);
            }
            ed807.setName(name);
            Date date = new Date();
            ed807.setCreationDate(date);
            ed807Service.saveED807(ed807);

            return new ResponseEntity<>(ed807, HttpStatus.OK);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error processing file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


package com.codeclan.example.files_and_folders.controllers;

import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.repositories.FolderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolderController {

    @Autowired
    FolderRespository folderRespository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRespository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity getFolderByID(@PathVariable Long id){
        return new ResponseEntity(folderRespository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postNewFolder(@RequestBody Folder folder){
        folderRespository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}

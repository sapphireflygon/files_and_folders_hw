package com.codeclan.example.files_and_folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"person"})
    private List<Folder> foldersList;

    public Person() {}

    public Person(String name) {
        this.name = name;
        this.foldersList = new ArrayList<>();
    }

    //region Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFoldersList() {
        return this.foldersList;
    }

    public void setFoldersList(List<Folder> foldersList) {
        this.foldersList = foldersList;
    }
    //endregion

    public void addFolder(Folder folder) {
        this.foldersList.add(folder);
    }
}

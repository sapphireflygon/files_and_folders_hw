package com.codeclan.example.files_and_folders.components;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.Person;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRespository;
import com.codeclan.example.files_and_folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    FolderRespository folderRespository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args) {

        Person dude = new Person("Dude");
        personRepository.save(dude);

        Person anotherDude = new Person("Dood");
        personRepository.save(anotherDude);

        Person newDude = new Person("Duuuuude");
        personRepository.save(newDude);

        Person bruh = new Person("Bruh");
        personRepository.save(bruh);

        Folder bro = new Folder("bro", bruh);
        folderRespository.save(bro);

        Folder catz = new Folder("cool cats n kittens", anotherDude);
        folderRespository.save(catz);

        Folder dogz = new Folder("dope dogs n pups", anotherDude);
        folderRespository.save(dogz);

        Folder sk8tricks = new Folder("mad sk8board tricks", newDude);
        folderRespository.save(sk8tricks);

        File homies = new File("my homies", "jpg", "996kB", bro);
        fileRepository.save(homies);

        File kickflips = new File("wicked kickflips", "mp4", "600MB", sk8tricks);
        fileRepository.save(kickflips);

        File nollie = new File("gnarly nollie", "mp4", "1.4GB", sk8tricks);
        fileRepository.save(nollie);

        File kittens = new File("omg kitties", "png", "156kB", catz);
        fileRepository.save(kittens);

        File puppies = new File("omg puppies", "png", "286kB", dogz);
        fileRepository.save(puppies);

        File moarPuppies = new File("omg MOAR puppies!!11!1!", "png", "769kB", dogz);
        fileRepository.save(moarPuppies);

    }
}

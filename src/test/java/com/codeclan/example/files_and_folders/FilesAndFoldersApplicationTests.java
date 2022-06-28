package com.codeclan.example.files_and_folders;

import com.codeclan.example.files_and_folders.models.File;
import com.codeclan.example.files_and_folders.models.Folder;
import com.codeclan.example.files_and_folders.models.Person;
import com.codeclan.example.files_and_folders.repositories.FileRepository;
import com.codeclan.example.files_and_folders.repositories.FolderRespository;
import com.codeclan.example.files_and_folders.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;

@SpringBootTest
class FilesAndFoldersApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRespository folderRespository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createNewPersonThenSave(){
		Person dude = new Person("Dood");
		personRepository.save(dude);
	}

	@Test
	public void createNewFolderAndAddToPersonThenSave(){
		Person anotherDude = new Person("Dude");
		personRepository.save(anotherDude);
		Folder folder = new Folder("cool cats n kittens", anotherDude);
		folderRespository.save(folder);

		anotherDude.addFolder(folder);
		personRepository.save(anotherDude);
	}

	@Test
	public void createNewFileAndAddFileToFolder(){
		Person newDude = new Person("Duuuuude");
		personRepository.save(newDude);
		Folder folder = new Folder("mad sk8board tricks", newDude);
		folderRespository.save(folder);
		newDude.addFolder(folder);
		personRepository.save(newDude);

		File file = new File("wicked kickflips bruh", "mp4", "600MB", folder);
		fileRepository.save(file);
	}

}

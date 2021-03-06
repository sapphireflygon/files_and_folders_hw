package com.codeclan.example.files_and_folders.repositories;

import com.codeclan.example.files_and_folders.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRespository extends JpaRepository<Folder, Long> {
}

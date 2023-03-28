package com.example.service;

import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String storeInFileSystem(MultipartFile file);

    Resource loadFile(String fileName);
}

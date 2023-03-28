package com.example.service;

import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService{
    @Override
    public String storeInFileSystem(MultipartFile file) {
        return null;
    }

    @Override
    public Resource loadFile(String fileName) {
        return null;
    }
}

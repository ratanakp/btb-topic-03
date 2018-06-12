package com.example.demotopic03.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {

    String singleFileUpload(MultipartFile file, String folder);

    List<String> multipleFileUpload(List<MultipartFile> files, String folder);


    String upload(MultipartFile file, String folder);

    List<String> upload(List<MultipartFile> files, String folder);

    List<String> upload(List<MultipartFile> files);

    String upload(MultipartFile file);


}

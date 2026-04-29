package com.blobs.demoblobs.BlobService;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.blobs.demoblobs.Model.ImageResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class BlobService{

    private final  BlobContainerClient  blobContainerClient;

    public BlobService(BlobContainerClient blobContainerClient) {
        this.blobContainerClient = blobContainerClient;
    }

    // CREATE (Upload)
    public ImageResponse upload(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();

        BlobClient blobClient = blobContainerClient.getBlobClient(fileName);

        blobClient.upload(file.getInputStream(), file.getSize(), true);

        blobClient.setHttpHeaders(new BlobHttpHeaders()
                .setContentType(file.getContentType()));

        return new ImageResponse(fileName, blobClient.getBlobUrl());
    }

    // READ
    public ImageResponse get(String fileName) {
        BlobClient blobClient = blobContainerClient.getBlobClient(fileName);
        return new ImageResponse(fileName, blobClient.getBlobUrl());
    }

    // UPDATE
    public ImageResponse update(String fileName, MultipartFile file) throws IOException {
        BlobClient blobClient = blobContainerClient.getBlobClient(fileName);

        blobClient.upload(file.getInputStream(), file.getSize(), true);

        blobClient.setHttpHeaders(new BlobHttpHeaders()
                .setContentType(file.getContentType()));

        return new ImageResponse(fileName, blobClient.getBlobUrl());
    }

    // DELETE
    public void delete(String fileName) {
        blobContainerClient.getBlobClient(fileName).deleteIfExists();
    }
}


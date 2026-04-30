//package com.blobs.demoblobs.Controller;
//
//
//import com.blobs.demoblobs.BlobService.BlobService;
//import com.blobs.demoblobs.Model.ImageResponse;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/images/")
//
//public class ImageController {
//    private BlobService blobService;
//
//    public ImageController(BlobService blobService) {
//        this.blobService = blobService;
//    }
//
//    @PostMapping("/add")
//    public ImageResponse upload(@RequestParam("file") MultipartFile file) throws Exception {
//        return blobService.upload(file, issue.getId());
//    }
//    // 🔹 READ
//    @GetMapping("/{fileName}")
//    public ImageResponse get(@PathVariable String fileName) {
//        return blobService.get(fileName);
//    }
//
//    // 🔹 UPDATE
//    @PutMapping("/{fileName}")
//    public ImageResponse update(@PathVariable String fileName,
//                         @RequestParam("file") MultipartFile file) throws Exception {
//        return blobService.update(fileName, file);
//    }
//
//    // 🔹 DELETE
//    @DeleteMapping("/{fileName}")
//    public String delete(@PathVariable String fileName) {
//        blobService.delete(fileName);
//        return "Deleted successfully";
//    }
//
//
//}

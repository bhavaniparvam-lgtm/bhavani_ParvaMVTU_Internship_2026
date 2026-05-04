package com.tsukuyomi.shiori.controller;

import com.tsukuyomi.shiori.dto.PhotoGalleryResponseDto;
import com.tsukuyomi.shiori.service.PhotoGalleryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/photo-gallery")
public class PhotoGalleryController {

    private final PhotoGalleryService photoGalleryService;

    public PhotoGalleryController(PhotoGalleryService photoGalleryService) {
        this.photoGalleryService = photoGalleryService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PhotoGalleryResponseDto> createPhotoGallery(
            @RequestParam("image") MultipartFile image,
            @RequestParam(value = "caption", required = false) String caption,
            @RequestParam(value = "bookId", required = false) Long bookId) {

        PhotoGalleryResponseDto createdPhotoGallery =
                photoGalleryService.createPhotoGallery(image, caption, bookId);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhotoGallery);
    }

    @GetMapping
    public ResponseEntity<List<PhotoGalleryResponseDto>> getAllPhotoGalleryEntries() {
        return ResponseEntity.ok(photoGalleryService.getAllPhotoGalleryEntries());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PhotoGalleryResponseDto> getPhotoGalleryById(@PathVariable Long id) {
        return ResponseEntity.ok(photoGalleryService.getPhotoGalleryById(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhotoGallery(@PathVariable Long id) {
        photoGalleryService.deletePhotoGallery(id);
        return ResponseEntity.noContent().build();
    }
}
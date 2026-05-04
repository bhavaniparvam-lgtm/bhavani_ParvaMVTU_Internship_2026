package com.tsukuyomi.shiori.service;

import com.tsukuyomi.shiori.dto.PhotoGalleryResponseDto;
import com.tsukuyomi.shiori.entity.Book;
import com.tsukuyomi.shiori.entity.PhotoGallery;
import com.tsukuyomi.shiori.exception.BookNotFoundException;
import com.tsukuyomi.shiori.exception.PhotoGalleryNotFoundException;
import com.tsukuyomi.shiori.repository.BookRepository;
import com.tsukuyomi.shiori.repository.PhotoGalleryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PhotoGalleryService {

    private final PhotoGalleryRepository photoGalleryRepository;
    private final BookRepository bookRepository;

    private static final String UPLOAD_DIR = "uploads/photo-gallery";
    private static final String BASE_URL = "http://localhost:8083";

    public PhotoGalleryService(PhotoGalleryRepository photoGalleryRepository, BookRepository bookRepository) {
        this.photoGalleryRepository = photoGalleryRepository;
        this.bookRepository = bookRepository;
    }

    public PhotoGalleryResponseDto createPhotoGallery(MultipartFile image, String caption, Long bookId) {
        if (image == null || image.isEmpty()) {
            throw new IllegalArgumentException("Image file is required");
        }

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            Files.createDirectories(uploadPath);

            String originalFilename = image.getOriginalFilename();
            String safeFilename = UUID.randomUUID() + "_" + originalFilename;
            Path filePath = uploadPath.resolve(safeFilename);

            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            PhotoGallery photoGallery = new PhotoGallery();
            photoGallery.setImageUrl(BASE_URL + "/uploads/photo-gallery/" + safeFilename);
            photoGallery.setCaption(caption);

            if (bookId != null) {
                Book book = bookRepository.findById(bookId)
                        .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));
                photoGallery.setBook(book);
            } else {
                photoGallery.setBook(null);
            }

            PhotoGallery savedPhotoGallery = photoGalleryRepository.save(photoGallery);
            return mapToResponseDto(savedPhotoGallery);

        } catch (IOException e) {
            throw new RuntimeException("Failed to store image file", e);
        }
    }

    public List<PhotoGalleryResponseDto> getAllPhotoGalleryEntries() {
        return photoGalleryRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .toList();
    }
    
    public PhotoGalleryResponseDto getPhotoGalleryById(Long id) {
        PhotoGallery photoGallery = photoGalleryRepository.findById(id)
                .orElseThrow(() -> new PhotoGalleryNotFoundException("Photo gallery entry not found with id: " + id));

        return mapToResponseDto(photoGallery);
    }
    
    public void deletePhotoGallery(Long id) {
        PhotoGallery photoGallery = photoGalleryRepository.findById(id)
                .orElseThrow(() -> new PhotoGalleryNotFoundException("Photo gallery entry not found with id: " + id));

        photoGalleryRepository.delete(photoGallery);
    }

    private PhotoGalleryResponseDto mapToResponseDto(PhotoGallery photoGallery) {
        Long bookId = photoGallery.getBook() != null ? photoGallery.getBook().getId() : null;
        String bookTitle = photoGallery.getBook() != null ? photoGallery.getBook().getTitle() : null;

        return new PhotoGalleryResponseDto(
                photoGallery.getId(),
                photoGallery.getImageUrl(),
                photoGallery.getCaption(),
                bookId,
                bookTitle,
                photoGallery.getCreatedAt(),
                photoGallery.getUpdatedAt()
        );
    }
}
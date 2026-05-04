package com.tsukuyomi.shiori.repository;

import com.tsukuyomi.shiori.entity.PhotoGallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoGalleryRepository extends JpaRepository<PhotoGallery, Long> {
}
package com.blobs.demoblobs.Repository;

import com.blobs.demoblobs.Model.ImageResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageResponse,Long> {
}

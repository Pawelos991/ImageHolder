package ue.kat.imageHolder.imageHolder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ue.kat.imageHolder.imageHolder.model.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}

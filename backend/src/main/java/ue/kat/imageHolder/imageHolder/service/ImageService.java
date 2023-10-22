package ue.kat.imageHolder.imageHolder.service;

import org.springframework.stereotype.Service;
import ue.kat.imageHolder.imageHolder.dao.ImageRepository;

@Service
public class ImageService {
  private ImageRepository imageRepository;

  public ImageService(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

}

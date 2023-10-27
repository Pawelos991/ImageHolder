package ue.kat.imageHolder.imageHolder.service;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ue.kat.imageHolder.imageHolder.dao.ImageRepository;
import ue.kat.imageHolder.imageHolder.dto.image.ImageDto;
import ue.kat.imageHolder.imageHolder.dto.image.ImageRequest;
import ue.kat.imageHolder.imageHolder.exception.BadRequestException;
import ue.kat.imageHolder.imageHolder.mapper.ImageEntityMapper;
import ue.kat.imageHolder.imageHolder.model.ImageEntity;

@Service
@RequiredArgsConstructor
public class ImageService {
  private final ImageRepository imageRepository;
  private final ImageEntityMapper imageEntityMapper;


  public ImageDto getImage(int id) {
    return imageEntityMapper.toDto(
        imageRepository.findById((long) id).orElseThrow()
    );
  }

  public void saveImage(ImageRequest imageRequest) {
    try {
      ImageEntity imageEntity = imageEntityMapper.toEntity(imageRequest);
      imageRepository.saveAndFlush(imageEntity);
    } catch (IOException exception) {
      throw new BadRequestException(exception.getMessage());
    }
  }
}

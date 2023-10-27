package ue.kat.imageHolder.imageHolder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ue.kat.imageHolder.imageHolder.dto.ImageDto;
import ue.kat.imageHolder.imageHolder.service.ImageService;

@RestController
@RequestMapping("${apiV1}/images")
public class ImageController {
  private final ImageService imageService;

  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @GetMapping
  public ImageDto getImageData() {
    return new ImageDto();
  }
}

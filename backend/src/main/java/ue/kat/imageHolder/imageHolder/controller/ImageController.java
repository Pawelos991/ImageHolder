package ue.kat.imageHolder.imageHolder.controller;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ue.kat.imageHolder.imageHolder.dto.BasicResponse;
import ue.kat.imageHolder.imageHolder.dto.image.ImageDto;
import ue.kat.imageHolder.imageHolder.dto.image.ImageRequest;
import ue.kat.imageHolder.imageHolder.service.ImageService;

@RestController
@RequestMapping("${apiV1}/images")
@RequiredArgsConstructor
public class ImageController {
  private final ImageService imageService;

  @GetMapping
  public ImageDto getImageData() {
    return new ImageDto();
  }

  @RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
  public BasicResponse uploadImage(@RequestBody @Valid @ModelAttribute ImageRequest imageRequest) {

    imageService.saveImage(imageRequest);

    return BasicResponse.ok();
  }
}

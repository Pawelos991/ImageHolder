package ue.kat.imageHolder.imageHolder.controller;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public HttpEntity<byte[]> getImageData(@PathVariable int id) {
    ImageDto imageDto = imageService.getImage(id);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageDto.getFilename() + "\"");
    headers.setContentLength(imageDto.getBytes().length);

    return new HttpEntity<>(imageDto.getBytes(), headers);
  }

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public BasicResponse uploadImage(@RequestBody @Valid @ModelAttribute ImageRequest imageRequest) {
    imageService.saveImage(imageRequest);

    return BasicResponse.ok();
  }
}

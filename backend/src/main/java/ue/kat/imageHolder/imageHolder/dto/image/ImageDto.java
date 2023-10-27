package ue.kat.imageHolder.imageHolder.dto.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {
  private String filename;
  private byte[] bytes;
}

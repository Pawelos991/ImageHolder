package ue.kat.imageHolder.imageHolder.dto.image;

import lombok.Data;

@Data
public class ImageDto {
  private Integer id;
  private String name;
  private String filename;
  private String description;
  private String base64;
}

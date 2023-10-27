package ue.kat.imageHolder.imageHolder.dto.image;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ImageRequest {
  @NotNull
  private String name;
  @NotNull
  private String description;
  @NotNull
  private MultipartFile file;
}

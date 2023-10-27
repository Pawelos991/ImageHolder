package ue.kat.imageHolder.imageHolder.mapper;

import java.io.IOException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ue.kat.imageHolder.imageHolder.dto.image.ImageDto;
import ue.kat.imageHolder.imageHolder.dto.image.ImageRequest;
import ue.kat.imageHolder.imageHolder.dto.image.ImageResponse;
import ue.kat.imageHolder.imageHolder.model.ImageEntity;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ImageEntityMapper {
  ImageEntityMapper INSTANCE = Mappers.getMapper(ImageEntityMapper.class);

  @Mapping(target = "filename", expression = "java(imageRequest.getFile().getOriginalFilename())")
  @Mapping(target = "base64",
      expression = "java(java.util.Base64.getEncoder().encodeToString(imageRequest.getFile().getBytes()))")
  ImageEntity toEntity(ImageRequest imageRequest) throws IOException;

  @Mapping(target = "bytes",
      expression = "java(java.util.Base64.getDecoder().decode(imageEntity.getBase64()))")
  ImageDto toDto(ImageEntity imageEntity);

  ImageResponse toResponse(ImageEntity imageEntity);
}

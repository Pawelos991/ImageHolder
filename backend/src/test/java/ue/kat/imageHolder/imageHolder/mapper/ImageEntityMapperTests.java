package ue.kat.imageHolder.imageHolder.mapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ue.kat.imageHolder.imageHolder.dto.image.ImageDto;
import ue.kat.imageHolder.imageHolder.dto.image.ImageRequest;
import ue.kat.imageHolder.imageHolder.dto.image.ImageResponse;
import ue.kat.imageHolder.imageHolder.model.ImageEntity;

@SpringBootTest
public class ImageEntityMapperTests {
    @TestConfiguration
    static class MapperTestsContextConfiguration {
      @Bean
      public ImageEntityMapper imageEntityMapper() {
        return new ImageEntityMapperImpl();
      }
    }

    @Autowired
    private ImageEntityMapper imageEntityMapper;

    @Test
    public void whenValidEntity_thenMappingToResponseShouldWork() throws NullPointerException {
      ImageEntity imageEntity = new ImageEntity();
      imageEntity.setId(1);
      imageEntity.setName("TEST");
      imageEntity.setDescription("TEST TEST");

      ImageResponse imageResponse = imageEntityMapper.toResponse(imageEntity);

      assert (imageResponse.getId()).equals(imageEntity.getId());
      assert (imageResponse.getName()).equals(imageEntity.getName());
      assert (imageResponse.getDescription()).equals(imageEntity.getDescription());
    }

    @Test
    public void whenNotValidRequest_thenMappingToEntityShouldFail() {
      boolean success = true;
      try {
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setName("TEST");
        imageRequest.setDescription("TEST TEST");

        imageEntityMapper.toEntity(imageRequest);
      } catch (NullPointerException | IOException  ignored) {
        success = false;
      }
      assert !success;
    }

    @Test
    public void whenValidEntity_thenMappingToDtoShouldWork() {
      ImageEntity imageEntity = new ImageEntity();
      imageEntity.setFilename("TEST.png");
      imageEntity.setBase64("iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAIAAAAC64paAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcE"
          + "hZcwAADsMAAA7DAcdvqGQAAAEbSURBVDhPxZTLbcQwDETZ5Z737i7SQJpIAWki9fj/kw3n2SMwShQFvmUgeE3ODLlLiGshhK7rxnFc17Vpmm"
          + "3bboZt21rf9/M8HxmGYUCBtMQuy2KUIbAMJKH+Zs+PEu2IqQTf8h9mb6SSk+KoquP5/DpVFQnh3ez1pvnx4BkJITcXz1Ui2oT/M+cDKx5+vw"
          + "8sHTr+l1T32xGiixvm5jv9BSzxhukaeYlSf0HKaZrOG0YBLqr8okv9BWSIufB8ZWNXWAAqsQNX0ShL+wtiEWNGzIaZtgwz2bqu3Zz2F6D2f"
          + "XcxXeNKEvsOXg3cckIZsS6OAyMAeuEJcrPyIBXHgfFGSQpT3ufn+MEqPAfGvwkpYjh+fzo/D6mVsyGETxwSkFHOlcfGAAAAAElFTkSuQmCC"
      );
      ImageDto imageDto = imageEntityMapper.toDto(imageEntity);
      assert (imageDto.getFilename()).equals(imageEntity.getFilename());
      assert Arrays.equals((imageDto.getBytes()), Base64.getDecoder().decode(imageEntity.getBase64()));
    }

    @Test
    public void whenNotValidEntity_thenMappingToDtoShouldFail() {
      boolean success = true;
      try {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setFilename("TEST.png");
        imageEntity.setBase64("Bad Base 64 :(");
        imageEntityMapper.toDto(imageEntity);
      } catch (IllegalArgumentException ignored) {
        success = false;
      }
      assert !success;
    }


}

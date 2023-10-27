package ue.kat.imageHolder.imageHolder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "image")
@Getter
@Setter
public class ImageEntity {
  private static final String GENERATOR_NAME = "image_generator";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
  @SequenceGenerator(
      name = GENERATOR_NAME,
      sequenceName = "image_seq",
      schema = "public",
      allocationSize = 1)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "filename", nullable = false)
  private String filename;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "base64", nullable = false)
  private String base64;
}

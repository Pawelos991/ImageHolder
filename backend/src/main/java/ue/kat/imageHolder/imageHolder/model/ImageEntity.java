package ue.kat.imageHolder.imageHolder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "image")
public class ImageEntity {
  private static final String GENERATOR_NAME = "image_generator";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
  @SequenceGenerator(
      name = GENERATOR_NAME,
      sequenceName = "images_seq",
      schema = "public",
      allocationSize = 1)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "filename")
  private String filename;

  @Column(name = "description")
  private String description;

  @Column(name = "base64")
  private String base64;
}

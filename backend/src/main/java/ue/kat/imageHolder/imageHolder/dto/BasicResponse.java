package ue.kat.imageHolder.imageHolder.dto;

public record BasicResponse(boolean success) {
  public static BasicResponse ok() {
    return new BasicResponse(true);
  }
}

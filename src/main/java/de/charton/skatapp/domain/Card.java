package de.charton.skatapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Card {
  SIEBEN(1),
  ACHT(2),
  NEUN(3),
  ZEHN(4),
  BUBE(5),
  DAHME(6),
  KOENING(7),
  ASS(8);

  private final int value;
}

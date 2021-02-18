package de.charton.skatapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
  KARO(1),
  HERZ(2),
  PIK(3),
  KREUZ(4);

  private final int value;
}

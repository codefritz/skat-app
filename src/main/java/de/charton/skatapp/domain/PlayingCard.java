package de.charton.skatapp.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Builder
@Data
@ToString
public class PlayingCard {
  @NonNull private final Color color;
  @NonNull private final Card card;

  public static PlayingCard of(Color color, Card card) {
    return PlayingCard.builder()
        .color(color)
        .card(card)
        .build();
  }
}

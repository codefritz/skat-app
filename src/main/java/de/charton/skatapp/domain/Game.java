package de.charton.skatapp.domain;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;

@Builder
@Data
@With
@ToString
public class Game {
  @NonNull private final List<Player> players;
  private final Map<Player, List<PlayingCard>> deck;
  private final List<PlayingCard> skat;
}

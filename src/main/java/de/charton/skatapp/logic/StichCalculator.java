package de.charton.skatapp.logic;

import de.charton.skatapp.domain.Color;
import de.charton.skatapp.domain.PlayingCard;
import java.util.Set;

public interface StichCalculator {
  PlayingCard calc(Set<PlayingCard> set, Color color);
}

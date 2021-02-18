package de.charton.skatapp.logic;

import de.charton.skatapp.domain.Card;
import de.charton.skatapp.domain.Color;
import de.charton.skatapp.domain.PlayingCard;
import java.util.Comparator;
import java.util.Set;

/**
 * Calculate the stich on a "normal" color game.
 */
public class ColorGameStichCalculator implements StichCalculator {

  @Override
  public PlayingCard calc(Set<PlayingCard> set, Color givenColor) {
    return set.stream().sorted(new Comparator<PlayingCard>() {
      @Override
      public int compare(PlayingCard o1, PlayingCard o2) {
        var colorCode = getValue(o2) - getValue(o1);
        return colorCode;
      }

      private int getValue(PlayingCard cur) {
        var colorValue = cur.getCard() == Card.BUBE ? 5 + cur.getColor().getValue() :
            givenColor == cur.getColor() ? 5 :
                cur.getColor().getValue();
        return
            colorValue * 10 + cur.getCard().getValue();
      }
    }).findFirst().get();
  }
}

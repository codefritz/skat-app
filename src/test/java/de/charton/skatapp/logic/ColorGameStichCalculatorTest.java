package de.charton.skatapp.logic;

import static de.charton.skatapp.domain.PlayingCard.of;
import static org.assertj.core.api.Assertions.assertThat;

import de.charton.skatapp.domain.Card;
import de.charton.skatapp.domain.Color;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ColorGameStichCalculatorTest {

  private ColorGameStichCalculator colorGameStichCalculator = new ColorGameStichCalculator();

  @Test
  void kreuzBubeShouldWin() {
    var stich = colorGameStichCalculator.calc(Set.of(
        of(Color.PIK, Card.BUBE),
        of(Color.KARO, Card.BUBE),
        of(Color.KREUZ, Card.BUBE)
    ), Color.PIK);

    assertThat(stich).isEqualTo(of(Color.KREUZ, Card.BUBE));
  }

  @Test
  void bubeShouldWin() {
    var stich = colorGameStichCalculator.calc(Set.of(
        of(Color.HERZ, Card.BUBE),
        of(Color.PIK, Card.ASS),
        of(Color.PIK, Card.DAHME)
    ), Color.PIK);

    assertThat(stich).isEqualTo(of(Color.HERZ, Card.BUBE));
  }

  @Test
  void colorShouldWin() {
    var stich = colorGameStichCalculator.calc(Set.of(
        of(Color.PIK, Card.SIEBEN),
        of(Color.KARO, Card.SIEBEN),
        of(Color.KREUZ, Card.SIEBEN)
    ), Color.PIK);

    assertThat(stich).isEqualTo(of(Color.PIK, Card.SIEBEN));
  }

  @Test
  void assOnColorShouldWin() {
    var stich = colorGameStichCalculator.calc(Set.of(
        of(Color.PIK, Card.SIEBEN),
        of(Color.PIK, Card.ASS),
        of(Color.PIK, Card.DAHME)
    ), Color.PIK);

    assertThat(stich).isEqualTo(of(Color.PIK, Card.ASS));
  }

  @Test
  void assOnNoneColorShouldWin() {
    var stich = colorGameStichCalculator.calc(Set.of(
        of(Color.HERZ, Card.SIEBEN),
        of(Color.HERZ, Card.ASS),
        of(Color.HERZ, Card.DAHME)
    ), Color.PIK);

    assertThat(stich).isEqualTo(of(Color.HERZ, Card.ASS));
  }

  @Test
  void colorShouldBetWin() {
    var stich = colorGameStichCalculator.calc(Set.of(
        of(Color.HERZ, Card.ASS),
        of(Color.PIK, Card.SIEBEN),
        of(Color.KREUZ, Card.ASS)
    ), Color.PIK);

    assertThat(stich).isEqualTo(of(Color.PIK, Card.SIEBEN));
  }

}
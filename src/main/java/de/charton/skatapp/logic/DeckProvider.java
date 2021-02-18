package de.charton.skatapp.logic;

import de.charton.skatapp.domain.Card;
import de.charton.skatapp.domain.Color;
import de.charton.skatapp.domain.PlayingCard;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DeckProvider {

  public List<PlayingCard> provideDeck() {
    List<PlayingCard> playingCards = new ArrayList<>();

    for (Color color : Color.values()) {
      for(Card card : Card.values()) {
        playingCards.add(PlayingCard.builder()
            .card(card)
            .color(color)
            .build());
      }
    }

    return playingCards;
  }
}

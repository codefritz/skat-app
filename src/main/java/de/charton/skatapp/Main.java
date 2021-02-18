package de.charton.skatapp;

import de.charton.skatapp.domain.Game;
import de.charton.skatapp.domain.Player;
import de.charton.skatapp.domain.PlayingCard;
import de.charton.skatapp.logic.DeckProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {

    var playingCards = new DeckProvider().provideDeck();

    Collections.shuffle(playingCards);

    // System.out.println(playingCards);
    Map<Player, List<PlayingCard>> deck = new HashMap<>();

    for(int ix = 0; ix < 3; ix++) {
      List<PlayingCard> cards = new ArrayList<>();
      for(int iy = 0; iy < 10; iy++) {
        cards.add(playingCards.get(ix * 10 + iy));
      }
      System.out.println(cards);
    }


    Game game = Game.builder()
        .players(List.of(aPlayer("Andre"), aPlayer("Alex"), aPlayer("Mike")))
        .deck(deck)
        .skat(playingCards.subList(30, 32))
        .build();

    log.info("Game is now: {}", game);


  }

  private static Player aPlayer(String name) {
    log.info("Create player {}", name);
    return Player.builder().name(name).build();
  }

}

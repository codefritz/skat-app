package de.charton.skatapp.gameStorage;

import de.charton.skatapp.domain.Game;
import de.charton.skatapp.domain.Player;
import de.charton.skatapp.domain.PlayingCard;
import de.charton.skatapp.logic.DeckProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class GameStorage {

  private Game game;

  public Game getGame() {
    return game;
  }

  @PostConstruct
  void initGame() {

    var playingCards = new DeckProvider().provideDeck();
    Collections.shuffle(playingCards);

    var players = List.of(aPlayer("Andre"), aPlayer("Alex"), aPlayer("Mike"));

    Map<Player, List<PlayingCard>> deck = new HashMap<>();

    for(int iPlayer = 0; iPlayer < 3; iPlayer++) {
      var p = players.get(iPlayer);
      List<PlayingCard> cards = new ArrayList<>();
      for(int iCards = 0; iCards < 10; iCards++) {
        cards.add(playingCards.get(iPlayer * 10 + iCards));
      }
      deck.put(p, cards);
      System.out.println(cards);
    }

    game = Game.builder()
        .players(players)
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

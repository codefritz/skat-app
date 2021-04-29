package de.charton.skatapp.controller;

import de.charton.skatapp.domain.Player;
import de.charton.skatapp.domain.PlayingCard;
import de.charton.skatapp.gameStorage.GameStorage;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
class GameController {

  private final GameStorage gameStorage;

  @GetMapping("/hello")
  ResponseEntity<String> greetings() {
    return ResponseEntity.ok("Hello\n");
  }

  @GetMapping("/deck/{playerName}")
  ResponseEntity<String> getDeck(@PathVariable String playerName) {
    return ResponseEntity.ok(gameStorage.getGame()
        .getDeck()
        .get(Player.builder().name(playerName).build())
        .stream()
        .map(PlayingCard::toString)
        .collect(Collectors.joining("|")));
  }

}

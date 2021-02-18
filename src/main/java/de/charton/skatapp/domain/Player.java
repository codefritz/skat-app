package de.charton.skatapp.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;

@Builder
@Data
@ToString
@With
public class Player {

  @NonNull private final String name;

}

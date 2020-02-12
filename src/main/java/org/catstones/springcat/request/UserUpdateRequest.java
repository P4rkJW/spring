package org.catstones.springcat.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
public class UserUpdateRequest {
  private Optional<String> email;
  private Optional<String> password;
  private Optional<String> displayName;
}

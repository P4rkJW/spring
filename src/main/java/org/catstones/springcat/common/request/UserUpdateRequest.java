package org.catstones.springcat.common.request;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
public class UserUpdateRequest {
  private Optional<String> email;
  private Optional<String> password;
  private Optional<String> displayName;
}

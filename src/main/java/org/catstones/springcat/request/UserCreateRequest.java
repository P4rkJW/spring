package org.catstones.springcat.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserCreateRequest {
  private String email;
  private String password;
  private String displayName;
}

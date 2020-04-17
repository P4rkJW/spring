package org.catstones.springcat.common.request;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
public class UserCreateRequest {
  private String email;
  private String password;
  private String displayName;
}

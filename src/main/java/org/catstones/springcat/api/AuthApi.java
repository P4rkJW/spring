package org.catstones.springcat.api;

import org.springframework.web.bind.annotation.RestController;
import com.google.firebase.auth.*;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.auth.UserRecord.UpdateRequest;
import org.catstones.springcat.common.request.UserCreateRequest;
import org.catstones.springcat.common.request.UserUpdateRequest;
import org.catstones.springcat.common.response.ListResponse;
import org.catstones.springcat.common.response.SingleResponse;
import org.springframework.web.bind.annotation.*;
import org.catstones.springcat.exception.BusinessException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/users")
public class AuthApi {

  @PostMapping
  public SingleResponse<UserRecord> createUser(@RequestBody UserCreateRequest requestBody)
      throws InterruptedException, ExecutionException {

    if (!requestBody.getEmail().endsWith("catholic.ac.kr")) {
      throw new BusinessException("이메일 호스팅이 catholic.ac.kr이 아닙니다.", 401);
    }

    CreateRequest request =
        new CreateRequest().setEmail(requestBody.getEmail()).setPassword(requestBody.getPassword())
            .setDisplayName(requestBody.getDisplayName()).setDisabled(false);

    UserRecord userRecord = FirebaseAuth.getInstance().createUserAsync(request).get();

    return new SingleResponse<>(userRecord);
  }

  @DeleteMapping("{uid}")
  public SingleResponse<String> deleteUser(@PathVariable String uid)
      throws InterruptedException, ExecutionException {
    FirebaseAuth.getInstance().deleteUserAsync(uid).get();
    return new SingleResponse<>("Success");
  }

  @GetMapping
  public ListResponse<ExportedUserRecord> showUsers()
      throws InterruptedException, ExecutionException {
    ListUsersPage page = FirebaseAuth.getInstance().listUsersAsync(null).get();
    List<ExportedUserRecord> userList = new ArrayList<>();
    for (ExportedUserRecord user : page.getValues()) {
      userList.add(user);
    }

    return new ListResponse<>(userList);
  }

  @GetMapping("{uid}")
  public SingleResponse<UserRecord> showUser(@PathVariable String uid)
      throws InterruptedException, ExecutionException {
    UserRecord userRecord = FirebaseAuth.getInstance().getUserAsync(uid).get();
    return new SingleResponse<>(userRecord);
  }

  @PutMapping("{uid}")
  public SingleResponse<UserRecord> updateUser(@PathVariable String uid,
      @RequestBody UserUpdateRequest request) throws InterruptedException, ExecutionException {
    UpdateRequest updateRequest = new UpdateRequest(uid);
    if (request.getEmail().isPresent()) {
      updateRequest.setEmail(request.getEmail().get());
    }
    if (request.getDisplayName().isPresent()) {
      updateRequest.setDisplayName(request.getDisplayName().get());
    }
    if (request.getPassword().isPresent()) {
      updateRequest.setPassword(request.getPassword().get());
    }
    UserRecord userRecord = FirebaseAuth.getInstance().updateUserAsync(updateRequest).get();

    return new SingleResponse<>(userRecord);
  }
}

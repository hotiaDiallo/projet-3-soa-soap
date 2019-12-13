package endPoint;

import com.ib.library.model.User;
import com.ib.library.service.abstraction.UserService;
import library.soap.web_services.LoginRequest;
import library.soap.web_services.LoginResponse;
import library.soap.web_services.UserWS;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {
  private static final String NAMESPACE_URI = "http://library/soap/web-services";

  @Autowired
  private UserService userService;

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoginRequest")
  @ResponsePayload
  public LoginResponse logUserIn(@RequestPayload LoginRequest loginRequest){
    LoginResponse loginResponse = new LoginResponse();
    User user = null;
    user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

    UserWS userWS = null;
    if(user != null){
       userWS = new UserWS();
      BeanUtils.copyProperties(user, userWS);
    }
    loginResponse.setUserWS(userWS);
    return loginResponse;
  }
}

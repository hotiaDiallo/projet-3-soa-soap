package endPoint;

import config_const.Utils;
import com.ib.library.model.User;
import com.ib.library.service.abstraction.UserService;
import library.soap.web_services.GetUserLoginRequest;
import library.soap.web_services.GetUserLoginResponse;
import library.soap.web_services.UserWS;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {

  @Autowired
  private UserService userService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "LoginRequest")
  @ResponsePayload
  public GetUserLoginResponse logUserIn(@RequestPayload GetUserLoginRequest loginRequest){
    GetUserLoginResponse loginResponse = new GetUserLoginResponse();
    User user = null;
    user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

    UserWS userWS = null;
    if(user != null){
       userWS = new UserWS();
       BeanUtils.copyProperties(user, userWS);
    }
    loginResponse.setUser(userWS);
    return loginResponse;
  }
}

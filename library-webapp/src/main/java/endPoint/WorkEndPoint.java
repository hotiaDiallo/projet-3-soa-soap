package endPoint;

import com.ib.library.model.Work;
import com.ib.library.service.abstraction.WorkService;
import config_const.Utils;
import library.soap.web_services.GetWorkByTitleRequest;
import library.soap.web_services.GetWorkByTitleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WorkEndPoint {

  @Autowired
  private WorkService workService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByTitleRequest")
  @ResponsePayload
  public GetWorkByTitleResponse getWorkByTitleResponse (@RequestPayload GetWorkByTitleRequest request){
    GetWorkByTitleResponse workResponse = new GetWorkByTitleResponse();
    //List<Work> works = workService.findWorksByTitle(request.getTitle());
    return workResponse;
  }

//  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByTitleRequest")
//  @ResponsePayload
//  public GetWorkByAuthorResponse getWorkByTitleResponse (@RequestPayload GetWorkByAuthorRequest request){
//    GetWorkByAuthorResponse workResponse = new GetWorkByAuthorResponse();
//    AuthorWS authorWS = request.getAuthor();
//    Author author = new Author();
//    if(authorWS !=null){
//      BeanUtils.copyProperties(authorWS, author);
//      List<Work> works = workService.findWorksByAuthorName(author.getFirstName());
//      List<WorkWS> listWorks = new ArrayList<>();
//      for(Work work : works){
//        WorkWS workWS = new WorkWS();
//        BeanUtils.copyProperties(work, workWS);
//        listWorks.add(workWS);
//      }
//      workResponse.getWork().add((WorkWS) listWorks);
//    }
//    return workResponse;
//  }
}


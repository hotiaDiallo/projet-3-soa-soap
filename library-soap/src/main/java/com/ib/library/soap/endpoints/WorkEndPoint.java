package com.ib.library.soap.endpoints;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import com.ib.library.service.abstraction.WorkService;
import com.ib.library.soap.Utils;
import java.util.ArrayList;
import java.util.List;
import library.soap.web_services.AuthorWS;
import library.soap.web_services.GetWorkByAuthorRequest;
import library.soap.web_services.GetWorkByAuthorResponse;
import library.soap.web_services.GetWorkByIdRequest;
import library.soap.web_services.GetWorkByIdResponse;
import library.soap.web_services.GetWorkByTitleRequest;
import library.soap.web_services.GetWorkByTitleResponse;
import library.soap.web_services.WorkWS;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WorkEndPoint {

  @Autowired
  private WorkService workService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByIdRequest")
  @ResponsePayload
  public GetWorkByIdResponse getWorkById(@RequestPayload GetWorkByIdRequest request){
    GetWorkByIdResponse workByIdResponse = new GetWorkByIdResponse();
    Work work = this.workService.findWorkById(request.getId());
    WorkWS workWS = null;
    if (work != null){
      workWS = new WorkWS();
      BeanUtils.copyProperties(work, workWS);
    }
    workByIdResponse.setWork(workWS);
    return workByIdResponse;
  }


  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByTitleRequest")
  @ResponsePayload
  public GetWorkByTitleResponse getWorkByTitleRequest (@RequestPayload GetWorkByTitleRequest request){
    GetWorkByTitleResponse workResponse = new GetWorkByTitleResponse();
    Work work = workService.findWorkByTitle(request.getTitle());
    WorkWS workWS = new WorkWS();
    BeanUtils.copyProperties(work, workWS);
    workResponse.setWork(workWS);
    return workResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByAuthorRequest")
  @ResponsePayload
  public GetWorkByAuthorResponse getWorkByAuthor (@RequestPayload GetWorkByAuthorRequest request){
    GetWorkByAuthorResponse workResponse = new GetWorkByAuthorResponse();
    AuthorWS authorWS = request.getAuthor();
    Author author = new Author();
    if(authorWS !=null){
      BeanUtils.copyProperties(authorWS, author);
      List<Work> works = workService.findWorkByAuthor(author);
      List<WorkWS> listWorks = new ArrayList<>();
      for(Work work : works){
        WorkWS workWS = new WorkWS();
        BeanUtils.copyProperties(work, workWS);
        listWorks.add(workWS);
      }
      workResponse.getWork().add((WorkWS) listWorks);
    }
    return workResponse;
  }
}


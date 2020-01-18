package com.ib.library.soap.endpoints;

import com.ib.library.model.Loan;
import com.ib.library.service.abstraction.LoanService;
import com.ib.library.soap.Utils;
import library.soap.web_services.GetCreateLoanRequest;
import library.soap.web_services.GetCreateLoanResponse;
import library.soap.web_services.GetExtendLoanRequest;
import library.soap.web_services.GetExtendLoanResponse;
import library.soap.web_services.GetLoanByIdRequest;
import library.soap.web_services.GetLoanByIdResponse;
import library.soap.web_services.GetReturnLoanRequest;
import library.soap.web_services.GetReturnLoanResponse;
import library.soap.web_services.LoanWS;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class LoanEndPoint {

  @Autowired
  private LoanService loanService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLoanByIdRequest")
  @ResponsePayload
  public GetLoanByIdResponse getLoanById(@RequestPayload GetLoanByIdRequest request){
    GetLoanByIdResponse loanByIdResponse = new GetLoanByIdResponse();
    Loan loan = this.loanService.findLoanById(request.getId());
    LoanWS loanWS = null;
    if (loan != null){
      loanWS = new LoanWS();
      BeanUtils.copyProperties(loan, loanWS);
    }
    loanByIdResponse.setLoan(loanWS);
    return loanByIdResponse;
  }


  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getCreateLoanRequest")
  @ResponsePayload
  public GetCreateLoanResponse createLoan(@RequestPayload GetCreateLoanRequest loanRequest){
    GetCreateLoanResponse loanResponse = new GetCreateLoanResponse();
    String response = this.loanService.createLoan(loanRequest.getWorkId(), loanRequest.getUserId());
    loanResponse.setResponse(response);
    return loanResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getExtendLoanRequest")
  @ResponsePayload
  public GetExtendLoanResponse extendLoan(@RequestPayload GetExtendLoanRequest loanRequest){
    GetExtendLoanResponse loanResponse = new GetExtendLoanResponse();
    String response = this.loanService.extendLoan(loanRequest.getLoanId());
    loanResponse.setResponse(response);
    return loanResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getReturnLoanRequest")
  @ResponsePayload
  public GetReturnLoanResponse returnLoan(@RequestPayload GetReturnLoanRequest loanRequest){
    GetReturnLoanResponse loanResponse = new GetReturnLoanResponse();
    String response = this.loanService.returnLoan(loanRequest.getLoanId());
    loanResponse.setResponse(response);
    return loanResponse;
  }

}

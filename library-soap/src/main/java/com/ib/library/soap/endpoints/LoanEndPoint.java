package com.ib.library.soap.endpoints;

import com.ib.library.model.Loan;
import com.ib.library.service.abstraction.LoanService;
import com.ib.library.soap.Utils;
import java.util.ArrayList;
import java.util.List;
import library.soap.web_services.GetCreateLoanRequest;
import library.soap.web_services.GetCreateLoanResponse;
import library.soap.web_services.GetExtendLoanRequest;
import library.soap.web_services.GetExtendLoanResponse;
import library.soap.web_services.GetLoanByIdRequest;
import library.soap.web_services.GetLoanByIdResponse;
import library.soap.web_services.GetLoanByUserRequest;
import library.soap.web_services.GetLoanByUserResponse;
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

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLoanByUserRequest")
  @ResponsePayload
  public GetLoanByUserResponse getLoanByUser (@RequestPayload GetLoanByUserRequest request){
    GetLoanByUserResponse loanByUserResponse = new GetLoanByUserResponse();
    List<Loan> loans = loanService.findLoanByUser(request.getUserId());
    loanByUserResponse.getLoan().addAll(populateReturnList(loans));
    return loanByUserResponse;
  }


  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getCreateLoanRequest")
  @ResponsePayload
  public GetCreateLoanResponse createLoan(@RequestPayload GetCreateLoanRequest loanRequest){
    GetCreateLoanResponse loanResponse = new GetCreateLoanResponse();
    LoanWS loanWS = new LoanWS();
    Loan loan = this.loanService.createLoan(loanRequest.getWorkId(), loanRequest.getUserId());
    BeanUtils.copyProperties(loan, loanWS);
    loanResponse.setLoan(loanWS);
    return loanResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getExtendLoanRequest")
  @ResponsePayload
  public GetExtendLoanResponse extendLoan(@RequestPayload GetExtendLoanRequest loanRequest){
    GetExtendLoanResponse loanResponse = new GetExtendLoanResponse();
    LoanWS loanWS = new LoanWS();
    Loan loan = this.loanService.extendLoan(loanRequest.getLoanId());
    BeanUtils.copyProperties(loan, loanWS);
    loanResponse.setLoan(loanWS);
    return loanResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getReturnLoanRequest")
  @ResponsePayload
  public GetReturnLoanResponse returnLoan(@RequestPayload GetReturnLoanRequest loanRequest){
    GetReturnLoanResponse loanResponse = new GetReturnLoanResponse();
    LoanWS loanWS = new LoanWS();
    Loan loan = this.loanService.returnLoan(loanRequest.getLoanId());
    BeanUtils.copyProperties(loan, loanWS);
    loanResponse.setLoan(loanWS);
    return loanResponse;
  }

  private List<LoanWS> populateReturnList(List<Loan> loanList){
    List<LoanWS> loanWSList = new ArrayList<>();
    for (Loan loan : loanList){
      LoanWS loanWS = new LoanWS();
      BeanUtils.copyProperties(loan, loanWS);
      loanWSList.add(loanWS);
    }
    return loanWSList;
  }

}

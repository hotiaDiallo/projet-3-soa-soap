package com.ib.library.soap.endpoints;//package endPoint;
//
//import com.ib.library.model.Book;
//import com.ib.library.model.Loan;
//import com.ib.library.model.User;
//import com.ib.library.service.abstraction.LoanService;
//import java.util.ArrayList;
//import java.util.List;
//import library.soap.web_services.BookWS;
//import library.soap.web_services.GetLoanByBookRequest;
//import library.soap.web_services.GetLoanByBookResponse;
//import library.soap.web_services.GetLoanByUserRequest;
//import library.soap.web_services.GetLoanByUserResponse;
//import library.soap.web_services.GetLoansRequest;
//import library.soap.web_services.GetLoansResponse;
//import library.soap.web_services.LoanWS;
//import library.soap.web_services.UserWS;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//@Endpoint
public class LoanEndPoint {
//
//  @Autowired
//  private LoanService loanService;
//
//  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLoansRequest")
//  @ResponsePayload
//  public GetLoansResponse getAllLoans(){
//    GetLoansResponse loansResponse = new GetLoansResponse();
//    List<Loan> loans = loanService.findAllLoans();
//    List<LoanWS>listLoanWS = new ArrayList<>();
//    for(Loan loan : loans){
//      LoanWS loanWS = new LoanWS();
//      BeanUtils.copyProperties(loan, loanWS);
//      listLoanWS.add(loanWS);
//    }
//    loansResponse.getLoans().addAll(listLoanWS);
//    return loansResponse;
//  }
//
//  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLoanByUserRequest")
//  @ResponsePayload
//  public GetLoanByUserResponse getLoanByUser (@RequestPayload GetLoanByUserRequest request){
//    GetLoanByUserResponse loanByUserResponse = new GetLoanByUserResponse();
//    UserWS userWS = request.getUser();
//    User user = new User();
//    if( userWS != null){
//      BeanUtils.copyProperties(userWS, user);
//      List<Loan> loans = loanService.findLoanByUser(user);
//      List<LoanWS> listLoans = new ArrayList<>();
//      for(Loan loan : loans){
//        LoanWS loanWS = new LoanWS();
//        BeanUtils.copyProperties(loan, loanWS);
//        listLoans.add(loanWS);
//      }
//      loanByUserResponse.getLoan().addAll(listLoans);
//    }
//    return loanByUserResponse;
//  }
//
//  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLoanByBookRequest")
//  @ResponsePayload
//  public GetLoanByBookResponse getLoanByBook(@RequestPayload GetLoanByBookRequest request){
//    GetLoanByBookResponse getLoanByBookResponse = new GetLoanByBookResponse();
//    BookWS bookWS = request.getBook();
//    Book book = null;
//    LoanWS loanWS = null;
//    if (bookWS != null){
//      book = new Book();
//      BeanUtils.copyProperties(bookWS, book);
//    }
//    if( book != null){
//      Loan loan = loanService.findLoanByBook(book.getId()).get();
//      loanWS = new LoanWS();
//      BeanUtils.copyProperties(loan, loanWS);
//    }
//    getLoanByBookResponse.setLoan(loanWS);
//    return getLoanByBookResponse;
//  }
//
//
}

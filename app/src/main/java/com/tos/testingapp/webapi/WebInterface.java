package com.tos.testingapp.webapi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebInterface {


   /* @FormUrlEncoded
    @POST(WebMethod.CUSTOMER_LOGIN)
    public Call<AccessToken> postLoginRequest(@Field("client_id") String client_id, @Field("username") String username, @Field("password") String password, @Field("grant_type") String grant_type);

    @GET(WebMethod.PROFILE)
    Call<UserProfile> getUserProfileData(@Header("Authorization") String token);

    @GET(WebMethod.BRANCHES)
    Call<Branches> getBranchesData(@Header("Authorization") String token);


    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(WebMethod.POTENTIAL_CLIENT_REQUEST)
    public Call<ResponseBody> postNewClientRequest(@Body PotentialClientRequest potentialClientRequest);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(WebMethod.DEPOSIT_ACCOUNT)
    public Call<DepositAccountDetails> getDepositAccountData(@Header("Authorization") String token, @Body DepositRequest request);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(WebMethod.ACCOUNT_TRANSACTIONS)
    public Call<AccountTransaction> getAccountTransaction(@Header("Authorization") String token, @Body TransactionRequest request);


    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(WebMethod.LOAN_ACCOUNT)
    public Call<LoanAccountDetails> getLoanAccountData(@Header("Authorization") String token, @Body DepositRequest request);


    @PATCH(WebMethod.SMS_VALIDATE)
    public Call<ResponseBody> postSmsCode(@Query("token") String token, @Query("digitCode") String digitCode);


    @PATCH(WebMethod.RESEND_SMS_CODE)
    public Call<Void> postResendSmsCode(@Query("token") String token);

*/
}

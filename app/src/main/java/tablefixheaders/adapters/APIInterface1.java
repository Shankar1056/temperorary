package tablefixheaders.adapters;

import pojo.Adverseevent;
import pojo.AefiReportwriting;
import pojo.ChildRegisterResponse;
import pojo.ChildRequest;
import pojo.ChildViewRequest;
import pojo.ChildViewResponse;
import pojo.Diluent;
import pojo.Login;
import pojo.LoginResponse;
import pojo.Monthlyworkupdate;
import pojo.Pregnantwomen;
import pojo.Reportwriting;
import pojo.Serveyhousedetail;
import pojo.Survey;
import pojo.Users;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface1 {

   /* @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();*/

    @POST("/childreg")
    Call<ChildRegisterResponse> createUser(@Body Users user);

    @POST("/childetails")
    Call<ChildRegisterResponse> childReg(@Body ChildRequest user);
    @POST("/viewchild")
    Call<ChildViewResponse> chilview(@Body ChildViewRequest user);


    /**
     * @param login
     * @return
     */
    @POST("/maidilogin")
    Call<LoginResponse> maidLogin(@Body Login login);

    @POST("/anmdetails")
    Call<ChildRegisterResponse> createServy(@Body Survey user);
    @POST("/reportdetails")
    Call<ChildRegisterResponse> reportdetails(@Body AefiReportwriting user);
    @POST("/housedetails")

    Call<ChildRegisterResponse> housdetail(@Body Serveyhousedetail user);
    @POST("/monthlywork")

    Call<ChildRegisterResponse> Monthlyworkupdate(@Body Monthlyworkupdate user);
    @POST("/diluent")
    Call<ChildRegisterResponse> diluent(@Body Diluent user);
    @POST("/diluent")
    Call<ChildRegisterResponse> adverseevent(@Body Adverseevent user);

    @POST("/pregantwoman")
    Call<ChildRegisterResponse> pregantwoman(@Body Pregnantwomen user);
    @POST("/reportwrite")
    Call<ChildRegisterResponse> reportWriting(@Body Reportwriting report);
    // /api/users


   /* @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}

package mainscreen.govt.maidi.com.maidi;




import pojo.ChildRegisterResponse;
import pojo.ChildRequest;
import pojo.ChildViewRequest;
import pojo.ChildViewResponse;
import pojo.Login;
import pojo.LoginResponse;
import pojo.Reportwriting;
import pojo.Users;
import pojo.monthlyViewRequest;
import pojo.monthlyViewResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by anupamchugh on 09/01/17.
 */

public interface APIInterface {

   /* @GET("")
    Call<MultipleResource> doGetListResources();*/

    @POST("/childreg")
    Call<ChildRegisterResponse> createUser(@Body Users user);

    @POST("/childetails")
    Call<ChildRegisterResponse> childReg(@Body ChildRequest user);
    @POST("/viewchild")
    Call<ChildViewResponse> chilview(@Body ChildViewRequest user);

    @POST("/monthlyviewwork")
    Call<monthlyViewResponse> monthlyview(@Body monthlyViewRequest user);
    /**
     * @param login
     * @return
     */
    @POST("/maidilogin")
    Call<LoginResponse> maidLogin(@Body Login login);
    @GET("/immunization")
    Call<ChildRegisterResponse> SimpleTable();
    @POST("/maidisurvey")
    Call<ChildRegisterResponse> createServy(@Body ChildRegisterResponse user);

    @POST("/reportwrite")
    Call<ChildRegisterResponse> reportWriting(@Body Reportwriting report);
    // /api/users


   /* @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}

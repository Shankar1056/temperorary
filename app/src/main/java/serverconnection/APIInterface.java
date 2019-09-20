package serverconnection;




import pojo.Survey;
import pojo.Users;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by anupamchugh on 09/01/17.
 */

interface APIInterface {

   /* @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();*/

    @POST("/childreg")
    Call<Users> createUser(@Body Users user);

    @POST("/maidisurvey")
    Call<Survey> createServy(@Body Survey user);
   // /api/users


   /* @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);*/
}

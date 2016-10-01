package poojab26.travelstyle;

import okhttp3.MultipartBody;
import poojab26.travelstyle.Models.Classifier.Example;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by pblead26 on 01-Oct-16.
 */
public interface Watson {
        // Request method and URL specified in the annotation
        // Callback for the parsed response is the last parameter

        @Multipart
        @POST("classify?api_key=43fd976fab75fbc6909ddc9eb4a3a2cb38f6d74f&version=2016-05-20&classifier_ids=clothes_607342350")
        Call<Example> classify(
                @Part MultipartBody.Part file);



}

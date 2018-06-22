package com.padcmyanmar.ted.talks.assignment.tra.network;

import com.padcmyanmar.ted.talks.assignment.tra.network.responses.GetTalksResponse;
import com.padcmyanmar.ted.talks.assignment.tra.utils.TalksConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TalksApi {
    @FormUrlEncoded
    @POST(TalksConstants.GET_TALKS)
    Call<GetTalksResponse> loadTalksList(
            @Field(TalksConstants.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(TalksConstants.PARAM_PAGE) int page);
}

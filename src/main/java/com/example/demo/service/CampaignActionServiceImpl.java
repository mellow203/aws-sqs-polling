package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.Campaign;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CampaignActionServiceImpl implements CampaignService {
    private final ObjectMapper objectMapper;
    String FBToken = "FBTOKEN";

    public CampaignActionServiceImpl(ObjectMapper objectMapper) {this.objectMapper = objectMapper;}

    public void campaignStatus() throws Exception {
        APIContext context = new APIContext(FBToken).enableDebug(true);
        Map<String, Object> param = new HashMap<>();
        param.put("status", "ACTIVE");
        Map<String, Object> paramMap = objectMapper.convertValue(param, new TypeReference<Map<String, Object>>() {});

        new Campaign("123123123", context)
                .update()
                .setParams(paramMap)
                .execute();



    }
}

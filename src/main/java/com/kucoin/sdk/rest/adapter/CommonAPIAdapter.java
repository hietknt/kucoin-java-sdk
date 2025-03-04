/**
 * Copyright 2019 Mek Global Limited.
 */
package com.kucoin.sdk.rest.adapter;

import com.kucoin.sdk.ProxySettings;
import com.kucoin.sdk.rest.impl.retrofit.PublicRetrofitAPIImpl;
import com.kucoin.sdk.rest.interfaces.CommonAPI;
import com.kucoin.sdk.rest.interfaces.retrofit.CommonAPIRetrofit;
import com.kucoin.sdk.rest.response.ServiceStatusResponse;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by chenshiwei on 2019/1/15.
 */
public class CommonAPIAdapter extends PublicRetrofitAPIImpl<CommonAPIRetrofit> implements CommonAPI {

    public CommonAPIAdapter(String baseUrl, Optional<ProxySettings> proxySettingsO, boolean useProxy) {
        this.baseUrl = baseUrl;
        this.proxySettingsO = proxySettingsO;
        this.useProxy = useProxy;
    }

    @Override
    public ServiceStatusResponse getServerStatus() throws IOException {
        return this.executeSync(getAPIImpl().getServerStatus());
    }
}

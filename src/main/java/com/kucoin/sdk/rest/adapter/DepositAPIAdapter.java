/**
 * Copyright 2019 Mek Global Limited.
 */
package com.kucoin.sdk.rest.adapter;

import com.kucoin.sdk.ProxySettings;
import com.kucoin.sdk.rest.impl.retrofit.AuthRetrofitAPIImpl;
import com.kucoin.sdk.rest.interfaces.DepositAPI;
import com.kucoin.sdk.rest.interfaces.retrofit.DepositAPIRetrofit;
import com.kucoin.sdk.rest.request.DepositAddressCreateRequest;
import com.kucoin.sdk.rest.response.DepositAddressResponse;
import com.kucoin.sdk.rest.response.DepositResponse;
import com.kucoin.sdk.rest.response.Pagination;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by chenshiwei on 2019/1/15.
 */
public class DepositAPIAdapter extends AuthRetrofitAPIImpl<DepositAPIRetrofit> implements DepositAPI {

    public DepositAPIAdapter(
            String baseUrl,
            String apiKey,
            String secret,
            Optional<ProxySettings> proxySettingsO,
            boolean useProxy,
            String passPhrase,
            Integer apiKeyVersion)
    {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.secret = secret;
        this.proxySettingsO = proxySettingsO;
        this.useProxy = useProxy;
        this.passPhrase = passPhrase;
        this.apiKeyVersion = apiKeyVersion;
    }

    @Override
    public DepositAddressResponse createDepositAddress(String currency, String chain) throws IOException {
        DepositAddressCreateRequest request = new DepositAddressCreateRequest();
        request.setCurrency(currency);
        request.setChain(chain);
        return super.executeSync(getAPIImpl().createDepositAddress(request));
    }

    @Override
    public DepositAddressResponse getDepositAddress(String currency, String chain) throws IOException {
        return super.executeSync(getAPIImpl().getDepositAddress(currency, chain));
    }

    @Override
    public Pagination<DepositResponse> getDepositPageList(String currency, long startAt, long endAt, String status,
                                                          int currentPage, int pageSize) throws IOException {
        return super.executeSync(getAPIImpl().getDepositPageList(currentPage, pageSize, currency, status, startAt, endAt));
    }

    @Override
    public List<DepositAddressResponse> getDepositAddresses(String currency) throws IOException {
        return super.executeSync(getAPIImpl().getDepositAddresses(currency));
    }

    @Override
    public Pagination<DepositResponse> getHistDepositPageList(String currency, String status, long startAt, long endAt, int currentPage, int pageSize) throws IOException {
        return super.executeSync(getAPIImpl().getHistDepositPageList(currentPage, pageSize, currency, status, startAt, endAt));
    }
}

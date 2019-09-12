package com.ryoma.coolwanandroid.model.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * @author eco-ryoma
 * @date 2019/7/29
 * @description 定义一个信任所有证书的TrustManager
 * <p>
 * Copyright (c) 2019, eco-ryoma.
 * All rights reserved.
 */
public class TrustAllCert implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new java.security.cert.X509Certificate[]{};
    }
}


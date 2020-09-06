package com.sunchen.restapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

/**
 * Description: httpClient工具类
 *
 * @author JourWon
 * @date Created on 2018年4月19日
 */
@Component
public class HttpClientUtils {

    /**
     * 编码格式。发送编码格式统一用UTF-8
     */
    private static final String ENCODING = "UTF-8";

    /**
     * 设置连接超时时间，单位毫秒。
     */
    private static final int CONNECT_TIMEOUT = 6000;

    /**
     * 请求获取数据的超时时间(即响应时间)，单位毫秒。
     */
    private static final int SOCKET_TIMEOUT = 6000;

    /**
     * 发送get请求；不带请求头和请求参数
     *
     * @param url 请求地址
     * @return 响应结果
     */
    public static HttpClientResult doGet(String url) {
        return doGet(url, null, null);
    }

    /**
     * 发送get请求；带请求参数
     *
     * @param url    请求地址
     * @param params 请求参数集合
     * @return 响应结果
     */
    public static HttpClientResult doGet(String url, Map<String, Object> params) {
        return doGet(url, null, params);
    }

    /**
     * 发送get请求；带请求头和请求参数
     *
     * @param url     请求地址
     * @param headers 请求头集合
     * @param params  请求参数集合
     * @return 响应结果
     */
    public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, Object> params) {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // 创建访问的地址
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null) {
                Set<Entry<String, Object>> entrySet = params.entrySet();
                for (Entry<String, Object> entry : entrySet) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
                }
            }

            // 创建http对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            /*
              setConnectTimeout：设置连接超时时间，单位毫秒。
              setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
              超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
              setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
             */
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            httpGet.setConfig(requestConfig);

            // 设置请求头
            packageHeader(headers, httpGet);
            try {
                // 执行请求并获得响应结果
                return getHttpClientResult(httpClient, httpGet);
            } finally {
                // 释放资源
                release(httpClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpClientResult();
    }

    /**
     * 发送post请求；不带请求头和请求参数
     *
     * @param url 请求地址
     * @return 响应结果
     */
    public static HttpClientResult doPost(String url) {
        return doPost(url, null, null);
    }

    /**
     * 发送post请求；带请求参数
     *
     * @param url    请求地址
     * @param params 参数集合
     * @return 响应结果
     */
    public static HttpClientResult doPost(String url, Map<String, String> params) {
        return doPost(url, null, params);
    }

    public static HttpClientResult jsonPost(String url, String jsonObject) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPut method = new HttpPut(url);
            method.setHeader("Content-type", "application/json; charset=utf-8");
            method.setHeader("Accept", "application/json");

//            RequestEntity requestEntity = new StringRequestEntity(jsonObject, contentType, "utf-8");
//            method.setRequestEntity(requestEntity);
            try {
                // 执行请求并获得响应结果
                return getHttpClientResult(httpClient, method);
            } finally {
                // 释放资源
                release(httpClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpClientResult();
    }

    public static HttpClientResult jsonPut(String url, String jsonObject) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPut method = new HttpPut(url);
            method.setHeader("Content-type", "application/json; charset=utf-8");
            method.setHeader("Accept", "application/json");

//            RequestEntity requestEntity = new StringRequestEntity(jsonObject, contentType, "utf-8");
//            method.setRequestEntity(requestEntity);
            try {
                // 执行请求并获得响应结果
                return getHttpClientResult(httpClient, method);
            } finally {
                // 释放资源
                release(httpClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpClientResult();
    }

    /**
     * 发送post请求；带请求头和请求参数
     *
     * @param url     请求地址
     * @param headers 请求头集合
     * @param params  请求参数集合
     * @return 响应结果
     */
    public static HttpClientResult doPost(String url, Map<String, String> headers, Map<String, String> params) {
        // 创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // 创建http对象
            HttpPost httpPost = new HttpPost(url);
            /*
            setConnectTimeout：设置连接超时时间，单位毫秒。
            setConnectionRequestTimeout：设置从connect Manager(连接池)获取Connection
            超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
            setSocketTimeout：请求获取数据的超时时间(即响应时间)，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
            */
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            httpPost.setConfig(requestConfig);
            /*
            httpPost.setHeader("Cookie", "");
            httpPost.setHeader("Connection", "keep-alive");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
            httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            */
            packageHeader(headers, httpPost);

            // 封装请求参数
            packageParam(params, httpPost);

            try {
                // 执行请求并获得响应结果
                return getHttpClientResult(httpClient, httpPost);
            } finally {
                // 释放资源
                release(httpClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpClientResult();

    }

    /**
     * 发送put请求；不带请求参数
     *
     * @param url 请求地址
     * @return 响应结果
     */
    public static HttpClientResult doPut(String url) {
        return doPut(url, null);
    }

    /**
     * 发送put请求；带请求参数
     *
     * @param url    请求地址
     * @param params 参数集合
     * @return 响应结果
     */
    public static HttpClientResult doPut(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPut httpPut = new HttpPut(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            httpPut.setConfig(requestConfig);

            packageParam(params, httpPut);

            try {
                return getHttpClientResult(httpClient, httpPut);
            } finally {
                release(httpClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpClientResult();
    }

    /**
     * 发送delete请求；不带请求参数
     *
     * @param url 请求地址
     * @return 响应结果
     */
    public static HttpClientResult doDelete(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpDelete httpDelete = new HttpDelete(url);
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
            httpDelete.setConfig(requestConfig);
            try {
                return getHttpClientResult(httpClient, httpDelete);
            } finally {
                release(httpClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpClientResult();
    }

    /**
     * 发送delete请求；带请求参数
     *
     * @param url    请求地址
     * @param params 参数集合
     * @return 响应结果
     */
    public static HttpClientResult doDelete(String url, Map<String, String> params) {
        if (params == null) {
            params = new HashMap<>(1);
        }

        params.put("_method", "delete");
        return doPost(url, params);
    }

    /**
     * Description: 封装请求头
     *
     * @param params     请求参数
     * @param httpMethod 方法
     */
    public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Description: 封装请求参数
     *
     * @param params     请求参数
     * @param httpMethod 方法
     */
    public static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod)
            throws UnsupportedEncodingException {
        // 封装请求参数
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<>();
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            // 设置到请求的http对象中
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }

    /**
     * Description: 获得响应结果
     *
     * @param httpClient http链接
     * @param httpMethod 方法
     * @return 响应结果 结果
     */
    public static HttpClientResult getHttpClientResult(CloseableHttpClient httpClient, HttpRequestBase httpMethod) {
        try {
            // 执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(httpMethod);

            // 获取返回结果
            if (httpResponse != null && httpResponse.getStatusLine() != null) {
                String content = "";
                if (httpResponse.getEntity() != null) {
                    content = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
                }
                return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(), content);
            }
            return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpClientResult();
    }

    /**
     * Description: 释放资源
     *
     * @param httpClient http链接
     * @throws IOException I/O异常
     */
    public static void release(CloseableHttpClient httpClient) throws IOException {
        if (httpClient != null) {
            httpClient.close();
        }
    }

}


package com.example.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class HttpClientUtil {

    static CloseableHttpClient httpClient = HttpClients.createDefault();
    static final String BAIDU_URL = "http://www.baidu.com";
    static final String LOCALHOST_URL = "http://localhost:8808";

    public static void main(String[] args) {
        get(LOCALHOST_URL);
    }

    public static String get(String url) {
        HttpGet get = new HttpGet(url);
        String message = "";
        try {
            HttpResponse response = httpClient.execute(get);
            if (200 == response.getStatusLine().getStatusCode()) {
                HttpEntity httpEntity = response.getEntity();
                message = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(message);
            } else {
                System.out.println("error" + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public static String post(String url, List<NameValuePair> nvps) {
        HttpPost post = new HttpPost(url);
        String message = "";
        CloseableHttpResponse response = null;
        try {
            UrlEncodedFormEntity uef = new UrlEncodedFormEntity(nvps, "utf-8");
            post.setEntity(uef);
            response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            message = EntityUtils.toString(entity, "utf-8");
            Header[] headers = response.getAllHeaders();
            if (message != null) {
                System.out.println("headers" + headers);
                System.out.println(message);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return message;
    }
}

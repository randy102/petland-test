package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Request {
    final static String URL = "https://petland-cnpm.herokuapp.com/api";
    final static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiIxZTg3NjE1Yy1jZmFlLTQyMDYtYmI4Yi1hZjZjYjNjMjFlMjQiLCJjcmVhdGVkQXQiOjE2MTY4NTMxMTk0MTEsInVwZGF0ZWRBdCI6MTYxNzE5ODIxODkxNywidXBkYXRlZEJ5IjoiMWU4NzYxNWMtY2ZhZS00MjA2LWJiOGItYWY2Y2IzYzIxZTI0IiwiaXNBY3RpdmUiOnRydWUsImVtYWlsIjoid2VsbGRleTEwMkBnbWFpbC5jb20iLCJwYXNzd29yZCI6ImUxMGFkYzM5NDliYTU5YWJiZTU2ZTA1N2YyMGY4ODNlIiwibmFtZSI6IndlbGxleSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTYxODc0MDYxMX0._qrjjn_YpTzYSnN6zemQOy9WNXBqU7kN8fUOe06Px6g";

    public static JsonObject post(String api, JsonObject params) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost method = new HttpPost(URL + api);
        method.setEntity(new StringEntity(params.toString()));
        method.setHeader("Content-type", "application/json");
        method.setHeader("Authorization", "Bearer " + TOKEN);
        HttpResponse response = httpclient.execute(method);
        InputStream inputStream = response.getEntity().getContent();
        return JsonParser.parseReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).getAsJsonObject();
    }

    public static JsonObject put(String api, JsonObject params) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPut method = new HttpPut(URL + api);
        method.setEntity(new StringEntity(params.toString()));
        method.setHeader("Content-type", "application/json");
        method.setHeader("Authorization", "Bearer " + TOKEN);
        HttpResponse response = httpclient.execute(method);
        InputStream inputStream = response.getEntity().getContent();
        return JsonParser.parseReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).getAsJsonObject();
    }

    static class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "DELETE";

        public String getMethod() {
            return METHOD_NAME;
        }

        public HttpDeleteWithBody(final String uri) {
            super();
            setURI(URI.create(uri));
        }
    }


    public static void delete(String api, JsonObject params) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(URL+api);
        httpDelete.setEntity(new StringEntity(params.toString()));
        httpDelete.setHeader("Content-type", "application/json");
        httpDelete.addHeader("Authorization", "Bearer " + TOKEN);
        HttpResponse response = httpclient.execute(httpDelete);
        InputStream inputStream = response.getEntity().getContent();
        System.out.println(inputStream.toString());
    }


}

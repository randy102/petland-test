package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import dto.CategoryDTO;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CategoryApi {
    final static String API = "/category";
    public static JsonObject create(CategoryDTO dto) throws IOException {
        JsonObject params = new JsonObject();
        params.addProperty("name", dto.name);
        return Request.post(API, params);
    }

    public static JsonObject delete(CategoryDTO dto) throws IOException{
        JsonObject params = new JsonObject();
        JsonArray ids = new JsonArray();
        ids.add(dto.id);
        params.add("ids", ids);
        return Request.delete(API, params);
    }
}

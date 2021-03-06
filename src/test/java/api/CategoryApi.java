package api;

import com.google.gson.JsonArray;
import dto.CategoryDTO;
import com.google.gson.JsonObject;
import java.io.IOException;


public class CategoryApi {
    final static String API = "/category";
    public static JsonObject create(CategoryDTO dto) throws IOException {
        JsonObject params = new JsonObject();
        params.addProperty("name", dto.name);
        return Request.post(API, params);
    }

    public static void delete(CategoryDTO dto) throws IOException{
        JsonObject params = new JsonObject();
        JsonArray ids = new JsonArray();
        ids.add(dto.id);
        params.add("ids", ids);
        Request.delete(API, params);
    }
}

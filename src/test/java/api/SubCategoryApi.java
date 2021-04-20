package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dto.CategoryDTO;
import dto.SubCategoryDTO;

import java.io.IOException;

public class SubCategoryApi {
    final static String API = "/sub-category";

    public static JsonObject create(SubCategoryDTO dto) throws IOException {
        JsonObject params = new JsonObject();
        params.addProperty("categoryID", dto.category.id);
        params.addProperty("name", dto.name);
        return Request.post(API, params);
    }

    public static void delete(SubCategoryDTO dto) throws IOException{
        JsonObject params = new JsonObject();
        JsonArray ids = new JsonArray();
        ids.add(dto.id);
        params.add("ids", ids);
        Request.delete(API, params);
    }
}

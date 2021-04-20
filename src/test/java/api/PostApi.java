package api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dto.PostDTO;
import dto.SubCategoryDTO;

import java.io.IOException;

public class PostApi {
    final static String API = "/post";

    public static JsonObject create(PostDTO dto) throws IOException {
        JsonObject params = new JsonObject();
        params.addProperty("categoryID", dto.category.id);
        params.addProperty("subCategoryID", dto.subCategory.id);
        params.addProperty("cityID", dto.city);
        params.addProperty("districtID", dto.district);
        params.addProperty("name", dto.name);
        params.addProperty("detail", dto.detail);
        params.addProperty("sex", dto.sex);
        params.addProperty("vaccination", dto.vaccination);
        params.addProperty("age", dto.age);
        params.addProperty("price", dto.price);
        params.addProperty("origin", dto.origin);
        params.addProperty("mainImage", dto.mainImage);
        JsonArray images = new JsonArray();
        images.add(dto.images);
        params.add("images", images);
        return Request.post(API, params);
    }

    public static JsonObject confirm(PostDTO dto) throws IOException {
        return Request.put(API + "/confirm/" + dto.id, new JsonObject());
    }

    public static void delete(PostDTO dto) throws IOException {
        JsonObject params = new JsonObject();
        Request.delete(API + "/" + dto.id, params);
    }
}

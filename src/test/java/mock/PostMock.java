package mock;

import dto.CategoryDTO;
import dto.PostDTO;
import dto.SubCategoryDTO;

import static utils.StringUtils.rand;

public class PostMock {
    public static PostDTO basic(CategoryDTO category, SubCategoryDTO subCategory){
        PostDTO post = new PostDTO();
        post.name = rand();
        post.age = 18;
        post.category = category;
        post.subCategory = subCategory;
        post.city = "90";
        post.district = "630";
        post.detail = rand();
        post.sex = "MALE";
        post.price = 294000;
        post.vaccination = false;
        post.origin = rand();
        post.mainImage = "default";
        post.images = "default";
        return post;
    }
}

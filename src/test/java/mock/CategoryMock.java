package mock;

import dto.CategoryDTO;

import static utils.StringUtils.rand;

public class CategoryMock {
    public static CategoryDTO basic(){
        CategoryDTO category = new CategoryDTO();
        category.name = rand();
        return category;
    }
}

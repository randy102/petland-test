package mock;

import dto.CategoryDTO;
import dto.SubCategoryDTO;

import static utils.StringUtils.rand;

public class SubCategoryMock {
    public static SubCategoryDTO basic(CategoryDTO category){
        SubCategoryDTO subCategory = new SubCategoryDTO();
        subCategory.name = rand();
        subCategory.category = category;
        return subCategory;
    }
}

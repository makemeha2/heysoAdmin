package com.noname.heysoAdmin.repository;

import com.noname.heysoAdmin.dto.LiveShoppingItemDto;
import com.noname.heysoAdmin.entity.LiveShoppingItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LiveShoppingMapper {
    List<LiveShoppingItem> getList(
            @Param("pageIndex") Integer pageIndex,
            @Param("pageSize") Integer pageSize,
            @Param("searchText") String searchText);

    LiveShoppingItem getOne(@Param("idx") int idx);

    int insertItem(LiveShoppingItemDto parameter);
}

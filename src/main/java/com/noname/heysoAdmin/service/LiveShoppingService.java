package com.noname.heysoAdmin.service;

import com.noname.heysoAdmin.dto.LiveShoppingItemDto;
import com.noname.heysoAdmin.repository.LiveShoppingMapper;
import com.noname.heysoAdmin.entity.LiveShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveShoppingService {
    private final LiveShoppingMapper repository;

    @Autowired
    public LiveShoppingService(LiveShoppingMapper repository)
    {
        this.repository = repository;
    }

    public List<LiveShoppingItem> getList(Integer pageIndex, Integer pageSize, String searchText)
    {
        return repository.getList(pageIndex, pageSize, searchText);
    }

    public LiveShoppingItem getItem(int idx)
    {
        return repository.getOne(idx);
    }

    public LiveShoppingItem insertItem(LiveShoppingItemDto parameter)
    {
        repository.insertItem(parameter);
        return repository.getOne(parameter.getIdx());
    }
}

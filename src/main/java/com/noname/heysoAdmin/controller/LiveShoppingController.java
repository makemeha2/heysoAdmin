package com.noname.heysoAdmin.controller;


import com.noname.heysoAdmin.repository.entity.LiveShoppingItem;
import com.noname.heysoAdmin.service.LiveShoppingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class LiveShoppingController {
    @Autowired
    private final LiveShoppingService service;

    public LiveShoppingController(LiveShoppingService service) {
        this.service = service;
    }

    @GetMapping("/live")
    public String index(Model model,
                        @RequestParam(value = "pageIndex", required = false, defaultValue = "1")
                        String pageIndex,
                        @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                        String pageSize,
                        @RequestParam(value = "searchText", required = false, defaultValue = "")
                        String searchText)
    {
        Integer index = Integer.parseInt(pageIndex);
        Integer size = Integer.parseInt(pageSize);

        List<LiveShoppingItem> list = service.getList(index, size, searchText);

        //list.stream().forEach(item -> { log.info(item.getTitle()); });

        model.addAttribute("dataList", list);

        return "live";
    }
}
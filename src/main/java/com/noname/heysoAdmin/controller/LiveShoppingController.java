package com.noname.heysoAdmin.controller;


import com.noname.heysoAdmin.dto.LiveShoppingItemDto;
import com.noname.heysoAdmin.entity.LiveShoppingItem;
import com.noname.heysoAdmin.service.LiveShoppingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

        return "live/list";
    }

    @GetMapping("/live/{idx}")
    public String detail(@PathVariable int idx, Model model)
    {
        LiveShoppingItem item = service.getItem(idx);

        model.addAttribute("item", item);

        return "live/edit";
    }


    @GetMapping("/live/create")
    public String create(Model model)
    {
        LiveShoppingItemDto item = new LiveShoppingItemDto();

        model.addAttribute("item", item);

        return "live/edit";
    }

    @PostMapping("/live/create")
    public String create(LiveShoppingItemDto item)
    {
        item.setCurUserId("정소영");
        LiveShoppingItem newItem = service.insertItem(item);

        return "redirect:/live";
    }
}
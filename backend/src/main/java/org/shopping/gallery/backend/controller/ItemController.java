package org.shopping.gallery.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.shopping.gallery.backend.entity.Item;
import org.shopping.gallery.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class ItemController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/api/items")
    public List<Item> getItems() {
        logger.info("Fetching items");
        logger.info("items 확인");
        List<Item> items = itemRepository.findAll();


        return items;
    }


}

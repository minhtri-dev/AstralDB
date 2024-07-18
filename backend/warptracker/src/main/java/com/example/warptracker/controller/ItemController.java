package com.example.warptracker.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.example.warptracker.model.warptrackerdb.Item;
import com.example.warptracker.repository.ItemRepository;


@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @PostMapping()
    public List<Item> all(@RequestBody JsonNode jsonNode) {
        if (!jsonNode.has("ids") || !jsonNode.get("ids").isArray()) {
            throw new IllegalArgumentException("Invalid JSON: 'ids' field is required and must be an array.");
        }
        ArrayNode idsNode = (ArrayNode) jsonNode.get("ids");
        List<Long> ids = StreamSupport.stream(idsNode.spliterator(), false)
                                      .map(JsonNode::asLong)
                                      .collect(Collectors.toList());

        // Print individual IDs for debugging
        // System.out.println("Received IDs:");
        // ids.forEach(id -> System.out.println("ID: " + id));
        
        List<Item> items = itemRepository.findAllById(ids);
        
        return items;
    }
}

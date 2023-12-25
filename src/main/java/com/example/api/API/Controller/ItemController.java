package com.example.api.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.API.Entity.Item;
import com.example.api.API.Exception.ItemNotFoundException;
import com.example.api.API.Repository.ItemRepository;

import jakarta.validation.Valid;

@RestController
public class ItemController {

  @Autowired
  ItemRepository itemRepository;

  @GetMapping("/items")
  List<Item> all() {
    return itemRepository.findAll();
  }

  @GetMapping("/items/{id}")
  Item getById(@PathVariable Long id) {

    return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
  }

  @PostMapping("/items")
  Item createNew(@Valid @RequestBody Item newItem) {
    return itemRepository.save(newItem);
  }

  @DeleteMapping("/items/{id}")
  void delete(@PathVariable Long id) {
    itemRepository.deleteById(id);
  }

  @PutMapping("/items/{id}")
  Item updateOrCreate(@RequestBody Item newItem, @PathVariable Long id) {

    return itemRepository.findById(id)
        .map(item -> {
          item.setName(newItem.getName());
          item.setPrice(newItem.getPrice());
          return itemRepository.save(item);
        })
        .orElseGet(() -> {
          newItem.setId(id);
          return itemRepository.save(newItem);
        });
  }
}
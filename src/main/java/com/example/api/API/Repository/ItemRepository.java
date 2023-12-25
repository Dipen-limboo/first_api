package com.example.api.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.API.Entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

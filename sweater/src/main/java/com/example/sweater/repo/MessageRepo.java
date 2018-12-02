package com.example.sweater.repo;

import com.example.sweater.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Базовый репозиторий для хранения сообщений.
 * Позволяет получить полный список полей или найти их по идентификатору(Message id).
 */
public interface MessageRepo extends CrudRepository<Message, Integer> {

    List<Message> findByTag(String tag);

}

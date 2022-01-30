package com.agata.learning.SpringGuru.repositories;

import com.agata.learning.SpringGuru.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

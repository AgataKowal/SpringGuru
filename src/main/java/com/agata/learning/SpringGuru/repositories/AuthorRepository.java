package com.agata.learning.SpringGuru.repositories;

import com.agata.learning.SpringGuru.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

package com.m44rk0.spring5webapp.repositories;

import com.m44rk0.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

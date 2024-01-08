package com.m44rk0.spring5webapp.repositories;

import com.m44rk0.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

package com.manning.readinglist.repository;

import com.manning.readinglist.po.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ReaderRepository extends JpaRepository<Reader, String> {

}

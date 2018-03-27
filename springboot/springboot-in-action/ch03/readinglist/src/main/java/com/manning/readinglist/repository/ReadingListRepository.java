package com.manning.readinglist.repository;

import java.util.List;

import com.manning.readinglist.po.Book;
import com.manning.readinglist.po.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByReader(Reader reader);

}

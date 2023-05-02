package com.example.ecrf.repository;

import com.example.ecrf.model.Chat;
import com.example.ecrf.model.eCRF1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatRepository extends JpaRepository<Chat,Long> {
//    Chat findByText(String search);
//    @Query("SELECT e FROM Chat e WHERE (LOWER(e.ecrfStatus) IS NULL OR LOWER(e.ecrfStatus) = 'draft') AND e.patId LIKE %:patIdStartsWith%")
    Chat  findByTextStartsWith( String patIdStartsWith);

}

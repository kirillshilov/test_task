package com.example.test_task.Repositories;

import com.example.test_task.models.Sock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SockRepository extends JpaRepository <Sock, Long>{

    public List <Sock> findAllByColorIgnoreCaseAndCottonPartContaining (String color, Integer cottonPart);
    public List <Sock> findAllByColorIgnoreCaseAndCottonPartAfter (String color, Integer cottonPart);
    public List <Sock> findAllByColorIgnoreCaseAndCottonPartBefore (String color, Integer cottonPart);
}

package com.example.test_task.Repositories;

import com.example.test_task.models.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SockRepository extends JpaRepository <Sock, Long>{
    @Query (value = "SELECT COUNT(*) FROM Sock where having color,nativeQuery = true)
    public Integer sockByColorAndCoton (String color, Integer cottonPart);
}

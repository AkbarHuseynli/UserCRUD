package com.example.appuser;

import com.example.repository.AppUserRepository;
import com.example.service.AppUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void showTasksToDo() {
    }
}
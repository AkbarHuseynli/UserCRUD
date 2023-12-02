package com.example.appuser;

import com.example.model.entity.AppUser;
import com.example.model.entity.AppUserRole;
import com.example.repository.AppUserRepository;
import com.example.repository.TaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private TaskRepository taskRepository;

    @AfterEach
    void tearDown() {
        appUserRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @Test
    void findByEmail() {

        String email = "ehberhuseynli@gmail.com";
        AppUser appUser = AppUser.builder()
                .firstName("Akbar")
                .email("ehberhuseynli@gmail.com")
                .appUserRole(AppUserRole.USER)
                .password("21321").build();
        appUserRepository.save(appUser);
        Boolean exists = appUserRepository.findByEmail(email).isPresent();
        assertThat(exists).isTrue();

    }
}
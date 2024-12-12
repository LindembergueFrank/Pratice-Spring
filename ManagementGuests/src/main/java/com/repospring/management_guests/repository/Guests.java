package com.repospring.management_guests.repository;

import com.repospring.management_guests.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Guests extends JpaRepository<Guest, Long> {

}

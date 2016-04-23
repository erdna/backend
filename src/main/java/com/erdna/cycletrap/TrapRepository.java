package com.erdna.cycletrap;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by André Nitzschke on 23/04/16.
 */
public interface TrapRepository extends CrudRepository<Trap, Long> {
    List<Trap> findByName(String name);
}
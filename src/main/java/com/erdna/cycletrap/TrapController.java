package com.erdna.cycletrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by André Nitzschke on 23/04/16.
 */
@RestController
@RequestMapping("/traps")
public class TrapController {

    @Autowired
    private TrapRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Trap> getAll() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Trap create(@RequestBody Trap trap) {
        return repo.save(trap);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable long id) {
        repo.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Trap update(@PathVariable long id, @RequestBody Trap trap) {
        Trap update = repo.findOne(id);
        update.setName(trap.getName());
        return repo.save(update);
    }


}

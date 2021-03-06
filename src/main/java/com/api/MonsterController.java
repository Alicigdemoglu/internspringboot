package com.api;

import com.dto.Monster;
import com.repository.MonsterRepository;
import com.service.MonsterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MonsterController {

    private final MonsterRepository monsterRepository;

    private MonsterService monsterService;

    public MonsterController(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
        this.monsterService = new MonsterService(monsterRepository);
    }

    @PostMapping( "/create")
    public ResponseEntity<String> createMonster(@Valid @RequestBody Monster monster) {
        Monster newMonster = monsterService.create(new Monster(monster));
        return ResponseEntity.ok("Monster ID: " + newMonster.getId());
    }

    @GetMapping("/getmonster")
    public Monster getMonster(@RequestParam String id) {
        return monsterService.getById(id);
    }

    @GetMapping("/getallmonsters")
    public List<Monster> getMonsters() {
        return monsterService.getAll();
    }

    @PutMapping( "/levelup")
    public Monster levelUp(@RequestParam String id) {
        return monsterService.levelUp(id);
    }

    @PutMapping( "/changetype")
    public Monster changeType(@RequestParam String id, @RequestParam String type) {
        return monsterService.changeType(id, type);
    }

    @DeleteMapping( "/release")
    public boolean release(@RequestParam String id) {
        return monsterService.release(id);
    }
}
package com.api;

import java.net.URI;
import java.util.concurrent.atomic.AtomicLong;

import com.dto.Monster;
import com.service.MonsterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MonsterController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();



    @PostMapping(value = "/create")
    public ResponseEntity<Monster> createMonster(HttpServletRequest request,
                                              UriComponentsBuilder uriComponentsBuilder) {

        String type = request.getParameter("type");
        String name = request.getParameter("name");

        Monster monster = new Monster(name, type);

        monster = MonsterService.create(monster);

        UriComponents uriComponents =
                uriComponentsBuilder.path("/monsters/{id}").buildAndExpand(monster.getId());
        URI location = uriComponents.toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/getmonster")
    public Monster getMonster(@RequestParam(value = "id") String id) {
        return MonsterService.getById(id);
    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
//    public String sayHello() {
//        return "Swagger Hello World";
//    }
}
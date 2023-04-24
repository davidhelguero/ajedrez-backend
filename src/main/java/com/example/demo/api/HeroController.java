package com.example.demo.api;

import com.example.demo.api.dto.HeroRequestDTO;
import com.example.demo.api.dto.HeroResponseDTO;
import com.example.demo.serviceDTO.interfaces.HeroServiceDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("heroes")
public class HeroController implements HeroControllerSwagger {
    private final HeroServiceDTO heroServiceDTO;

    @Autowired
    public HeroController(HeroServiceDTO heroServiceDTO) {
        this.heroServiceDTO = heroServiceDTO;
    }

    @GetMapping("/all")
    public Set<HeroRequestDTO> getHeroes() {
        return heroServiceDTO.getHeroes();
    }

    @SneakyThrows
    @PostMapping()
    public ResponseEntity<HeroRequestDTO> addHero(@RequestBody @Valid HeroRequestDTO hero) {
        return new ResponseEntity<>(heroServiceDTO.add(hero), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable("id") Long id) {
        //heroServiceBO.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroRequestDTO> updateHero(@PathVariable("id") Long id, @RequestBody @Valid HeroRequestDTO hero) {
        //return new ResponseEntity<>(heroServiceBO.update(id, hero), HttpStatus.OK);
        return null;
    }

    @GetMapping("/{name}")
    public List<HeroResponseDTO> getHeroesByName(@PathVariable("name") String name) {
        //return heroServiceBO.getHeroByName(name);
        return null;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HeroRequestDTO> patchHero(@PathVariable("id") Long id, @RequestBody @Valid HeroRequestDTO hero) {
        //return new ResponseEntity<>(heroServiceBO.update(id, hero), HttpStatus.OK);
        return null;
    }

    @GetMapping()
    public Set<HeroResponseDTO> getAll(@RequestParam(required = false) String universe, @RequestParam(required = false) String gender) {
        //ByFilter
        return heroServiceDTO.getHeroesByUniverse(universe, gender);
    }

}

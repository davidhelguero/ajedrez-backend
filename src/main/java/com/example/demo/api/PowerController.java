package com.example.demo.api;

import com.example.demo.api.dto.PowerResponseDTO;
import com.example.demo.serviceDTO.interfaces.PowerServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/powers")
@CrossOrigin(origins = "*")
public class PowerController {
    private final PowerServiceDTO powerServiceDTO;

    @Autowired
    public PowerController(PowerServiceDTO powerServiceDTO) {
        this.powerServiceDTO = powerServiceDTO;
    }

    @PostMapping
    ResponseEntity<PowerResponseDTO> addPower(@RequestBody PowerResponseDTO power){
        return new ResponseEntity<>(powerServiceDTO.addPower(power), HttpStatus.OK);
    }
    @GetMapping("/char")
    boolean isOK(){
        LocalDate today = LocalDate.now();
        LocalDate pastDate = LocalDate.parse("2022-12-02");

        boolean isBefore = today.isBefore(pastDate);	//false

        boolean isAfter = today.isAfter(pastDate);		//true

        boolean isEqual = today.
                isEqual(LocalDate.of(2022, 1, 9));	//false
        String aux = "1";
        return !aux.isBlank() && !aux.equals("0");
    }

    @GetMapping
    List<PowerResponseDTO> getPowers(){
        return powerServiceDTO.getPowers();
    }

    @PutMapping("/{name}")
    ResponseEntity<PowerResponseDTO> updatePower(@PathVariable("name") String name, @RequestBody PowerResponseDTO power){
        return new ResponseEntity<>(powerServiceDTO.updatePower(name, power), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    void deletePower(@PathVariable("name") String name){
        powerServiceDTO.deletePower(name);
    }

}

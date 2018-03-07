package iba.controller;

import iba.entity.Buoy;
import iba.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import iba.repository.BuoyRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/buoy")
public class BuoyRestController {

    @Autowired
    private BuoyRepository buoyRepository;

    @RequestMapping(value = "/buoys/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Buoy> getBuoy(@PathVariable("id") Long id) {
        Optional<Buoy> b = buoyRepository.findById(id);
        return b;
    }

    @RequestMapping(value = "/buoys", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Buoy> getBuoys () {
        return buoyRepository.findAll();
    }

    @PostMapping("/buoys")
    public Buoy createBuoy (@Valid @RequestBody Buoy buoy) {
        return buoyRepository.save(buoy);
    }

    @PutMapping("/buoys/{id}")
    public Buoy updateBuoy(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody Buoy buoyDetails) {

        Buoy buoy = buoyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buoy", "id", id));

        buoy.setLatitude(buoyDetails.getLatitude());
        buoy.setLongitude(buoyDetails.getLongitude());
        buoy.setOwner(buoyDetails.getOwner());

        Buoy updatedBuoy = buoyRepository.save(buoy);
        return updatedBuoy;
    }

    @DeleteMapping("/buoys/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) {
        Buoy buoy = buoyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buoy", "id", id));

        buoyRepository.delete(buoy);

        return ResponseEntity.ok().build();
    }

}
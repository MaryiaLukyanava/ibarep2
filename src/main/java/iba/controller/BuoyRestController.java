package iba.controller;

import iba.entity.Buoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import iba.repository.BuoyRepository;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping(value = "/buoy")
public class BuoyRestController {

    @Autowired
    private BuoyRepository buoyRepository;

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/{idbuoy}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Buoy> getBuoy(@PathVariable("idbuoy") Long idbuoy) {
        Optional<Buoy> b = buoyRepository.findById(idbuoy);
        return b;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Buoy> getBuoys () {
        return buoyRepository.findAll();
    }
}
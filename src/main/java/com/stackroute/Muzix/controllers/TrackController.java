package com.stackroute.Muzix.controllers;

import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.models.Track;
import com.stackroute.Muzix.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //@Controller @ResponseBody
public class TrackController {
    @Autowired
    TrackService trackService;

    @PostMapping("/track")
    public ResponseEntity<?> addTrack(Track track){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Track>(trackService.addTrack(track), HttpStatus.CREATED);
        }catch (TrackAlreadyExistsException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/tracks")
    public ResponseEntity<?> getAllTracks(){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity< List<Track> >(trackService.getAllTracks(),HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/id/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable int trackId){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Optional<Track>>(trackService.getTrackById(trackId), HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/name/{trackName}")
    public ResponseEntity<?> getTrackByName(@PathVariable String trackName){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Track>(trackService.getTrackByName(trackName),HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/track/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId){
        ResponseEntity responseEntity;
        try{
            trackService.deleteTrack(trackId);
            responseEntity = new ResponseEntity<String>("Deleted",HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/track")
    public ResponseEntity<?> updateComments(Track track){
        ResponseEntity responseEntity;
        try{
            responseEntity = new ResponseEntity<Track>(trackService.updateComments(track),HttpStatus.OK);
        }catch (TrackNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}

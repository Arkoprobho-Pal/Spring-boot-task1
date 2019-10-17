package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class TrackController {

    private TrackService trackService;

    @Autowired
    public TrackController(@Qualifier("trackServiceImpl") TrackService trackService) {
        this.trackService = trackService;
    }
    @GetMapping("track/find/{trackName}")
    public ResponseEntity<?> getTrackByName( @PathVariable String trackName) {
        try {
            return new ResponseEntity<List<Track>>(trackService.getTrackByName(trackName), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track)throws TrackAlreadyExistsException{
        ResponseEntity responseEntity;
//        try {
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully Track Created", HttpStatus.CREATED);
//        }catch (TrackAlreadyExistsException ex){
//            responseEntity=new ResponseEntity<String >(ex.getMessage(),HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }
    @PutMapping("track")
    public  ResponseEntity<?> updateTrackComment(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            trackService.updateTrackComment(track);
            responseEntity=new ResponseEntity<String>("Successfully Track comment Updated", HttpStatus.CREATED);
        }catch (Exception ex){
            responseEntity=new ResponseEntity<String >(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @RequestMapping(value = "track",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTrack(@RequestBody  Track track)throws TrackNotFoundException{
        ResponseEntity responseEntity;
//        try {
            trackService.removeTrack(track);
            responseEntity=new ResponseEntity<String>("Successfully Track Deleted !!", HttpStatus.CREATED);
//        }catch (TrackNotFoundException ex){
//            responseEntity=new ResponseEntity<String >(ex.getMessage(),HttpStatus.CONFLICT);
//        }
        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTrackDetails()throws TrackNotFoundException{
        return new ResponseEntity<List<Track>>((List<Track>) trackService.getAllTrackDetails(),HttpStatus.OK);
    }

}

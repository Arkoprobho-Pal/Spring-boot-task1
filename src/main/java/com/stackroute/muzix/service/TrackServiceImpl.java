package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> getTrackByName(String trackName) {
        List<Track> list=trackRepository.findByName(trackName);
        return list;//printing the tracks of same names
    }

    @Override
    public Track autoSaveCommandLine(Track track) {
        Track track1;
        track1=trackRepository.save(track);
        return track1;
    }

    @Override
    public Track autoSaveListener(Track track) {
        Track track1;
        track1=trackRepository.save(track);
        return track1;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        Track savedTrack=trackRepository.save(track);
        if (savedTrack==null){
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        return savedTrack;
    }



    @Override
    public Track removeTrack(Track track) throws TrackNotFoundException {
        if(!trackRepository.existsById(track.getTrackId())){
            throw new TrackNotFoundException("Track Not Found");
        }
         trackRepository.deleteById(track.getTrackId());
       // trackRepository.delete(track);
        return  track;
    }

    @Override
    public List<Track> getAllTrackDetails() {
        return trackRepository.findAll();
    }
    @Override
    public Track updateTrackComment(Track track) {
        Track updateTrack=trackRepository.getOne(track.getTrackId());
        updateTrack.setComments(track.getComments());
        trackRepository.save(updateTrack);
        return updateTrack;
    }
}

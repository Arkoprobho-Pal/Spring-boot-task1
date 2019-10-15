package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
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
    public Track saveTrack(Track track) {
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }



    @Override
    public Track removeTrack(Track track) {

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

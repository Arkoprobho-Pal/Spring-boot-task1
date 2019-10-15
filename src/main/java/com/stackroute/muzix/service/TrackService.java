package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);
    public Track updateTrackComment(Track track);
    public Track removeTrack(Track track);
    public List<Track> getAllTrackDetails();
}

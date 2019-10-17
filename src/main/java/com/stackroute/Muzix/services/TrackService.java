package com.stackroute.Muzix.services;

import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.models.Track;
import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track addTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks() throws TrackNotFoundException;

    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException;

    public Track getTrackByName(String trackName) throws TrackNotFoundException;

    public String deleteTrack(int trackId) throws TrackNotFoundException;

    public Track updateComments(Track track) throws TrackNotFoundException;

}

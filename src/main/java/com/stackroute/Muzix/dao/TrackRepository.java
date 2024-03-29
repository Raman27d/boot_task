package com.stackroute.Muzix.dao;

import com.stackroute.Muzix.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query("SELECT m FROM Track m WHERE m.trackName = ?1")
    Track findByTrackName(String trackName);
}

package com.stuart.tournament.utilities;

import com.stuart.tournament.dto.TrackDto;
import com.stuart.tournament.entity.Track;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MapperTest {


    private Mapper uut;

    @BeforeEach
    void setUp() {
        uut = new Mapper(new ModelMapper());
    }


    @Test
    void testConvertCollection() {
        Collection<Track> players = Set.of(
                new Track("track1", "appearance1"),
                new Track("track2", "appearance2")
        );

        Set<TrackDto> results = uut.convertCollection(players, TrackDto.class);
        assertThat(results.size(), equalTo(2));


    }

    @Test
    void convertSingle() {
        Track track = new Track("track1", "appearance1");

        TrackDto result = uut.convertSingle(track, TrackDto.class);

        assertThat(track.getTrackName(), equalTo(result.getTrackName()));
        assertThat(track.getFirstAppearance(), equalTo(result.getFirstAppearance()));

    }
}
package com.stuart.tournament;

import com.stuart.tournament.entity.Track;
import com.stuart.tournament.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

@Component
public class DataBoostrap implements CommandLineRunner {

    /*
     * Constants for the different game names.
     */
    private static final String SUPER_MARIO_KART = "Super Mario Kart";
    private static final String MARIO_KART_64 = "Mario Kart 64";
    private static final String MARIO_KART_SUPER_CIRCUIT = "Mario Kart Super Circuit";
    private static final String MARIO_KART_8 = "Mario Kart 8";
    private static final String MARIO_KART_WII = "Mario Kart Wii";
    private static final String MARIO_KART_DS = "Mario Kart DS";
    private static final String MARIO_KART_DOUBLE_DASH = "Mario Kart Double Dash!!";
    private static final String MARIO_KART_7 = "Mario Kart 7";

    /**
     * Enable saving to the track table.s
     */
    private final TrackRepository trackRepo;

    @Autowired
    public DataBoostrap(TrackRepository trackRepository) {
        trackRepo = trackRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        setupTrackData();
    }

    /**
     * This will load all the static track information required for Mario Kart 8 Deluxe.
     */
    private void setupTrackData() {
        Map<String, String> trackInfo = Map.ofEntries(entry("Mario Kart Stadium", MARIO_KART_8),
                entry("Water Park", MARIO_KART_8),
                entry("Sweet Sweet Canyon", MARIO_KART_8),
                entry("Thwomp Ruins", MARIO_KART_8),
                entry("Mario Circuit", MARIO_KART_8),
                entry("Toad Harbour", MARIO_KART_8),
                entry("Twisted Mansion", MARIO_KART_8),
                entry("Shy Guy Falls", MARIO_KART_8),
                entry("Sunshine Airport", MARIO_KART_8),
                entry("Dolphin Shoals", MARIO_KART_8),
                entry("Electrodome", MARIO_KART_8),
                entry("Mount Wario", MARIO_KART_8),
                entry("Cloudtop Cruise", MARIO_KART_8),
                entry("Bone Dry Dunes", MARIO_KART_8),
                entry("Bowser's Castle (MK8)", MARIO_KART_8),
                entry("Rainbow Road (MK8)", MARIO_KART_8),
                entry("Moo Moo Meadows", MARIO_KART_WII),
                entry("Mario Circuit (GBA)", MARIO_KART_SUPER_CIRCUIT),
                entry("Cheep Cheep Beach", MARIO_KART_DS),
                entry("Toad's Turnpike", MARIO_KART_64),
                entry("Dry Dry Desert", MARIO_KART_DOUBLE_DASH),
                entry("Donut Plains 3", SUPER_MARIO_KART),
                entry("Royal Raceway", MARIO_KART_64),
                entry("DK Jungle", MARIO_KART_7),
                entry("Wario Stadium (DS)", MARIO_KART_DS),
                entry("Sherbert Land", MARIO_KART_DOUBLE_DASH),
                entry("Music Park", MARIO_KART_7),
                entry("Yoshi Valley", MARIO_KART_64),
                entry("Tick-Tock Clock", MARIO_KART_DS),
                entry("Piranha Plant Slide", MARIO_KART_7),
                entry("Grumble Volcano", MARIO_KART_WII),
                entry("Rainbow Road (N64)", MARIO_KART_64),
                entry("Yoshi Circuit", MARIO_KART_DOUBLE_DASH),
                entry("Excitebike Arena", MARIO_KART_8),
                entry("Dragon Driftway", MARIO_KART_8),
                entry("Mute City", MARIO_KART_8),
                entry("Wario's Gold Mine", MARIO_KART_WII),
                entry("Rainbow Road (SNES)", SUPER_MARIO_KART),
                entry("Ice Ice Outpost", MARIO_KART_8),
                entry("Hyrule Circuit", MARIO_KART_8),
                entry("Baby Park", MARIO_KART_DOUBLE_DASH),
                entry("Cheese Land", MARIO_KART_SUPER_CIRCUIT),
                entry("Wild Woods", MARIO_KART_8),
                entry("Animal Crossing", MARIO_KART_8),
                entry("Neo Bowser City", MARIO_KART_7),
                entry("Ribbon Road", MARIO_KART_SUPER_CIRCUIT),
                entry("Super Bell Subway", MARIO_KART_8),
                entry("Big Blue", MARIO_KART_8));
        List<Track> tracks = new ArrayList<>();
        for (Map.Entry<String, String> track : trackInfo.entrySet()) {
            tracks.add(new Track(track.getKey(), track.getValue()));
        }
        trackRepo.saveAll(tracks);
    }
}

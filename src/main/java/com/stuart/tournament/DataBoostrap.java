package com.stuart.tournament;

import com.stuart.tournament.entity.Player;
import com.stuart.tournament.entity.Track;
import com.stuart.tournament.repository.PlayerRepository;
import com.stuart.tournament.repository.TrackRepository;
import com.stuart.tournament.security.entity.Role;
import com.stuart.tournament.security.entity.User;
import com.stuart.tournament.security.repository.RoleRepository;
import com.stuart.tournament.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
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
    private final PlayerRepository playerRepo;
    private final UserService userService;
    private final RoleRepository roleRepo;

    @Autowired
    public DataBoostrap(TrackRepository trackRepository,
                        PlayerRepository playerRepository,
                        UserService userService,
                        RoleRepository roleRepository) {
        trackRepo = trackRepository;
        playerRepo = playerRepository;
        roleRepo = roleRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        setupTrackData();
        setupRoleData();
        setupPlayerAndUserData();
    }

    private void setupRoleData() {
        List<Role> roles = roleRepo.findAll();
        if (roles.size() != 2) {
            Role userRole = new Role("BASIC");
            Role adminRole = new Role("ADMIN");
            roleRepo.save(userRole);
            roleRepo.save(adminRole);
        }
    }

    private void setupPlayerAndUserData() {
        Player player1 = new Player("Stuart", "Clark");
        player1.setPreferredName("Stu");
        player1 = playerRepo.save(player1);
        Player player2 = new Player("Faye", "Daway");
        player2.setPreferredName(player2.getFirstName());
        player2 = playerRepo.save(player2);
        Player player3 = new Player("Bob", "Bobbington");
        player3.setPreferredName("Bob");
        player3 = playerRepo.save(player3);

        User user1 = new User("StuAdmin", "admin-default", "Stuart", "Clark");
        user1.setPlayer(player1);
        userService.saveAdmin(user1);
        user1 = userService.findByUsername(user1.getUsername());
        player1.setUser(user1);
        playerRepo.save(player1);

        User user2 = new User("Faye332", "mypassword", "Faye", "Daway");
        user2.setPlayer(player2);
        userService.save(user2);
        user2 = userService.findByUsername(user2.getUsername());
        player2.setUser(user2);
        playerRepo.save(player2);

        User user3 = new User("BananaKing", "mypassword", "Bob", "Bobbington");
        user3.setPlayer(player3);
        userService.save(user3);
        user3 = userService.findByUsername(user3.getUsername());
        player3.setUser(user3);
        playerRepo.save(player3);


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

package com.stuart.tournament.controller;

import com.stuart.tournament.entity.Track;
import com.stuart.tournament.service.TrackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TrackControllerTest {

    @Mock
    private TrackService mockTrackService;

    @Mock
    private Model model;

    @Mock
    private Page<Track> trackPages;

    private TrackController uut;


    @BeforeEach
    void setUp() {
        uut = new TrackController(mockTrackService, new ModelMapper());
    }

    @Test
    void testListTracks_onePageOneElement() {
        when(mockTrackService.findPaginated(any())).thenReturn(trackPages);
        when(trackPages.getTotalElements()).thenReturn(1L);
        when(trackPages.getTotalPages()).thenReturn(1);

        String viewName = uut.listTracks(model);

        assertThat("Verify view name",
                viewName, equalTo("tracks/list-tracks"));
        verify(model, times(4)).addAttribute(anyString(),any());
    }

    @Test
    void findPaginated() {
        when(mockTrackService.findPaginated(any())).thenReturn(trackPages);
        when(trackPages.getTotalElements()).thenReturn(1L);
        when(trackPages.getTotalPages()).thenReturn(5);

        String viewName = uut.findPaginated(model,5);

        assertThat("Verify view name",
                viewName, equalTo("tracks/list-tracks"));
        verify(model, times(4)).addAttribute(anyString(),any());
    }
}
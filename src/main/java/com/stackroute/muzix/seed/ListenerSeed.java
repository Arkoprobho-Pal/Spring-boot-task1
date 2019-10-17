package com.stackroute.muzix.seed;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.TrackService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ListenerSeed implements ApplicationListener<ContextRefreshedEvent> {
    TrackService trackService;

    public ListenerSeed(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        trackService.autoSaveListener(new Track(3,"Booter Bhobiisyot","Kartick Da!! is LOVE"));
    }
}

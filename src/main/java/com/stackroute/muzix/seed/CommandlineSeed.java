package com.stackroute.muzix.seed;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandlineSeed implements CommandLineRunner {
    TrackService trackService;
    @Autowired
    public CommandlineSeed(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void run(String... args) throws Exception {
        trackService.autoSaveCommandLine(new Track(1,"Bhooter Chhana","Khub Valo"));

        trackService.autoSaveCommandLine(new Track(2,"Bhooter Baba","Khub Baje"));

        trackService.autoSaveCommandLine(new Track(4,"Bhooter Ma","Khub Sundor"));
    }
}

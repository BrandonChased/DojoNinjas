package brandon.dojoninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brandon.dojoninjas.models.Ninja;
import brandon.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    
    @Autowired NinjaRepository ninjaRepository;

    public void createNinja(Ninja ninja) {
        ninjaRepository.save(ninja);
    }

}

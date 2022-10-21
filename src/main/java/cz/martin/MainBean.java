package cz.martin;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("main")
@RequestScoped
public class MainBean {
    @Inject
    private Service service;

    public List<String> getDruhy() {
        return service.getAllAnimals();
    }
}

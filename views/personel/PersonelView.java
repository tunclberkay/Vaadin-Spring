package com.example.application.views.personel;

import com.example.application.views.model.Personel;
import com.example.application.views.service.PersonelService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.util.List;

@PageTitle("Personel")
@Route( "personel")
public class PersonelView extends VerticalLayout {

    private final PersonelService personelService; 
    private Grid<Personel> grid = new Grid<>(Personel.class); 
    private ListDataProvider<Personel> dataProvider; 

    public PersonelView(PersonelService personelService) {
        this.personelService = personelService;
        setSizeFull();
        configureGrid();
        add(createSearchBar(), grid); 
    }

    private void configureGrid() {
        List<Personel> personList = personelService.getDummyPersonelList(); 
        dataProvider = new ListDataProvider<>(personList);
        grid.setItems(dataProvider);
        grid.setColumns("ad", "soyad", "TC"); 
    }

    private HorizontalLayout createSearchBar() {
        TextField searchField = new TextField();
        searchField.setPlaceholder("İsim ile ara...");
        searchField.setClearButtonVisible(true);
        searchField.setPrefixComponent(LineAwesomeIcon.SEARCH_SOLID.create());

        searchField.addValueChangeListener(event -> {
            String searchText = event.getValue().trim().toLowerCase();
            dataProvider.setFilter(person -> 
              person.getAd().toLowerCase().contains(searchText.toLowerCase()));

        });

        HorizontalLayout searchBar = new HorizontalLayout(searchField);
        searchBar.setWidthFull();
        searchBar.setJustifyContentMode(JustifyContentMode.CENTER);
        searchBar.setPadding(true);

        return searchBar;
    }
}

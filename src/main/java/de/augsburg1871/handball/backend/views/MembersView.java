package de.augsburg1871.handball.backend.views;

import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import de.augsburg1871.handball.backend.components.PersonComponent;
import de.augsburg1871.handball.backend.model.Person.PersonBuilder;

@SpringView(name = MembersView.VIEW_NAME)
public class MembersView extends VerticalLayout implements View {

	private static final long serialVersionUID = 3742376262460123335L;

	public static final String VIEW_NAME = "members";

	@PostConstruct
	void initLayout() {
		addComponents(topBar(),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))),
				new PersonComponent(PersonBuilder.createWith("Maier", "Peter", LocalDate.of(1988, APRIL, 12))),
				new PersonComponent(PersonBuilder.createWith("Mustermann", "Max", LocalDate.of(2000, DECEMBER, 7))));
	}

	@Override
	public void enter(final ViewChangeEvent event) {

	}

	private HorizontalLayout topBar() {
		final HorizontalLayout root = new HorizontalLayout();
		root.setSizeFull();

		final TextField searchField = new TextField();
		searchField.setPlaceholder("Nach Vor- oder Nachnamen suchen...");
		searchField.setIcon(VaadinIcons.SEARCH);
		searchField.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		searchField.setSizeFull();

		final Button newUserBtn = new Button("Neues Mitglied", VaadinIcons.USER);
		root.addComponents(searchField, newUserBtn);
		root.setComponentAlignment(newUserBtn, Alignment.MIDDLE_RIGHT);
		root.setExpandRatio(searchField, 1);
		root.setMargin(new MarginInfo(false, false, true, false));

		return root;
	}

}

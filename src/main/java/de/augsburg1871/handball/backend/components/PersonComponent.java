package de.augsburg1871.handball.backend.components;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import de.augsburg1871.handball.backend.model.Person;

public class PersonComponent extends Panel {

	private static final long serialVersionUID = -7676407736891380314L;

	private final Person person;

	public PersonComponent(final Person person) {
		this.person = person;
		createLayout();
	}

	private void createLayout() {
		final HorizontalLayout root = new HorizontalLayout();
		root.setSizeFull();
		root.setSpacing(true);
		root.setMargin(true);

		final VerticalLayout rows = new VerticalLayout();
		rows.setSpacing(false);
		rows.setMargin(false);

		final HorizontalLayout name = new HorizontalLayout();
		name.addComponents(new Label(person.getLastName() + ", " + person.getFirstName()));
		rows.addComponents(name);

		final Button actions = new Button(VaadinIcons.ELLIPSIS_DOTS_H);
		actions.setPrimaryStyleName(ValoTheme.BUTTON_BORDERLESS);

		root.addComponents(rows, actions);
		root.setExpandRatio(rows, 1);

		root.setComponentAlignment(actions, Alignment.MIDDLE_CENTER);

		setContent(root);
	}

}

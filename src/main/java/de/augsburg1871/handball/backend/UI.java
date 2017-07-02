package de.augsburg1871.handball.backend;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import de.augsburg1871.handball.backend.views.MembersView;

@SpringUI
@SpringViewDisplay
public class UI extends com.vaadin.ui.UI implements ViewDisplay {

	private static final long serialVersionUID = -8609796182592207322L;

	private CssLayout menuItems;
	private VerticalLayout content;

	@Override
	protected void init(final VaadinRequest request) {
		Responsive.makeResponsive(this);
		addStyleName(ValoTheme.UI_WITH_MENU);

		menuItems = new CssLayout();

		final HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setSizeFull();

		final CssLayout menu = new CssLayout();
		menu.setPrimaryStyleName(ValoTheme.MENU_ROOT);

		final CssLayout menuPart = new CssLayout();
		menuPart.setStyleName(ValoTheme.MENU_PART);

		final HorizontalLayout menuHeader = new HorizontalLayout();
		menuHeader.setPrimaryStyleName(ValoTheme.MENU_TITLE);
		final Button menuBtn = new Button("Menü", VaadinIcons.MENU);
		menuBtn.setPrimaryStyleName("valo-menu-toggle");
		menuHeader.addComponents(menuBtn, new Label("1871 Backend"));
		menuPart.addComponent(menuHeader);

		menuItems.setPrimaryStyleName("valo-menuitems");

		final Button membersBtn = new Button("Mitglieder", VaadinIcons.USER);
		addMenuItem(membersBtn, l -> getNavigator().navigateTo("members"));

		menuPart.addComponent(menuItems);

		menu.addComponent(menuPart);

		content = new VerticalLayout();
		content.setSizeFull();
		content.setSpacing(false);
		content.setMargin(false);
		content.addComponent(new Label("Hello World!"));

		horizontalLayout.addComponents(menu, content);
		horizontalLayout.setExpandRatio(content, 1);

		setContent(horizontalLayout);

		getNavigator().navigateTo(MembersView.VIEW_NAME);
		// getNavigator().navigateTo("scroll");
	}

	private void addMenuItem(final Button menuItem, final ClickListener clickListener) {
		menuItem.setPrimaryStyleName(ValoTheme.MENU_ITEM);

		if (clickListener != null) {
			menuItem.addClickListener(clickListener);
		}

		menuItems.addComponent(menuItem);
	}

	@Override
	public void showView(final View view) {
		content.removeAllComponents();
		content.addComponent((Component) view);
	}

}

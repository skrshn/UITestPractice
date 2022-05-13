package steps;

import pages.*;

public class PageInitializers {
    public static HomePage homePage;
    public static ControlsPage controlsPage;
    public static AjaxCallPage ajaxCallPage;
    public static FormPage formPage;
    public static ActionsPage actionsPage;
    public static SelectPage selectPage;
    public static SwitchToPage switchToPage;
    public static WidgetsPage widgetsPage;

    public static void initializePageObjects() {
        homePage = new HomePage();
        controlsPage = new ControlsPage();
        ajaxCallPage = new AjaxCallPage();
        formPage = new FormPage();
        actionsPage = new ActionsPage();
        selectPage = new SelectPage();
        switchToPage = new SwitchToPage();
        widgetsPage = new WidgetsPage();
    }
}

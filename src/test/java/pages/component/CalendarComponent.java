package pages.component;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(String.format("[class^='react-datepicker__day '][aria-label*='%s %s']", month, day)).click();
    }
}

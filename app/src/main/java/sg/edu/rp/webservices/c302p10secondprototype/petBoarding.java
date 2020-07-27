package sg.edu.rp.webservices.c302p10secondprototype;

public class petBoarding {
    private String date, days, name, type;
    private boolean vaccinated;

    public petBoarding(String name, String days, String type, String date, boolean vaccinated) {
        this.date = date;
        this.days = days;
        this.name = name;
        this.type = type;
        this.vaccinated = vaccinated;
    }

    public petBoarding() {}

    public String getDate() {
        return date;
    }

    public String getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }
}

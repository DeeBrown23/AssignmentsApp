import java.util.ArrayList;

public class Week {
    Main.Days firstDay = Main.Days.Monday;
    Main.Days secondDay = Main.Days.Tuesday;
    Main.Days thirdDay = Main.Days.Wednesday;
    Main.Days fourthDay = Main.Days.Thursday;
    Main.Days fifthDay = Main.Days.Friday;
    Main.Days sixthDay = Main.Days.Saturday;
    Main.Days seventhDay = Main.Days.Sunday;
    ArrayList<Main.Days> weekDays = new ArrayList<>();
    ArrayList<Main.Days> weekend = new ArrayList<>();

    public Week() {
        this.firstDay = firstDay;
        this.secondDay = secondDay;
        this.thirdDay = thirdDay;
        this.fourthDay = fourthDay;
        this.fifthDay = fifthDay;
        this.sixthDay = sixthDay;
        this.seventhDay = seventhDay;
    }

    @Override
    public String toString() {
        return "Week{" +
                "firstDay=" + firstDay +
                ", secondDay=" + secondDay +
                ", thirdDay=" + thirdDay +
                ", fourthDay=" + fourthDay +
                ", fifthDay=" + fifthDay +
                ", sixthDay=" + sixthDay +
                ", seventhDay=" + seventhDay +
                ", weekDays=" + weekDays +
                ", weekend=" + weekend +
                '}';
    }

    public Main.Days getFirstDay() {
        return firstDay;
    }

    public Main.Days getSecondDay() {
        return secondDay;
    }

    public Main.Days getThirdDay() {
        return thirdDay;
    }

    public Main.Days getFourthDay() {
        return fourthDay;
    }

    public Main.Days getFifthDay() {
        return fifthDay;
    }

    public Main.Days getSixthDay() {
        return sixthDay;
    }

    public Main.Days getSeventhDay() {
        return seventhDay;
    }

    public ArrayList<Main.Days> getWeekdays() {
        weekDays.add(firstDay);
        weekDays.add(secondDay);
        weekDays.add(thirdDay);
        weekDays.add(fourthDay);
        weekDays.add(fifthDay);
        return weekDays;
    }

    public ArrayList<Main.Days> getWeekend() {
        weekend.add(fifthDay);
        weekend.add(sixthDay);
        weekend.add(seventhDay);
        return weekend;
    }
}

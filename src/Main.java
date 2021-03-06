import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");

        //Output the current date-time.
        LocalDateTime today = LocalDateTime.now();
        System.out.println("\nThe current date-time is " + today);

        //Output tomorrow's date using a formatter.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.format(formatter);
        System.out.println("Tomorrow's formatted date is " + formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeksLater = today.plusWeeks(5);
        System.out.println("The five weeks, the date will be " + fiveWeeksLater);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
        LocalDateTime birthDate = LocalDateTime.of(1995, 12, 10, 12, 35);
        System.out.println("Your birthdate is " + birthDate);

        //Output the day of the week (Sunday-Saturday) that you were born.
        System.out.println("The day of the week of your birthdate was " + birthDate.getDayOfWeek());

        //Output the number of days you've been alive.
        System.out.println("The number of days you have been alive is " + ChronoUnit.DAYS.between(birthDate, today) + " days.");

        //Output the number of days between two dates.
        LocalDateTime obamaInauguration = LocalDateTime.of(2009, 2, 20, 12, 0);
        System.out.println("The number of days between your birthdate and Obama's inauguration is " + ChronoUnit.DAYS.between(birthDate, obamaInauguration) + " days.");

        //Given two dates, output the earlier.
        System.out.println("The earlier date is " + FindEarlierDate(today, obamaInauguration));

        //Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        ArrayList<LocalDateTime> hundredRandomDates = randomDateArray(100);
        hundredRandomDates.forEach(d -> System.out.println("Date is " + d));

        //Output the number of stored dates in the year [Y].
        System.out.print("\nWhat is the year you want to find the dates of? ");
        ArrayList<LocalDateTime> datesOfUserYear = searchByYear(hundredRandomDates, sc.nextInt());
        System.out.println("The number of dates with that year is " + datesOfUserYear.size());

        //Count the number of stored dates in the current year.
        ArrayList<LocalDateTime> datesOfCurrentYear = searchByYear(hundredRandomDates, today.getYear());
        System.out.println("\nThe number of dates in the current year is " + datesOfCurrentYear.size());

        //Count the number of duplicates.
        ArrayList<LocalDateTime> duplicatedDates = seekDuplicates(hundredRandomDates);
        System.out.println("\nThere are " + duplicatedDates.size() + " duplicated dates.");

        // Sort the dates in chronological order.
        Collections.sort(hundredRandomDates);
        System.out.println("\nThe sorted dates are as followed: ");
        hundredRandomDates.forEach(d -> System.out.println(d));

        //Count the number of duplicates in a sorted list without using a Java Set.
        System.out.println("\nWithout using a Set, the number of duplicated dates are " + countDuplicates(hundredRandomDates));

        //Count the number of evening (after 6pm) dates.
        ArrayList<LocalDateTime> eveningDates = searchDatesInTimeframe(hundredRandomDates, 18, 24);
        System.out.println("\nThe number of evening dates are " + eveningDates.size());

        //Count the number of dates in each of the individual 12 months without using a Java Map.
        System.out.print("\nWhat is the number of the month you are searching the dates for? ");
        int month = sc.nextInt();
        if (month > 12 || month < 1) System.out.println("That month value is not valid.");
        else {
            ArrayList<LocalDateTime> datesOfMonth = searchByMonth(hundredRandomDates, month);
            System.out.println("The number of dates in month " + month + " is " + datesOfMonth.size());
        }

        //Count the number of dates in each of the individual 12 months using a Java Map.
        if (month >= 1 && month <= 12) {
            System.out.println("Using a Java Map, the number of dates in month " + month + " is " + mapByMonthSearch(hundredRandomDates, month));
        }

        //Determine the index of the latest LocalDateTime.
        System.out.println("\nThe index of the latest LocalDateTime is " + indexLatestDate(hundredRandomDates));

        //Determine the indexes of the elements that have the earliest starting time, regardless of date.
        System.out.println("\nThe index of the date with the earliest starting time is " + indexEarliestTime(hundredRandomDates));

        //Output a date in the format "January 1st, 2018".
        System.out.print("\nWhat is the index of the date you want to be outputted in the format \"January 1st, 2018\"? ");
        System.out.println("The formatted date is " + formattedDate(hundredRandomDates.get(sc.nextInt())));

        //Output Weekdays
        ArrayList<Days> weekday = new ArrayList<>();
        System.out.println("This is the weekdays: " + showWeekeday(weekday));

        //Output Weekend
        ArrayList<Days> weekend = new ArrayList<>();
        System.out.println("This is the weekdays: " + showWeekend(weekend));

        //Output Monday Classes
        ArrayList<Courses> mondayClasses = new ArrayList<>();
        System.out.println("These are your monday classes: " +showMondayClasses(mondayClasses));

        //Output Wednesday Classes
        ArrayList<Courses> wednesdayClasses = new ArrayList<>();
        System.out.println("These are your wednesday classes: " +showWednesdayClasses(wednesdayClasses));

        //Output Friday Classes
        ArrayList<Courses> fridayClasses = new ArrayList<>();
        System.out.println("These are your friday classes: " +showFridayClasses(fridayClasses));

        //Output Points Category
        ArrayList<Category> pointsCategory =new ArrayList<>();
        System.out.println("These are the categories for points: " +showPointsCategory(pointsCategory));

        //Output Assign1
        int prority = rand.nextInt(3);
        LocalDateTime meet = randomDateGenerator();
        Courses course = randomCourseGenerator();
        Category category = randomCategoryGenerator();
        Assignment assign1 = new Assignment(meet, course, category, prority);
        System.out.println("This is your schedule: " +assign1);

        //Output Assign2
        int prority2 = rand.nextInt(3);
        LocalDateTime meet2 = randomDateGenerator();
        Courses course2 = randomCourseGenerator();
        Category category2 = randomCategoryGenerator();
        Assignment assign2 = new Assignment(meet2, course2, category2, prority2);
        System.out.println("This is your schedule: " +assign2);

        //Output Assign3
        int prority3 = prority;
        LocalDateTime meet3 = meet;
        Courses course3 = course;
        Category category3 = category;
        Assignment assign3 = new Assignment(meet3, course3, category3, prority3);
        System.out.println("This is your schedule: " +assign3);

        //Output Earliest
        System.out.println("This is your earliest class: " +whichIsEarlier(meet, meet2, meet3));

        //Create file with 100 random Assignments
        System.out.println("How many assignments do you wanna generate? ");
        int numElements = sc.nextInt();
        ArrayList<Assignment> hundredRandomAssignments = randomAssignmentArray(numElements);
        hundredRandomAssignments.forEach(d -> System.out.println("assignment is: " + d));

        //file without duplicates
        Set<Assignment> withoutDuplicates = removeDuplicates(hundredRandomAssignments);
        withoutDuplicates.forEach(d -> System.out.println("Non-Duplicate Assignment is: " +d));

        //number assignment for course
        System.out.println("What course are you looking for: ");
        String courseName = sc.next();
        int numberOfCourses = searchByCourse(withoutDuplicates, courseName);
        System.out.println("The number of course with that name is " + numberOfCourses);

        //what are user course assignments
        System.out.println("What course are you looking for: ");
        String userCourse = sc.next();
        ArrayList<Assignment> courseAssignment = countAssignments(hundredRandomAssignments, userCourse);
        System.out.println("The Assignments for " +userCourse + " are: " +courseAssignment);











    }

    private static String formattedDate(LocalDateTime date) {
        String newDate = "";
        newDate += date.format(DateTimeFormatter.ofPattern("MMMM "));
        newDate += intToOrdinal(date.getDayOfMonth());
        newDate += date.format(DateTimeFormatter.ofPattern(", yyyy"));
        return newDate;
    }

    private static String intToOrdinal(int num) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        //I probably should have made this into a switch/case.
        if (num % 100 == 11 || num % 100 == 12 || num % 100 == 13) {
            return num + "th";
        } else {
            return num + suffixes[num % 10];
        }
    }

    private static Integer indexEarliestTime(ArrayList<LocalDateTime> dateList) {
        LocalDateTime earliestDateTime = dateList.get(0);
        for (LocalDateTime date : dateList) {
            if (earliestDateTime.toLocalTime().isAfter(date.toLocalTime())) earliestDateTime = date;
        }
        return dateList.indexOf(earliestDateTime);
    }

    private static Integer indexLatestDate(ArrayList<LocalDateTime> dateList) {
        return dateList.indexOf(Collections.max(dateList));
    }

    private static Integer mapByMonthSearch(ArrayList<LocalDateTime> dateList, int month) {
        return mapByMonth(dateList).get(month);
    }

    private static Map<Integer, Integer> mapByMonth(ArrayList<LocalDateTime> dateList) {
        Map<Integer, Integer> returnMap = new HashMap<>();
        for (LocalDateTime date : dateList) {
            Integer count = returnMap.get(date.getMonthValue());
            returnMap.put(date.getMonthValue(), (count == null) ? 1 : count + 1);
        }
        return returnMap;
    }

    private static ArrayList<LocalDateTime> searchByMonth(ArrayList<LocalDateTime> dateList, int month) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getMonthValue() == month)
                .collect(Collectors.toList());
    }

    private static ArrayList searchDatesInTimeframe(ArrayList<LocalDateTime> dateList, int startHour, int endHour) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getHour() >= startHour && date.getHour() < endHour)
                .collect(Collectors.toList());
    }

    private static int countDuplicates(ArrayList<LocalDateTime> hundredRandomDates) {
        int count = 0;
        for (LocalDateTime date : hundredRandomDates) {
            if (Collections.frequency(hundredRandomDates, date) >= 2) count++;
        }
        return count;
    }


    private static ArrayList<LocalDateTime> seekDuplicates(ArrayList<LocalDateTime> userList) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        Set<LocalDateTime> dateSet = new HashSet<>();
        for (LocalDateTime date : userList) {
            if (dateSet.contains(date)) returnArray.add(date);
            dateSet.add(date);
        }
        return returnArray;
    }

    private static ArrayList<LocalDateTime> searchByYear(ArrayList<LocalDateTime> listOfLocalDateTimes, int year) {
        return (ArrayList) listOfLocalDateTimes.stream()
                .filter(date -> date.getYear() == year)
                .collect(Collectors.toList());
    }

    private static ArrayList<LocalDateTime> randomDateArray(int NumElements) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        for (int i = 0; i < NumElements; i++) {
            returnArray.add(randomDateGenerator());
        }
        return returnArray;
    }

    private static LocalDateTime randomDateGenerator() {
        long startOfTime = ChronoUnit.MINUTES.between(LocalDateTime.of(0, 1, 1, 0, 0), LocalDateTime.now());
        long minutes = rand.nextInt((int) startOfTime);
        return LocalDateTime.now().minusMinutes(minutes);
    }

    private static LocalDateTime FindEarlierDate(LocalDateTime date1, LocalDateTime date2) {
        LocalDateTime earlyDate = date1;
        if (date2.isBefore(date1)) {
            earlyDate = date2;
        }
        return earlyDate;
    }

    public enum Days {
        Sunday, Monday, Tuesday, Wednesday, Thursday,
        Friday, Saturday

    }

    public static ArrayList<Days> showWeekeday(ArrayList<Days> weekday) {
        weekday.add(Days.Monday);
        weekday.add(Days.Tuesday);
        weekday.add(Days.Wednesday);
        weekday.add(Days.Thursday);
        return weekday;
    }

    public static ArrayList<Days> showWeekend(ArrayList<Days> weekend) {
        weekend.add(Days.Friday);
        weekend.add(Days.Saturday);
        weekend.add(Days.Sunday);
        return weekend;
    }

    public enum Courses {
        Data_Structures, Spanish, Stats, Political_Science
    }

    public static ArrayList<Courses> showMondayClasses(ArrayList<Courses> mondayClasses) {
        mondayClasses.add(Courses.Data_Structures);
        mondayClasses.add(Courses.Spanish);
        mondayClasses.add(Courses.Stats);
        mondayClasses.add(Courses.Political_Science);
        return mondayClasses;
    }

    public static ArrayList<Courses> showWednesdayClasses(ArrayList<Courses> wednesdayClasses) {
        wednesdayClasses.add(Courses.Data_Structures);
        wednesdayClasses.add(Courses.Spanish);
        wednesdayClasses.add(Courses.Stats);
        wednesdayClasses.add(Courses.Political_Science);
        return wednesdayClasses;
    }

    public static ArrayList<Courses> showFridayClasses(ArrayList<Courses> fridayClasses) {
        fridayClasses.add(Courses.Data_Structures);
        fridayClasses.add(Courses.Spanish);
        fridayClasses.add(Courses.Stats);
        return fridayClasses;
    }

    public static Courses randomCourseGenerator(){
        int pick = new Random().nextInt(Courses.values().length);
        return Courses.values()[pick];
    }

    public enum Category {
        Homework, Quiz, Test, Presentation, Final_Exam
    }

    public static ArrayList<Category> showPointsCategory(ArrayList<Category> pointsCategory){
        pointsCategory.add(Category.Homework);
        pointsCategory.add(Category.Quiz);
        pointsCategory.add(Category.Test);
        pointsCategory.add(Category.Presentation);
        pointsCategory.add(Category.Final_Exam);
        return pointsCategory;
    }

    public static Category randomCategoryGenerator(){
        int pick = new Random().nextInt(Category.values().length);
        return Category.values()[pick];
    }

    public static LocalDateTime whichIsEarlier(LocalDateTime meet, LocalDateTime meet2, LocalDateTime meet3){
            int answer1 = meet.compareTo(meet2);
            int answer2 = meet2.compareTo(meet);
            LocalDateTime finalAnswer = null;
            if (answer1 < answer2) {
                finalAnswer = meet;
            }
            if (answer2 < answer1) {
                 finalAnswer = meet2;
            }
            return finalAnswer;

    }

    public static Assignment randomAssignmentGenerator(){
        int prority = rand.nextInt(3);
        LocalDateTime meet = randomDateGenerator();
        Courses course = randomCourseGenerator();
        Category category = randomCategoryGenerator();
        Assignment assign = new Assignment(meet, course, category, prority);
        return assign;
    }



    public static ArrayList<Assignment> randomAssignmentArray(int numElements) {
        ArrayList<Assignment> returnArray = new ArrayList<>();
        for (int i = 0; i < numElements; i++) {
            returnArray.add(randomAssignmentGenerator());
        }
        return returnArray;
    }

    public static Set<Assignment> removeDuplicates(ArrayList<Assignment> hundredRandomAssignments){
        Set<Assignment> dateSet = new HashSet<>();
        for (Assignment assignment : hundredRandomAssignments) {
            if (dateSet.contains(assignment))
            dateSet.add(assignment);
        }
        return dateSet;
    }

    public static int searchByCourse(Set<Assignment> withoutDuplicates, String courseName) {
        Set<Assignment> dataSet = new HashSet<>();
        for (Assignment assignment : withoutDuplicates) {
            if (!dataSet.contains(courseName))
                dataSet.add(assignment);
        }
        return dataSet.size();
    }

    public static ArrayList<Assignment> countAssignments(ArrayList<Assignment> hundredRandomAssignments, String userCourse) {
        ArrayList<Assignment> courseAssignment = new ArrayList<>();
        for (Assignment assignment : hundredRandomAssignments) {
            if (hundredRandomAssignments.contains(userCourse))
                courseAssignment.add(assignment);
        }
        return courseAssignment;
    }



    public static class Assignment{
        public LocalDateTime courseMeet;
        public Courses mycourses;
        public Category points;
        public int priority;


        public Assignment(LocalDateTime date, Courses courses, Category category, int priority) {
            this.courseMeet = date;
            this.mycourses = courses;
            this.points = category;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Assignment{" +
                    "courseMeet = " + courseMeet +
                    ", mycourses = " + mycourses +
                    ", points = " + points +
                    ", priority = " + priority +
                    '}';
        }
        public int compareTo(Object obj){
            if (obj.equals(courseMeet)){
                return 0;
            }
            int answer = courseMeet.compareTo((ChronoLocalDateTime<?>) obj);
            return answer;



        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }



        }
    }





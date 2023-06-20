package home_work_8.ex2;

public class Worker implements  Comparable<Worker>{
    private String surnameInitials;
    private String position;
    private int yearStartWork;

    public Worker(String surnameInitials, String position, int yearStartWork){
        this.surnameInitials = surnameInitials;
        this.position = position;
        this.yearStartWork = yearStartWork;
    }

    public String getSurnameInitials() {
        return surnameInitials;
    }

    public int getYearStartWork() {
        return yearStartWork;
    }

    @Override
    public String toString() {
        return "Прізвище та ініціали працівника='" + surnameInitials + '\'' +
                ", назва посади='" + position + '\'' +
                ", рік надходження на роботу=" + yearStartWork;
    }

    @Override
    public int compareTo(Worker worker) {
        return this.surnameInitials.compareTo(worker.surnameInitials);
    }
}

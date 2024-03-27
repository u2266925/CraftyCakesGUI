package Model;

public class QualityControl extends Employee {
    public QualityControl(String employeeName, int cakesCovered) {
        super(employeeName, cakesCovered);
    }

    @Override
    public double calculateWage() {
        return super.calculateWage() * 1.12;
    }

    @Override
    public void display() {
        System.out.println(String.format("|   %-7sQC   |      %-8s |  %6s  |", this.getEmployeeName(),
                this.getCakesCovered(), money.format(this.calculateWage())));
    }
}

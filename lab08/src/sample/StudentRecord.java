package sample;
public class StudentRecord{
    protected String studentId;
    protected double midterm;
    protected double assignments;
    protected double exam;
    protected double mark;
    protected char letterGrade;

    public StudentRecord(String studentId, double midterm, double assignments,
                         double exam){
        this.studentId = studentId;
        this.midterm = midterm;
        this.assignments = assignments;
        this.exam = exam;
        setMark(this.midterm,this.assignments,this.exam);
        setLetterGrade(this.mark);
    }
    public void setMark(double midterm, double assignments, double exam){
        mark = ((.2 * assignments) + (.3*midterm) + (.5*exam)) ;
    }
    public void setLetterGrade(double mark){
        if (mark >= 80){
            letterGrade = 'A';
        }
        else if (mark >= 70){
            letterGrade = 'B';
        }
        else if (mark >= 60){
            letterGrade = 'C';
        }
        else if (mark >= 50){
            letterGrade = 'D';
        }
        else{
            letterGrade = 'F';
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public double getMidterm() {
        return midterm;
    }

    public double getAssignments() {
        return assignments;
    }

    public double getExam() {
        return exam;
    }

    public double getMark() {
        return mark;
    }

    public char getLetterGrade() {
        return letterGrade;
    }
}

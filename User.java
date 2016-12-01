import java.util.*;

/**
 * Created by Ruslan on 30.11.2016.
 */
public class User {

    private String name;
    private int balance;
    private int monthsOfEmployment;
    private String companyName;
    private int salary;
    private String currency;

    public User(String name, int balance, int monthsOfEmployment, String companyName, int salary, String currency) {
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
    }

    public void setMonthsOfEmployment(int monthsOfEmployment) {
        this.monthsOfEmployment = monthsOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void paySalary(){
        setBalance(getBalance() + getSalary());
    }

    /*withdraw(int summ) - снимает деньги с баланса с комиссией 5%, если сумма < 1000
        и комиссией 10% в других случаях*/
    public void withdraw(int summ){
        int summResult = 0;

        if(summ < 1000){
            summResult=summ+getSummWithProcent(summ, 5);
             /*System.out.println("summResult " + summResult);*/
        }
        else{
            summResult=summ+getSummWithProcent(summ, 10);
        }
        if (summResult>getBalance())
            System.out.println("Не достаточно денег на балансе");
        else {
            /*System.out.println("getBalance() " + getBalance());*/
            setBalance(getBalance() - summResult);
            System.out.println("Текущий баланс: "+getBalance());
        }

    }
    private int getSummWithProcent(int summ, int procent){
        /*System.out.println("% " + (int)summ/100*procent);*/
        return (int)summ/100*procent;
    }

    public void companyNameLenght(){
        System.out.println("Длина имени компании: "+ this.getCompanyName().length());
    }

    public void monthIncreaser(int addMonth){
        setMonthsOfEmployment(getMonthsOfEmployment()+addMonth);
    }

    public static void main(String[] args) {

        User user1 = new User("Anton", 500, 2, "companyName", 777, "currency");
        user1.withdraw(300);

        user1.companyNameLenght();
        user1.monthIncreaser(2);
        System.out.println("MonthsOfEmployment: "+ user1.getMonthsOfEmployment());

    }
}

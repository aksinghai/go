package all.company.com.MachineCoding.Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import all.company.com.MachineCoding.Splitwise.entity.Expense;
import all.company.com.MachineCoding.Splitwise.entity.Split;
import all.company.com.MachineCoding.Splitwise.entity.SplitType;
import all.company.com.MachineCoding.Splitwise.entity.User;
import all.company.com.MachineCoding.Splitwise.entity.UserCredit;
import all.company.com.MachineCoding.Splitwise.service.ExpenseSplitService;
import all.company.com.MachineCoding.Splitwise.service.ExpenseSplitServiceImpl;
import all.company.com.MachineCoding.Splitwise.service.UserService;
import all.company.com.MachineCoding.Splitwise.service.UserServiceImpl;


public class SplitwiseDriver {

    private static UserService userService;
    private static ExpenseSplitService expenseSplitService;

    static {
        userService = UserServiceImpl.getInstance();
        expenseSplitService = ExpenseSplitServiceImpl.getInstance();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("----------- Splitwise -----------");
        while (true){
            String input = sc.next();
            System.out.println(">>> "+input);
            switch (input) {
                case "create-user" : {
                    System.out.println("Enter Name : ");
                    String name = sc.next();
                    User user = userService.createUser(name);
                    System.out.println(user);
                    break;
                }
                case "add-expense" : {
                    System.out.println("Expense Name : ");
                    String name = sc.next();
                    System.out.println("Amount : ");
                    Double amount = sc.nextDouble();
                    System.out.println("UserId : ");
                    Integer userId = sc.nextInt();
                    System.out.println("Split Type");
                    SplitType splitType = SplitType.valueOf(sc.next());
                    System.out.println("Split between how many users :");
                    int n = sc.nextInt();
                    List<Split> splitList = new ArrayList<>();
                    for(int i = 0; i < n; i++){
                        System.out.println("UserId :");
                        Integer forUserId = sc.nextInt();
                        System.out.println("Split Value :");
                        Double splitValue  = sc.nextDouble();
                        Split split = new Split(i+1,null, splitType, splitValue, forUserId, null);
                        splitList.add(split);
                    }
                    Expense expense = expenseSplitService.addExpense(name, amount, userId, splitList);
                    System.out.println(expense);
                    break;
                }
                case "user-view" :{
                    System.out.println("UserId : ");
                    Integer userId = sc.nextInt();
                    List<UserCredit> userCreditList = userService.getUserCredit(userId);
                    System.out.println(userCreditList);
                    break;
                }
                case "exit" : {
                    return;
                }
            }
        }

    }
}

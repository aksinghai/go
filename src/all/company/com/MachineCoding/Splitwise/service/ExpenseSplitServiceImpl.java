package all.company.com.MachineCoding.Splitwise.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import all.company.com.MachineCoding.Splitwise.entity.Expense;
import all.company.com.MachineCoding.Splitwise.entity.Split;
import all.company.com.MachineCoding.Splitwise.entity.UserCredit;


public class ExpenseSplitServiceImpl implements ExpenseSplitService {

    private static ExpenseSplitService expenseSplitService;

    static Integer expenseIndex = 0;
    static Integer userCreditIndex = 0;
    static Map<Integer, Expense> expenseLookup = new HashMap<>();

    private ExpenseSplitServiceImpl() { }

    public static ExpenseSplitService getInstance() {
        if(expenseSplitService == null){
            synchronized (ExpenseSplitService.class){
                if(expenseSplitService == null){
                    expenseSplitService = new ExpenseSplitServiceImpl();
                }
            }
        }
        return expenseSplitService;
    }

    @Override public Expense getExpense(final Integer id) {
        if(expenseLookup.containsKey(id)){
            return expenseLookup.get(id);
        }
        return null;
    }

    @Override public Expense addExpense(final String name, final Double amount, final Integer userId, List<Split> splits) {
        Expense expense = new Expense(expenseIndex +1, name, amount, userId,userId);
        expenseLookup.put(expenseIndex +1, expense);
        expenseIndex++;
        Double totalAmount = amount;
        Map<Integer,Double> applyCreditMap = new HashMap<>();
        for(Split split : splits){
            split.setExpenseId(expense.getId());
            double splitAmount = getAmount(expense, split, splits.size(), split.getForUserId());
            totalAmount -= splitAmount;
            if(split.getForUserId() != expense.getPaidByUserId()){
                applyCreditMap.put(split.getForUserId(), -splitAmount);
                split.setAmount(-splitAmount);
            } else {
                split.setAmount(amount - splitAmount);
            }
        }
        if (totalAmount < .1){
            splits.get(0).setAmount(splits.get(0).getAmount() < 0 ? splits.get(0).getAmount() - totalAmount :
                    splits.get(0).getAmount() + totalAmount);
            totalAmount = 0.0;
        }

        if(totalAmount != 0){
            System.out.println("Something went wrong");
        }
        for (Map.Entry<Integer, Double> entry: applyCreditMap.entrySet()){
            if(UserServiceImpl.getInstance().getUserCreditLookup().containsKey(expense.getPaidByUserId()+"_"+entry.getKey())){
                UserCredit userCredit = UserServiceImpl.getInstance().getUserCreditLookup().get(expense.getPaidByUserId()+"_"+entry.getKey());
                userCredit.setAmount(userCredit.getAmount() + entry.getValue());
            } else {
                UserCredit userCredit = new UserCredit(userCreditIndex+1, expense.getPaidByUserId(), entry.getKey(),
                        entry.getValue());
                UserServiceImpl.getInstance().getUserCreditLookup().put(expense.getPaidByUserId()+"_"+entry.getKey(), userCredit);
            }
        }
        expense.setSplits(splits);
        return expense;
    }

    private Double getAmount(Expense expense, Split split, Integer totalSplits, Integer userId){
        switch (split.getType()){
            case PERCENTAGE:{
                return (expense.getAmount() * split.getSplitValue())/ 100;
            }
            case EQUAL: {
                return expense.getAmount() * (1/totalSplits);
            }
        }
        return 0.0;
    }
}

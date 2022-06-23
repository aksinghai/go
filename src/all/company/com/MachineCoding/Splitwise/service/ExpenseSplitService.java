package all.company.com.MachineCoding.Splitwise.service;

import java.util.List;
import all.company.com.MachineCoding.Splitwise.entity.Expense;
import all.company.com.MachineCoding.Splitwise.entity.Split;


public interface ExpenseSplitService {

    Expense getExpense(Integer id);

    Expense addExpense(String name, Double amount, Integer userId, List<Split> splits);

}

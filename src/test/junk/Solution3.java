package test.junk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class EmployeeNode {
    int id;
    String name;
    int managerId;
    String address;
    List<EmployeeNode> directReportees;

    EmployeeNode(final int id, final String name, final int managerId, final String address,
            final List<EmployeeNode> directReportees) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.address = address;
        this.directReportees = directReportees;
    }
}

public class Solution3 {
    public static void main(String[] args) {
        String[][] input = readInput();
        Map<Integer,EmployeeNode> lookup = new HashMap<>();
        EmployeeNode root = null;
        for(int i = 1; i < input.length; i++){
            int managerId = (input[i][2].isEmpty()) ? -1 : Integer.parseInt(input[i][2]);
            EmployeeNode node = new EmployeeNode(Integer.parseInt(input[i][0]), input[i][1],
                    managerId, input[i][3], new ArrayList<>());
            lookup.put(node.id, node);
            if(root == null){
                root = node;
            } else {
                if(lookup.containsKey(node.managerId)) {
                    EmployeeNode managerNode = lookup.get(node.managerId);
                    managerNode.directReportees.add(node);
                }
            }
        }
        /*System.out.println("1. CEO ");
        EmployeeNode ceoNode = getCeo(root);
        System.out.println(ceoNode == null ? "No CEO" : ceoNode.name);
        System.out.println();

        System.out.println("2. Max Depth");
        System.out.println(getDepth(root));
        System.out.println();

        //System.out.println("3. Print Max Depth");
*/
        /*System.out.println("4. Print all Reportees");
        int managerId = 4;
        if(!lookup.containsKey(2)){
            System.out.println("Manager not found");
        } else {
            printAllReportees(lookup.get(managerId).directReportees);
        }
        System.out.println();*/

        /*System.out.println("All Managers");
        for(Map.Entry<Integer, EmployeeNode> entry : lookup.entrySet()){
            if(entry.getValue().directReportees.size() > 0){
                System.out.println(entry.getValue().name);
            }
        }*/


        /*System.out.println("Employee Reciding in city");
        String cityName = "Mumbai";
        for(Map.Entry<Integer, EmployeeNode> entry : lookup.entrySet()){
            if(entry.getValue().address.equals(cityName)){
                System.out.println(entry.getValue().name);
            }
        }*/

        /*System.out.println("All Direct and Indirect Emp");
        for(Map.Entry<Integer, EmployeeNode> entry : lookup.entrySet()){
            System.out.println("For "+entry.getValue().name);
            if(!lookup.containsKey(2)){
                System.out.println("Manager not found");
            } else {
                System.out.println(countAllTheDirectAndIndirectReportees(lookup.get(entry.getKey()))-1);
            }
        }*/


        //printAllSeniorManagers(root);
        List<String> list = new ArrayList<>();
        printDepth(root, list);
        for(String l : list){
            System.out.println(l);
        }


    }

    private static EmployeeNode getCeo(EmployeeNode root){
        if(root == null){
            return null;
        }
        return root;
    }

    private static Integer getDepth(EmployeeNode root){
        if(root.directReportees.size() == 0){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < root.directReportees.size(); i++){
            max = Integer.max(getDepth(root.directReportees.get(i))+1, max);
        }
        return max;
    }

    private static Integer printDepth(EmployeeNode root, List<String> list){
        if(root.directReportees.size() == 0){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < root.directReportees.size(); i++){
            List<String> l = new ArrayList<>(list);
            l.add(root.directReportees.get(i).name);
            int d = printDepth(root.directReportees.get(i), l) + 1;
            if(max < d) {
                max = d;
                list = l;
            }
        }
        return max;
    }

    private static void printAllReportees(List<EmployeeNode> employees){
        for(EmployeeNode employeeNode : employees){
            System.out.println(employeeNode.name);
        }
    }

    private static int countAllTheDirectAndIndirectReportees(EmployeeNode node){
        if(node.directReportees.size() == 0){
            return 1;
        }
        int sum = 0;
        for(EmployeeNode employeeNode : node.directReportees){
            sum += countAllTheDirectAndIndirectReportees(employeeNode);
        }
        return sum+1;
    }

    private static void printAllSeniorManagers(EmployeeNode root){
        if(root == null || root.directReportees.size() == 0){
            return;
        }
        for(EmployeeNode n : root.directReportees){
            if(n.directReportees.size() > 0){
                System.out.println(root.name);
            }
            printAllSeniorManagers(n);
        }
    }

    /*private static void printAllTheManagers(EmployeeNode node){
        for(EmployeeNode e : node.directReportees){
            if(e.directReportees.size() > 0){
                System.out.println(e.name);
                printAllTheManagers(e);
            }
        }
    }*/

    private static String[][] readInput(){
        String[][] input= new String[][]{
                {"id","name","mgr_id","address"},
                {"2","Ratan Tata","","Mumbai"},
                {"3","Gautam Adani","2","Ahmedabad"},
                {"4","Mukesh Ambani","3","Mumbai"},
                {"5","L. N. Mittal","2","London"},
                {"6","Cyrus Poonawalla","4","Pune"}
        };
        return input;
    }
}
package all.company.com.top;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import all.company.com.common.ListNode;


public class Q23_MergeKSortedList {

    //Input
    private static ListNode[] getKSortedLists(List<List<Integer>> arrayList){
        ListNode[] listNodes = new ListNode[arrayList.size()];
        ListNode[] tail = new ListNode[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++){
            for(int j = 0; j < arrayList.get(i).size(); j++){
                ListNode node = new ListNode();
                node.setItem(arrayList.get(i).get(j));
                if(listNodes[i] == null){
                    listNodes[i] = node;
                    tail[i] = node;
                } else {
                    tail[i].setNext(node);
                    tail[i] = tail[i].getNext();
                }
            }
        }
        return listNodes;
    }

    public static void main(String[] args) {
        int K = 1;
        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(new ArrayList<>(Arrays.asList(1,4,5)));
        arrayList.add(new ArrayList<>(Arrays.asList(1,3,4)));
        arrayList.add(new ArrayList<>(Arrays.asList(2,6)));
        //arrayList.add(new ArrayList<>(Arrays.asList()));
        ListNode[] listNodes = getKSortedLists(arrayList);

        System.out.println("test");
        ListNode head = mergeKSortedListsSol1(listNodes);
        while (head != null){
            System.out.println(head.getItem());
            head = head.getNext();
        }
    }

    //Best Solution
    /*
    Hint:
    1. Find min
    2. Mark head = min
    3. find min2
    4. min.next = min2
    4. min = min2 (with j and k its index)
     */
    private static ListNode mergeKSortedListsSol1(ListNode[] lists){
        ListNode head = null;
        ListNode min1 = null;
        int j = -1;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] == null){
                continue;
            }
            if(min1 == null || (int)min1.getItem() > (int)lists[i].getItem()){
                min1 = lists[i];
                j = i;
            }
        }
        head = min1;
        if(head == null){
            return head;
        }
        int k = -1;
        while(true){
            ListNode min2 = null;
            lists[j] = lists[j].getNext();
            boolean notingMove = true;
            for(int i = 0; i < lists.length; i++){
                if(lists[i] == null){
                    continue;
                }
                if((min2 == null || (int)min2.getItem() > (int)lists[i].getItem()) && min1 != lists[i]){
                    min2 = lists[i];
                    k = i;
                    notingMove =false;
                }
            }
            if(notingMove){
                break;
            }
            min1.setNext(min2);
            j = k;
            min1 = min2;
            if(min1 == null){
                break;
            }
        }
        return head;
    }
}

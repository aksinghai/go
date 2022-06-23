package all.company.com.MachineCoding.Tinder.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import all.company.com.MachineCoding.Tinder.AppDriver;
import all.company.com.MachineCoding.Tinder.entity.User;


public class DatingServiceImpl implements DatingService {

    @Override
    public List<String> getPotentialMatch(final String userName) {
        User user = AppDriver.userService.getUser(userName);
        if(user == null){
            throw new RuntimeException("User not available");
        }
        return user.getPotentialMatches();
    }

    @Override
    public boolean likeUser(final String userName, final String toUserName) {
        User user = AppDriver.userService.getUser(userName);
        User likeUser = AppDriver.userService.getUser(toUserName);
        if(user == null || likeUser == null){
            throw new RuntimeException("User not available");
        }
        user.getLikeUserIds().add(toUserName);
        likeUser.getLikedUserIds().add(userName);
        return true;
    }

    @Override public boolean ignore(final String userName, final String toUserName) {
        User user = AppDriver.userService.getUser(userName);
        User likeUser = AppDriver.userService.getUser(toUserName);
        if(user == null || likeUser == null){
            throw new RuntimeException("User not available");
        }
        user.getIgnoredUserIds().add(toUserName);
        return true;
    }

    @Override public List<String> showMatches(final String userName) {
        User user = AppDriver.userService.getUser(userName);
        if(user == null){
            throw new RuntimeException("User not available");
        }
        return new ArrayList<>(user.getMatchedUserIds());
    }

    @Override public List<String> showAllMatches() {
        List<User> users = AppDriver.userService.getAllUsers();
        List<String> allMatches = new ArrayList<>();
        for(User user : users){
            Set<String> matchedUsers = user.getMatchedUserIds();
            if(matchedUsers.size() > 0){
                StringBuilder sb = new StringBuilder();
                for(String s : matchedUsers){
                    sb.append(s).append(",");
                }
                allMatches.add(user+":"+sb);
            }
        }
        return allMatches;
    }

    @Override public void setPotentialMatch(final String userName) {
        User user = AppDriver.userService.getUser(userName);
        List<User> users = AppDriver.userService.getAllUsers();
        users = filterByGender(user, users);
        sortByDistance(users);
        sortByAge(users);
        List<String> list = new ArrayList<>();
        for(User user1 : users){
            list.add(user1.getUserName());
        }
        user.setPotentialMatches(list);
    }

    private List<User> filterByGender(User user , List<User> users) {
        List<User> list = new ArrayList<>();
        for(User u : users){
            if(!user.getUserName().equals(u.getUserName()) && !user.getGender().equals(u.getGender())){
                list.add(u);
            }
        }
        return list;
    }

    private void sortByDistance(List<User> users){
        Comparator<User> userComparator = new Comparator<User>() {
            @Override public int compare(final User o1, final User o2) {
                return (int) Math.abs(Math.sqrt(Math.pow(o1.getxCoordinate() - o2.getxCoordinate(), 2) + Math.pow(o1.getyCoordinate() - o2.getyCoordinate(), 2)));
            }
        };
        users.sort(userComparator);
    }

    private void sortByAge(List<User> users){
        Comparator<User> userComparator = new Comparator<User>() {
            @Override public int compare(final User o1, final User o2) {
                return (int) Math.abs(o1.getAge() - o2.getAge());
            }
        };
        users.sort(userComparator);
    }
}

package all.company.com.MachineCoding.Tinder.service;

import java.util.List;


public interface DatingService {

    List<String> getPotentialMatch(String userName);

    boolean likeUser(String userName, String toUserName);

    boolean ignore(String userName, String toUserName);

    List<String> showMatches(String userName);

    List<String> showAllMatches();

    void setPotentialMatch(String userName);

}

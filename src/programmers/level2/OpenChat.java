package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChat {

    static class Result{
        public static String[] solution(String[] record){
            HashMap<String, User> userMap = new HashMap<>();
            List<String[]> userInfo = new ArrayList<>();

            for (String r : record) {
                String[] s = r.split(" ");
                if (s[0].equals("Change")) {
                    userMap.get(s[1]).changeName(s[2]);
                    continue;
                }

                if (s[0].equals("Enter")) {
                    User user = new User(s[1], s[2]);
                    userMap.put(s[1], user);
                }

                userInfo.add(new String[]{userMap.get(s[1]).id, s[0]});
            }

            /*String[] result = new String[userInfo.size()];
            for (int i = 0; i < userInfo.size(); i++) {
                String[] user = userInfo.get(i);
                result[i] = user[1].equals("Enter") ? userMap.get(user[0]).enter() : userMap.get(user[0]).leave();
            }*/
            return userInfo.stream()
                    .map(user -> user[1].equals("Enter") ? userMap.get(user[0]).enter() : userMap.get(user[0]).leave())
                    .toArray(arr -> new String[userInfo.size()]);
        }
        
        static class User{
            String id;
            String username;

            public User(String id, String username) {
                this.id = id;
                this.username = username;
            }

            public void changeName(String username){
                this.username = username;
            }

            public String enter(){
                return username + "님이 들어왔습니다.";
            }

            public String leave(){
                return username + "님이 나갔습니다.";
            }
        }
    }
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi"
                , "Enter uid4567 Prodo"
                , "Leave uid1234"
                , "Enter uid1234 Prodo"
                , "Change uid4567 Ryan"};

        String[] solution = Result.solution(record);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}

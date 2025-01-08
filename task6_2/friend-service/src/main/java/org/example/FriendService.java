package org.example;

import java.util.List;

public interface FriendService {
  void addFriend(String userId, String friendId);
  List<String> getFriends(String userId);
}

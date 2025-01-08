package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendServiceImpl implements FriendService {

  private final ProfileService profileService;
  private final Map<String, List<String>> friendsMap = new HashMap<>();

  public FriendServiceImpl(ProfileService profileService) {
    this.profileService = profileService;
  }

  @Override
  public void addFriend(String userId, String friendId) {
    if (profileService.getProfile(userId) == null || profileService.getProfile(friendId) == null) {
      throw new IllegalArgumentException("Один из профилей не найден");
    }

    friendsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(friendId);
  }

  @Override
  public List<String> getFriends(String userId) {
    return friendsMap.getOrDefault(userId, new ArrayList<>());
  }
}

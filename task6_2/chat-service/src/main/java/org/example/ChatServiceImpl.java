package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServiceImpl implements ChatService {

  private final FriendService friendService;
  private final Map<String, StringBuilder> messageHistory = new HashMap<>();

  public ChatServiceImpl(FriendService friendService) {
    this.friendService = friendService;
  }

  @Override
  public void sendMessage(String fromUserId, String toUserId, String message) {
    List<String> friends = friendService.getFriends(fromUserId);
    if (!friends.contains(toUserId)) {
      throw new IllegalArgumentException("Пользователь не является другом");
    }

    messageHistory.computeIfAbsent(toUserId, k -> new StringBuilder())
        .append(fromUserId).append(": ").append(message).append("\n");
  }

  @Override
  public String getMessages(String userId) {
    return messageHistory.getOrDefault(userId, new StringBuilder()).toString();
  }
}

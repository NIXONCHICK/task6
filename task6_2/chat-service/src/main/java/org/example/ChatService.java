package org.example;

public interface ChatService {
  void sendMessage(String fromUserId, String toUserId, String message);
  String getMessages(String userId);
}

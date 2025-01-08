package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ChatServiceImplTest {

  private ChatService chatService;
  private FriendService friendService;

  @BeforeEach
  public void setUp() {
    friendService = mock(FriendService.class); // Создаём mock-объект FriendService
    chatService = new ChatServiceImpl(friendService);
  }

  @Test
  public void testSendMessage() {
    when(friendService.getFriends("user1")).thenReturn(List.of("user2"));

    chatService.sendMessage("user1", "user2", "Hello!");
    String messages = chatService.getMessages("user2");

    assertTrue(messages.contains("Hello!"));
  }

  @Test
  public void testSendMessageToNonFriend() {
    when(friendService.getFriends("user1")).thenReturn(List.of());

    assertThrows(IllegalArgumentException.class, () -> chatService.sendMessage("user1", "user2", "Hi!"));
  }
}

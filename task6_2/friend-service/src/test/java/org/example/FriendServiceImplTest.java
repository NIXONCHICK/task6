package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FriendServiceImplTest {

  private FriendService friendService;
  private ProfileService profileService;

  @BeforeEach
  public void setUp() {
    profileService = mock(ProfileService.class);
    friendService = new FriendServiceImpl(profileService);
  }

  @Test
  public void testAddAndGetFriends() {
    when(profileService.getProfile("user1")).thenReturn(new Profile("user1", "John Doe"));
    when(profileService.getProfile("user2")).thenReturn(new Profile("user2", "Jane Doe"));

    friendService.addFriend("user1", "user2");
    List<String> friends = friendService.getFriends("user1");

    assertEquals(1, friends.size());
    assertEquals("user2", friends.get(0));
  }

  @Test
  public void testAddFriendWithNonExistentProfile() {
    when(profileService.getProfile("user1")).thenReturn(null);

    assertThrows(IllegalArgumentException.class, () -> friendService.addFriend("user1", "user2"));
  }
}

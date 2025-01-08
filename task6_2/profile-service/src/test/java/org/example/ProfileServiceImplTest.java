package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProfileServiceImplTest {

  private ProfileService profileService;

  @BeforeEach
  public void setUp() {
    profileService = new ProfileServiceImpl();
  }

  @Test
  public void testCreateAndGetProfile() {
    Profile profile = new Profile("1", "John Doe");
    profileService.createProfile(profile);

    Profile retrievedProfile = profileService.getProfile("1");
    assertNotNull(retrievedProfile);
    assertEquals("John Doe", retrievedProfile.getName());
  }

  @Test
  public void testGetNonExistentProfile() {
    Profile retrievedProfile = profileService.getProfile("non-existent-id");
    assertNull(retrievedProfile);
  }
}

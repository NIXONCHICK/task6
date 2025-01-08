package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProfileServiceImpl implements ProfileService {
  private final Map<String, Profile> profiles = new HashMap<>();

  @Override
  public void createProfile(Profile profile) {
    profiles.put(profile.getId(), profile);
  }

  @Override
  public Profile getProfile(String id) {
    return profiles.get(id);
  }
}

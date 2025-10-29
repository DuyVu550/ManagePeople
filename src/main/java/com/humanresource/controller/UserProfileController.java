package com.humanresource.controller;

import com.humanresource.dto.CreateUserProfileDTO;
import com.humanresource.dto.UpdateUserProfileDTO;
import com.humanresource.dto.UserProfileDTO;
import com.humanresource.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user-profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public ResponseEntity<List<UserProfileDTO>> getAllUserProfiles() {
        List<UserProfileDTO> profiles = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfileById(@PathVariable Long id) {
        UserProfileDTO profile = userProfileService.getUserProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @PostMapping
    public ResponseEntity<UserProfileDTO> createUserProfile(@Valid @RequestBody CreateUserProfileDTO createDTO) {
        UserProfileDTO createdProfile = userProfileService.createUserProfile(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateUserProfile(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUserProfileDTO updateDTO) {
        UserProfileDTO updatedProfile = userProfileService.updateUserProfile(id, updateDTO);
        return ResponseEntity.ok(updatedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User profile deleted successfully");
        response.put("id", id.toString());
        return ResponseEntity.ok(response);
    }
}

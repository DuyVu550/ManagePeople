package com.humanresource.service;

import com.humanresource.dto.CreateUserProfileDTO;
import com.humanresource.dto.UpdateUserProfileDTO;
import com.humanresource.dto.UserProfileDTO;
import com.humanresource.entity.UserProfile;
import com.humanresource.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public List<UserProfileDTO> getAllUserProfiles() {
        return userProfileRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserProfileDTO getUserProfileById(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found with id: " + id));
        return convertToDTO(userProfile);
    }

    public UserProfileDTO createUserProfile(CreateUserProfileDTO createDTO) {
        if (userProfileRepository.existsByEmail(createDTO.getEmail())) {
            throw new RuntimeException("Email already exists: " + createDTO.getEmail());
        }

        UserProfile userProfile = convertToEntity(createDTO);
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        return convertToDTO(savedProfile);
    }

    public UserProfileDTO updateUserProfile(Long id, UpdateUserProfileDTO updateDTO) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found with id: " + id));

        // Check if email is being updated and if it already exists
        if (updateDTO.getEmail() != null &&
                !updateDTO.getEmail().equals(userProfile.getEmail()) &&
                userProfileRepository.existsByEmail(updateDTO.getEmail())) {
            throw new RuntimeException("Email already exists: " + updateDTO.getEmail());
        }

        // Update fields
        if (updateDTO.getFirstName() != null) {
            userProfile.setFirstName(updateDTO.getFirstName());
        }
        if (updateDTO.getLastName() != null) {
            userProfile.setLastName(updateDTO.getLastName());
        }
        if (updateDTO.getEmail() != null) {
            userProfile.setEmail(updateDTO.getEmail());
        }
        if (updateDTO.getPhone() != null) {
            userProfile.setPhone(updateDTO.getPhone());
        }
        if (updateDTO.getAddress() != null) {
            userProfile.setAddress(updateDTO.getAddress());
        }
        if (updateDTO.getDateOfBirth() != null) {
            userProfile.setDateOfBirth(updateDTO.getDateOfBirth());
        }
        if (updateDTO.getDepartment() != null) {
            userProfile.setDepartment(updateDTO.getDepartment());
        }
        if (updateDTO.getPosition() != null) {
            userProfile.setPosition(updateDTO.getPosition());
        }

        UserProfile updatedProfile = userProfileRepository.save(userProfile);
        return convertToDTO(updatedProfile);
    }

    public void deleteUserProfile(Long id) {
        if (!userProfileRepository.existsById(id)) {
            throw new RuntimeException("User profile not found with id: " + id);
        }
        userProfileRepository.deleteById(id);
    }

    private UserProfileDTO convertToDTO(UserProfile userProfile) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(userProfile.getId());
        dto.setFirstName(userProfile.getFirstName());
        dto.setLastName(userProfile.getLastName());
        dto.setEmail(userProfile.getEmail());
        dto.setPhone(userProfile.getPhone());
        dto.setAddress(userProfile.getAddress());
        dto.setDateOfBirth(userProfile.getDateOfBirth());
        dto.setDepartment(userProfile.getDepartment());
        dto.setPosition(userProfile.getPosition());
        dto.setCreatedAt(userProfile.getCreatedAt());
        dto.setUpdatedAt(userProfile.getUpdatedAt());
        return dto;
    }

    private UserProfile convertToEntity(CreateUserProfileDTO dto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(dto.getFirstName());
        userProfile.setLastName(dto.getLastName());
        userProfile.setEmail(dto.getEmail());
        userProfile.setPhone(dto.getPhone());
        userProfile.setAddress(dto.getAddress());
        userProfile.setDateOfBirth(dto.getDateOfBirth());
        userProfile.setDepartment(dto.getDepartment());
        userProfile.setPosition(dto.getPosition());
        return userProfile;
    }
}
